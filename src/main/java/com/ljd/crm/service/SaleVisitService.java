package main.java.com.ljd.crm.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import main.java.com.ljd.crm.pojo.SaleVisit;


public interface SaleVisitService {
    
    List<SaleVisit> findAll();
    
    SaleVisit findById(Long id);
    
    Map<String,Object> save(SaleVisit saleVisit);
    
    Map<String, Object> deleteById(Long id);
    
    Map<String,Object> update(SaleVisit saleVisit);
    
    Map<String,Object> query(SaleVisit saleVisit);
    
    Map<String,Object> findByTime(String time1,String time2) throws ParseException;

}
