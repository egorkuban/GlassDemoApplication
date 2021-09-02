package ru.egorkuban.glassorders.jpa.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(schema = "glass", name = "order")
@Getter
@Setter
@Accessors(chain = true)
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String position;
    private BigDecimal sum;
    private Integer count;
    @Column(name = "create_date")
    private LocalDate dateCreate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

}