package ru.egorkuban.glassorders.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.egorkuban.glassorders.jpa.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
