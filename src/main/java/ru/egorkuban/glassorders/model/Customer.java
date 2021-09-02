package ru.egorkuban.glassorders.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Customer {
    private Long id;
    private String firstName;
    private String secondName;
    private List<Order> orders;
}
