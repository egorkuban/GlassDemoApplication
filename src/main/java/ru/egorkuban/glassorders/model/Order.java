package ru.egorkuban.glassorders.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Accessors(chain = true)
public class Order {
    private Long id;
    private String position;
    private BigDecimal sum;
    private Integer count;
    private Long customerId;
    private LocalDate createDate;
    private Integer age;


}
