package ru.egorkuban.glassorders.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.egorkuban.glassorders.jpa.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
