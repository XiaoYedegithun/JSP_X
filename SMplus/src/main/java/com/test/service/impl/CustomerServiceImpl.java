package com.test.service.impl;

import com.test.mapper.CustomerMapper;
import com.test.mapper.OrderMapper;
import com.test.model.Customer;
import com.test.model.Order;
import com.test.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private OrderMapper orderMapper;
    public int save(Customer customer) {
        int n = customerMapper.insert(customer);
        if(n>0){
            List<Order> orders = customer.getOrderList();
            for (Order order : orders) {
                order.setCid(customer.getCustomerId());
            }
            orderMapper.insertOrderCustomer(customer.getOrderList());
        }
        return n;
    }

    public List<Customer> queryAll(Customer customer) {
        return customerMapper.queryAll(customer);
    }
}
