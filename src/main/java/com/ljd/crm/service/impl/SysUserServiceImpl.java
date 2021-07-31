package main.java.com.ljd.crm.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.ljd.crm.mapper.SysUserMapper;
import main.java.com.ljd.crm.pojo.SysUser;
import main.java.com.ljd.crm.pojo.SysUserExample;
import main.java.com.ljd.crm.pojo.SysUserExample.Criteria;
import main.java.com.ljd.crm.service.SysUserService;
import main.java.com.ljd.crm.untils.MD5Utils;

/**
* 账号管理的Service的实现类
* @author ljd
*/
@Service
@Transactional
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private SysUserMapper sysUserMapper;
    
    //查询所有
    @Override
    public List<SysUser> findAll() {
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria();
        List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);
        
        return list;
    }
    //根据id查询
    @Override
    public SysUser findById(long id) {
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria();
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
        return sysUser;
    }
    //保存
    @Override
    public Map<String,Object> save(SysUser sysUser) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria();
        try {
            sysUserMapper.insert(sysUser);
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
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria();
        try {
            sysUserMapper.deleteByPrimaryKey(id);
        }catch(NullPointerException e) {
            response.put("msg", "删除失败");
            return response;
        }
        response.put("msg", "删除成功");
        return response;
    }
    //更新
    @Override
    public Map<String,Object> update(SysUser sysUser) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        sysUser.setUserPassword(MD5Utils.md5(sysUser.getUserPassword()));
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria();
        try {
            sysUserMapper.updateByPrimaryKey(sysUser);
        }catch(NullPointerException e) {
            response.put("msg", "更新失败");
            return response;
        }
        response.put("msg", "更新成功");
        return response;
    }
    
    //登录校验
    @Override
    public Map<String,Object> login(SysUser user) {
        Map<String,Object> response = new LinkedHashMap<String,Object>();
        user.setUserPassword(MD5Utils.md5(user.getUserPassword()));
        SysUserExample sysUserExample = new SysUserExample();
        Criteria criteria = sysUserExample.createCriteria();
        criteria.andUserCodeEqualTo(user.getUserCode());
        List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);
        if(list.size()>0) {
            SysUser sysUser = list.get(0);
            if(sysUser.getUserPassword().equals(user.getUserPassword())) {
                if(sysUser.getUserState() == '1') {
                    response.put("msg", "登录成功");
                    response.put("user", sysUser);
                }
                else {
                    response.put("msg", "登录失败！账号已停用！");
                    response.put("user", null);
                }
            }
            else {
                response.put("msg", "登录失败！密码错误！");
                response.put("user", null);
            }
        }
        else {
            response.put("msg", "登录失败！账号不存在！");
            response.put("user", null);
        }
        return response;
    }
    //注册校验
    @Override
    public Map<String,Object> regist(SysUser user) {
        Map<String,Object> response = new LinkedHashMap<String,Object>();
        SysUserExample sysUserExample = new SysUserExample();
        Criteria criteria = sysUserExample.createCriteria();
        criteria.andUserCodeEqualTo(user.getUserCode());
        List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);

        if(list.size()>0) {
                    response.put("msg", "账号已存在");
                    response.put("user", null);
                }
                else {
                    try {
                        user.setUserPassword(MD5Utils.md5(user.getUserPassword()));
                        user.setUserState('1');
                        sysUserMapper.insert(user);
                    }catch(NullPointerException e) {
                        response.put("msg", null);
                        return response;
                    }
                    response.put("msg", "注册成功！");
                    response.put("user", user);
                }

        return response;
    }
    @Override
    public Map<String, Object> findByName(String userName) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        SysUserExample sysUserExample = new SysUserExample();
        Criteria criteria = sysUserExample.createCriteria();
        criteria.andUserNameLike(userName);
        List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);
        if(list.size() > 0) {
            response.put("msg", "查询成功");
            response.put("user_List", list);
        }
        else {
            response.put("msg", "该账号不存在");
            response.put("user_List", null);
        }
        return response;
    }

}
