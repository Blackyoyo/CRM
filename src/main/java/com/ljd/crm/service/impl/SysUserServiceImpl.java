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
* �˺Ź����Service��ʵ����
* @author ljd
*/
@Service
@Transactional
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private SysUserMapper sysUserMapper;
    
    //��ѯ����
    @Override
    public List<SysUser> findAll() {
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria();
        List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);
        
        return list;
    }
    //����id��ѯ
    @Override
    public SysUser findById(long id) {
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria();
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
        return sysUser;
    }
    //����
    @Override
    public Map<String,Object> save(SysUser sysUser) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria();
        try {
            sysUserMapper.insert(sysUser);
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
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria();
        try {
            sysUserMapper.deleteByPrimaryKey(id);
        }catch(NullPointerException e) {
            response.put("msg", "ɾ��ʧ��");
            return response;
        }
        response.put("msg", "ɾ���ɹ�");
        return response;
    }
    //����
    @Override
    public Map<String,Object> update(SysUser sysUser) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        sysUser.setUserPassword(MD5Utils.md5(sysUser.getUserPassword()));
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria();
        try {
            sysUserMapper.updateByPrimaryKey(sysUser);
        }catch(NullPointerException e) {
            response.put("msg", "����ʧ��");
            return response;
        }
        response.put("msg", "���³ɹ�");
        return response;
    }
    
    //��¼У��
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
                    response.put("msg", "��¼�ɹ�");
                    response.put("user", sysUser);
                }
                else {
                    response.put("msg", "��¼ʧ�ܣ��˺���ͣ�ã�");
                    response.put("user", null);
                }
            }
            else {
                response.put("msg", "��¼ʧ�ܣ��������");
                response.put("user", null);
            }
        }
        else {
            response.put("msg", "��¼ʧ�ܣ��˺Ų����ڣ�");
            response.put("user", null);
        }
        return response;
    }
    //ע��У��
    @Override
    public Map<String,Object> regist(SysUser user) {
        Map<String,Object> response = new LinkedHashMap<String,Object>();
        SysUserExample sysUserExample = new SysUserExample();
        Criteria criteria = sysUserExample.createCriteria();
        criteria.andUserCodeEqualTo(user.getUserCode());
        List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);

        if(list.size()>0) {
                    response.put("msg", "�˺��Ѵ���");
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
                    response.put("msg", "ע��ɹ���");
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
            response.put("msg", "��ѯ�ɹ�");
            response.put("user_List", list);
        }
        else {
            response.put("msg", "���˺Ų�����");
            response.put("user_List", null);
        }
        return response;
    }

}
