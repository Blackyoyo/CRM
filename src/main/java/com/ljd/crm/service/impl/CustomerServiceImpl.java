package main.java.com.ljd.crm.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.ljd.crm.mapper.CustomerMapper;
import main.java.com.ljd.crm.pojo.Customer;
import main.java.com.ljd.crm.pojo.CustomerExample;
import main.java.com.ljd.crm.pojo.CustomerExample.Criteria;
import main.java.com.ljd.crm.service.CustomerService;

/**
* 客户管理的Service的实现类
* @author ljd
*/
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    //查询所有
    @Override
    public List<Customer> findAll() {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria();
        List<Customer> list = customerMapper.selectByExample(customerExample);
        
        return list;
    }
    //根据id查询
    @Override
    public Customer findById(long id) {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria();
        Customer customer = customerMapper.selectByPrimaryKey(id);
        
        return customer;
    }
    //根据name查询
    @Override
    public Map<String, Object> findByName(String custName) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        CustomerExample customerExample = new CustomerExample();
        Criteria criteria = customerExample.createCriteria();
        criteria.andCustNameLike(custName);
        List<Customer> list = customerMapper.selectByExample(customerExample);
        if(list.size() > 0) {
            response.put("msg", "查询成功");
            response.put("customer_list", list);
        }
        else {
            response.put("msg", "该客户不存在");
            response.put("customer_list", null);
        }
        return response;
    }
    //保存
    @Override
    public Map<String, Object> save(Customer customer) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria();
        try {
            customerMapper.insert(customer);
        }catch(NullPointerException e) {
            response.put("msg", "保存失败");
            return response;
        }
        response.put("msg", "保存成功");
        return response;
    }
    //删除
    @Override
    public Map<String,Object> deleteById(long id) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria();
        try {
            customerMapper.deleteByPrimaryKey(id);
        }catch(NullPointerException e) {
            response.put("msg", "删除失败");
            return response;
        }
        response.put("msg", "删除成功");
        return response;
    }
    //更新
    @Override
    public Map<String,Object> update(Customer customer) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria();
        try {
            customerMapper.updateByPrimaryKey(customer);
        }catch(NullPointerException e) {
            response.put("msg", "更新失败");
            return response;
        }
        response.put("msg", "更新成功");
        return response;
    }
    @Override
    public Map<String, Object> query(Customer customer) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        CustomerExample customerExample = new CustomerExample();
        Criteria criteria = customerExample.createCriteria();
        criteria.andCustIdEqualTo(customer.getCustId()).andCustIndustryLike(customer.getCustIndustry())
            .andCustSourceLike(customer.getCustSource()).andCustLevelLike(customer.getCustLevel())
            .andCustMobileLike(customer.getCustMobile()).andCustNameLike(customer.getCustName())
            .andCustPhoneLike(customer.getCustPhone());
        List<Customer> list = customerMapper.selectByExample(customerExample);
        if(list.size() > 0) {
            response.put("msg", "查询成功");
            response.put("customer_list", list);
        }
        else {
            response.put("msg", "客户不存在");
            response.put("customer_list", null);
        }
        return response;
    }

}
