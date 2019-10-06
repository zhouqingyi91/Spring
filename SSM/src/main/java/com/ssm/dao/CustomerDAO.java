package com.ssm.dao;

import com.ssm.po.Customer;

public interface CustomerDAO {
    Customer getCustomerById(Integer custId);

    Integer insertCustomer(Customer customer);
}
