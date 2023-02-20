package com.test.service.impl;

import com.test.mapper.OrderMapper;
import com.test.model.Customer;
import com.test.model.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class CustomerServiceImplTest {
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private OrderMapper orderMapper;
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void save() {
        Customer customer=new Customer();
        customer.setCustomerName("麻辣毛蛋");
        Order order=new Order();
        order.setOrderNo("P001");
        customer.putOrder(order);
        Order order1=new Order();
        order1.setOrderNo("P002");
        customer.putOrder(order1);
        customerService.save(customer);
    }

    @Test
    public void queryAll() {
        List<Customer> customers = customerService.queryAll(null);
        System.out.println(customers);
        for (Customer c: customers){
            List<Order> orders = orderMapper.queryByCid(c.getCustomerId());
            c.setOrderList(orders);
        }
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}