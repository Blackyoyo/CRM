package main.java.com.ljd.crm.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.com.ljd.crm.pojo.Customer;
import main.java.com.ljd.crm.service.CustomerService;

/**
* 客户信息请求处理的Controller
* @author ljd
*/
@Controller
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    //所有客户列表
    @SuppressWarnings("unchecked")
    @RequestMapping("customer_list")
    public String list(@RequestParam(required = false) String custName,Model model){
        List<Customer> list = customerService.findAll();
        if(custName != null) {
            Map<String, Object> response = customerService.findByName(custName);
            list = (List<Customer>)response.get("customer_list");
            model.addAttribute("msg", response.get("msg"));
        }
        model.addAttribute("customer_list", list);
        return "customer/list";
    }
    //新增客户
    @RequestMapping("customer_add")
    public String save(Customer customer,Model model) {
            Map<String, Object> response = customerService.save(customer);
            model.addAttribute("msg", response.get("msg"));
            return "customer/add";
    }
    //删除客户
    @RequestMapping("customer_delete")
    public String delete(@RequestParam long custId,Model model) {
            Map<String, Object> response = customerService.deleteById(custId);
            model.addAttribute("msg", response.get("msg"));
            return "forward:/customer_list";
    }
    //编辑页面
    @RequestMapping("customer_edit")
    public String edit(@RequestParam long custId,Model model){
            Customer customer = customerService.findById(custId);
            if(customer == null) {
                return "error";
            }
            model.addAttribute("customer", customer);
            return "customer/edit";
    }
    //更新客户
    @RequestMapping("customer_update")
    public String update(@RequestParam long custId,Customer customer,Model model) {
            customer.setCustId(custId);
            Map<String, Object> response = customerService.update(customer);
            model.addAttribute("msg", response.get("msg"));
            return "customer/edit";
    }
    //综合查询
    @RequestMapping("customer_query")
    public String query(Customer customer,Model model) {
        Map<String, Object> response = customerService.query(customer);
        model.addAttribute("msg", response.get("msg"));
        model.addAttribute("customer_list", response.get("customer_list"));
        return "customer/list";
    }
    //获取行业统计信息
    @RequestMapping("/statistics/industry")
    public String industryStatistics(Model model) throws JsonProcessingException{
        List<Customer> customerlist = customerService.findAll();
        Map<String, Integer> lmap = new LinkedHashMap<String, Integer>();
        for(Customer c : customerlist) {
            String industry = c.getCustIndustry();
            if(lmap.containsKey(industry)) {
                lmap.put(industry, lmap.get(industry)+1);
            }else {
                lmap.put(industry, 1);
            }
        }
        List<String> inustryList = new ArrayList<String>();
        List<Integer> numList = new ArrayList<Integer>();
        for(Map.Entry<String,Integer> e : lmap.entrySet()) {
            inustryList.add(e.getKey());
            numList.add(e.getValue());
        }
        ObjectMapper om = new ObjectMapper();
        model.addAttribute("industry", om.writeValueAsString(inustryList));
        model.addAttribute("num", om.writeValueAsString(numList));
        return "/statistics/industry";
    }
    //获取来源统计信息
    @RequestMapping("/statistics/sources")
    public String sourcesStatistics(Model model) throws JsonProcessingException{
        List<Customer> customerlist = customerService.findAll();
        Map<String, Integer> lmap = new LinkedHashMap<String, Integer>();
        for(Customer c : customerlist) {
            String sources = c.getCustSource();
            if(lmap.containsKey(sources)) {
                lmap.put(sources, lmap.get(sources)+1);
            }else {
                lmap.put(sources, 1);
            }
        }
        List<String> sourcesList = new ArrayList<String>();
        List<Integer> numList = new ArrayList<Integer>();
        for(Map.Entry<String,Integer> e : lmap.entrySet()) {
            sourcesList.add(e.getKey());
            numList.add(e.getValue());
        }
        ObjectMapper om = new ObjectMapper();
        model.addAttribute("sources", om.writeValueAsString(sourcesList));
        model.addAttribute("num", om.writeValueAsString(numList));
        return "/statistics/sources";
    }
}
