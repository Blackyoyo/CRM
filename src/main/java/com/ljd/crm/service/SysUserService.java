package main.java.com.ljd.crm.service;

import java.util.List;
import java.util.Map;

import main.java.com.ljd.crm.pojo.SysUser;

public interface SysUserService {
    
    List<SysUser> findAll();
    
    SysUser findById(long id);
    
    Map<String,Object> save(SysUser sysUser);
    
    Map<String,Object> deleteById(long id);
    
    Map<String,Object> update(SysUser sysUser);
    
    Map<String,Object> login(SysUser sysUser);
    
    Map<String,Object> regist(SysUser sysUser);

    Map<String,Object> findByName(String userName);
}
