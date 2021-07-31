package main.java.com.ljd.crm.service;

import java.util.List;
import java.util.Map;

import main.java.com.ljd.crm.pojo.Linkman;

public interface LinkmanService {
    
    List<Linkman> findAll();
    
    Linkman findById(long id);
    
    Map<String,Object> findByName(String lkmName);
    
    Map<String,Object> save(Linkman linkman);
    
    Map<String,Object> deleteById(long id);
    
    Map<String,Object> update(Linkman linkman);
    
    Map<String,Object> query(Linkman linkman);

}
