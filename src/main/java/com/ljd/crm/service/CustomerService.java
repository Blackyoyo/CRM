package main.java.com.ljd.crm.service;


import java.util.List;
import java.util.Map;

import main.java.com.ljd.crm.pojo.Customer;


public interface CustomerService {
    
    List<Customer> findAll();
    
    Customer findById(long id);
    
    Map<String,Object> findByName(String custName);
    
    Map<String,Object> save(Customer customer);
    
    Map<String,Object> deleteById(long id);
    
    Map<String,Object> update(Customer customer);
    
    Map<String,Object> query(Customer customer);
    
}
