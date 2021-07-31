package main.java.com.ljd.crm.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.ljd.crm.mapper.LinkmanMapper;

import main.java.com.ljd.crm.pojo.Linkman;
import main.java.com.ljd.crm.pojo.LinkmanExample;
import main.java.com.ljd.crm.pojo.LinkmanExample.Criteria;
import main.java.com.ljd.crm.service.LinkmanService;

/**
* ��ϵ�˹����Service��ʵ����
* @author ljd
*/
@Service
@Transactional
public class LinkmanServiceImpl implements LinkmanService{

    @Autowired
    private LinkmanMapper linkmanMapper;
    
    //��ѯ����
    @Override
    public List<Linkman> findAll() {
        LinkmanExample linkmanExample = new LinkmanExample();
        linkmanExample.createCriteria();
        List<Linkman> list = linkmanMapper.selectByExample(linkmanExample);
        
        return list;
    }
    //����id��ѯ
    @Override
    public Linkman findById(long id) {
        LinkmanExample linkmanExample = new LinkmanExample();
        linkmanExample.createCriteria();
        Linkman linkman = linkmanMapper.selectByPrimaryKey(id);
        return linkman;
    }
    //����name��ѯ
    @Override
    public Map<String, Object> findByName(String lkmName) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        LinkmanExample linkmanExample = new LinkmanExample();
        Criteria criteria = linkmanExample.createCriteria();
        criteria.andLkmNameLike(lkmName);
        List<Linkman> list = linkmanMapper.selectByExample(linkmanExample);
        if(list.size() > 0) {
            response.put("msg", "��ѯ�ɹ�");
            response.put("linkmanList", list);
        }
        else {
            response.put("msg", "����ϵ�˲�����");
            response.put("linkmanList", null);
        }
        return response;
    }
    //����
    @Override
    public Map<String,Object> save(Linkman linkman) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        LinkmanExample linkmanExample = new LinkmanExample();
        linkmanExample.createCriteria();
        try {
            linkmanMapper.insert(linkman);
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
        LinkmanExample linkmanExample = new LinkmanExample();
        linkmanExample.createCriteria();
        try {
            linkmanMapper.deleteByPrimaryKey(id);
        }catch(NullPointerException e) {
            response.put("msg", "ɾ��ʧ��");
            return response;
        }
        response.put("msg", "ɾ���ɹ�");
        return response;
    }
    //����
    @Override
    public Map<String,Object> update(Linkman linkman) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        LinkmanExample linkmanExample = new LinkmanExample();
        linkmanExample.createCriteria();
        try {
            linkmanMapper.updateByPrimaryKey(linkman);
        }catch(NullPointerException e) {
            response.put("msg", "����ʧ��");
            return response;
        }
        response.put("msg", "���³ɹ�");
        return response;
    }
    @Override
    public Map<String, Object> query(Linkman linkman) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        LinkmanExample linkmanExample = new LinkmanExample();
        Criteria criteria = linkmanExample.createCriteria();
        criteria.andLkmIdEqualTo(linkman.getLkmId()).andLkmCustIdEqualTo(linkman.getLkmCustId())
            .andLkmNameLike(linkman.getLkmName()).andLkmGenderEqualTo(""+linkman.getLkmGender())
            .andLkmPhoneLike(linkman.getLkmPhone()).andLkmMobileLike(linkman.getLkmMobile())
            .andLkmEmailLike(linkman.getLkmEmail()).andLkmWechatLike(linkman.getLkmWechat())
            .andLkmPositionLike(linkman.getLkmPosition()).andLkmMemoLike(linkman.getLkmMemo());
        List<Linkman> list = linkmanMapper.selectByExample(linkmanExample);
        if(list.size() > 0) {
            response.put("msg", "��ѯ�ɹ�");
            response.put("linkmanList", list);
        }
        else {
            response.put("msg", "��ϵ�˲�����");
            response.put("linkmanList", null);
        }
        return response;
    }

}
