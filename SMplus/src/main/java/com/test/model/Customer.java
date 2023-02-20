package com.test.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Data
@ToString
@NoArgsConstructor

public class Customer {
    private Integer customerId;

    private String customerName;

    private List<Order> orderList = new ArrayList<Order>();

    public Customer(Integer customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public void putOrder(Order order){
        this.orderList.add(order);
    }

}