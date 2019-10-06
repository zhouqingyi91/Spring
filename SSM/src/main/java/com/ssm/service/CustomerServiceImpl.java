package com.ssm.service;

import com.ssm.dao.CustomerDAO;
import com.ssm.po.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public Customer getCustomerById(Integer id) {
        Customer customer = customerDAO.getCustomerById(id);
        return customer;
    }

    @Override
    @Transactional
    public int insertCustomer(Customer customer) {
        Integer result = customerDAO.insertCustomer(customer);
//        int i = 1/0;
        return result;
    }

}
