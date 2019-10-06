package com.ssm.service;

import com.ssm.po.Customer;

public interface CustomerService {
    Customer getCustomerById(Integer id);

    int insertCustomer(Customer customer);
}
