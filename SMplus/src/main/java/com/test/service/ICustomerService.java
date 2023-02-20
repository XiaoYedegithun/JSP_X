package com.test.service;

import com.test.model.Customer;

import java.util.List;

public interface ICustomerService {
    int save(Customer customer);

    List<Customer> queryAll(Customer customer);
}
