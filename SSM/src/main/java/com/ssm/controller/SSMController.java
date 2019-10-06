package com.ssm.controller;

import com.ssm.po.Customer;
import com.ssm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SSMController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("get/customer")
    @ResponseBody
    public Customer getCustomer(Integer id) {
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }

    @RequestMapping("insert/customer")
    @ResponseBody
    public Integer insertCustomer(Customer customer) {
        System.out.println(customer.toString());
        int result = customerService.insertCustomer(customer);
        return result;
    }

}
