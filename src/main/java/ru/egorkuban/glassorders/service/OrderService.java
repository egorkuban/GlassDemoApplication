package ru.egorkuban.glassorders.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.egorkuban.glassorders.jpa.entity.CustomerEntity;
import ru.egorkuban.glassorders.jpa.entity.OrderEntity;
import ru.egorkuban.glassorders.jpa.repository.CustomerRepository;
import ru.egorkuban.glassorders.jpa.repository.OrderRepository;
import ru.egorkuban.glassorders.model.Order;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    @Transactional
    public void createOrder(Order order) {
        OrderEntity orderEntity = new OrderEntity()
                .setCount(order.getCount())
                .setPosition(order.getPosition())
                .setSum(order.getSum())
                .setDateCreate(LocalDate.now());

        CustomerEntity customer = customerRepository.getById(order.getCustomerId());

        orderEntity.setCustomer(customer);
        orderRepository.save(orderEntity);
    }

    public List<Order> getAllByCustomerId(Long id) {
        CustomerEntity customerEntity = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found by Id " + id));
       return customerEntity.getOrders().stream()
               .map(this::mapToOrder)
               .collect(Collectors.toList());
    }

    private Order mapToOrder(OrderEntity orderEntity) {
        return new Order()
                .setPosition(orderEntity.getPosition())
                .setSum(orderEntity.getSum())
                .setCount(orderEntity.getCount())
                .setId(orderEntity.getId())
                .setCreateDate(orderEntity.getDateCreate())
                .setCustomerId(orderEntity.getCustomer().getId());
    }
}
