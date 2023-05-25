package com.example.warehouse.services.impls;

import com.example.warehouse.dtos.orders.OrderCreateDto;
import com.example.warehouse.dtos.orders.OrderUpdateDto;
import com.example.warehouse.entities.Order;
import com.example.warehouse.entities.Product;
import com.example.warehouse.entities.Shipment;
import com.example.warehouse.entities.Stock;
import com.example.warehouse.repository.OrderDao;
import com.example.warehouse.repository.ProductDao;
import com.example.warehouse.repository.ShipmentDao;
import com.example.warehouse.repository.StockDao;
import com.example.warehouse.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;
    private final ProductDao productDao;
    private final ShipmentDao shipmentDao;
    private final StockDao stockDao;

    @Override
    @Transactional
    public Order create(OrderCreateDto orderCreateDto) {
        Shipment shipment = Shipment.builder()
                .address(orderCreateDto.getAddress())
                .contact(orderCreateDto.getContact())
                .shippingDays(orderCreateDto.getShippingDays())
                .build();
        Order order = Order.builder()
                .orderDateTime(LocalDateTime.now())
                .totalAmount(orderCreateDto.getTotalAmount())
                .totalPrice(orderCreateDto.getTotalPrice())
                .product(productDao.findById(orderCreateDto.getProductId()).orElseThrow())
                .build();
        validateOrder(order);
        order.setShipment(shipmentDao.save(shipment));

        Stock stock = stockDao.getStockByProductId(order.getProduct().getId()).orElseThrow();
        stock.decreaseQuantity(order.getTotalAmount());
        stockDao.save(stock);
        return orderDao.save(order);
    }

    @Override
    public Order getById(Integer id) {
        return orderDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void cancelOrderById(Integer id) {
        Order order = orderDao.findById(id).orElseThrow();
        deleteOrderFromProduct(order.getProduct().getId(), order);
        Integer stockId = order.getProduct().getStock().getId();
        shipmentDao.delete(order.getShipment());
        orderDao.delete(order);
        increaseStock(stockId, order.getTotalAmount());
    }

    private void validateOrder(Order order) {
        if (order.getTotalAmount() > stockDao.getStockByProductId(order.getProduct().getId()).orElseThrow().getQuantity()) {
            throw new IllegalArgumentException("Product quantity is not enough");
        }
        // TODO add extra validations
    }

    private void deleteOrderFromProduct(Integer productId, Order order) {
        Product product = productDao.findById(productId).orElseThrow();
        product.getOrders().remove(order);
        productDao.save(product);
    }

    private void increaseStock(Integer id, double quantity){
        Stock stock = stockDao.findById(id).orElseThrow();
        stock.increaseQuantity(quantity);
        stockDao.save(stock);
    }
}
