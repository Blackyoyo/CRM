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
* �ͻ������Service��ʵ����
* @author ljd
*/
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    //��ѯ����
    @Override
    public List<Customer> findAll() {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria();
        List<Customer> list = customerMapper.selectByExample(customerExample);
        
        return list;
    }
    //����id��ѯ
    @Override
    public Customer findById(long id) {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria();
        Customer customer = customerMapper.selectByPrimaryKey(id);
        
        return customer;
    }
    //����name��ѯ
    @Override
    public Map<String, Object> findByName(String custName) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        CustomerExample customerExample = new CustomerExample();
        Criteria criteria = customerExample.createCriteria();
        criteria.andCustNameLike(custName);
        List<Customer> list = customerMapper.selectByExample(customerExample);
        if(list.size() > 0) {
            response.put("msg", "��ѯ�ɹ�");
            response.put("customer_list", list);
        }
        else {
            response.put("msg", "�ÿͻ�������");
            response.put("customer_list", null);
        }
        return response;
    }
    //����
    @Override
    public Map<String, Object> save(Customer customer) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria();
        try {
            customerMapper.insert(customer);
        }catch(NullPointerException e) {
            response.put("msg", "����ʧ��");
            return response;
        }
        response.put("msg", "����ɹ�");
        return response;
    }
    //ɾ��
    @Override
    public Map<String,Object> deleteById(long id) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria();
        try {
            customerMapper.deleteByPrimaryKey(id);
        }catch(NullPointerException e) {
            response.put("msg", "ɾ��ʧ��");
            return response;
        }
        response.put("msg", "ɾ���ɹ�");
        return response;
    }
    //����
    @Override
    public Map<String,Object> update(Customer customer) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria();
        try {
            customerMapper.updateByPrimaryKey(customer);
        }catch(NullPointerException e) {
            response.put("msg", "����ʧ��");
            return response;
        }
        response.put("msg", "���³ɹ�");
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
            response.put("msg", "��ѯ�ɹ�");
            response.put("customer_list", list);
        }
        else {
            response.put("msg", "�ͻ�������");
            response.put("customer_list", null);
        }
        return response;
    }

}
