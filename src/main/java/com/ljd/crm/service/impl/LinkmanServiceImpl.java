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
* 联系人管理的Service的实现类
* @author ljd
*/
@Service
@Transactional
public class LinkmanServiceImpl implements LinkmanService{

    @Autowired
    private LinkmanMapper linkmanMapper;
    
    //查询所有
    @Override
    public List<Linkman> findAll() {
        LinkmanExample linkmanExample = new LinkmanExample();
        linkmanExample.createCriteria();
        List<Linkman> list = linkmanMapper.selectByExample(linkmanExample);
        
        return list;
    }
    //根据id查询
    @Override
    public Linkman findById(long id) {
        LinkmanExample linkmanExample = new LinkmanExample();
        linkmanExample.createCriteria();
        Linkman linkman = linkmanMapper.selectByPrimaryKey(id);
        return linkman;
    }
    //根据name查询
    @Override
    public Map<String, Object> findByName(String lkmName) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        LinkmanExample linkmanExample = new LinkmanExample();
        Criteria criteria = linkmanExample.createCriteria();
        criteria.andLkmNameLike(lkmName);
        List<Linkman> list = linkmanMapper.selectByExample(linkmanExample);
        if(list.size() > 0) {
            response.put("msg", "查询成功");
            response.put("linkmanList", list);
        }
        else {
            response.put("msg", "该联系人不存在");
            response.put("linkmanList", null);
        }
        return response;
    }
    //保存
    @Override
    public Map<String,Object> save(Linkman linkman) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        LinkmanExample linkmanExample = new LinkmanExample();
        linkmanExample.createCriteria();
        try {
            linkmanMapper.insert(linkman);
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
        LinkmanExample linkmanExample = new LinkmanExample();
        linkmanExample.createCriteria();
        try {
            linkmanMapper.deleteByPrimaryKey(id);
        }catch(NullPointerException e) {
            response.put("msg", "删除失败");
            return response;
        }
        response.put("msg", "删除成功");
        return response;
    }
    //更新
    @Override
    public Map<String,Object> update(Linkman linkman) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        LinkmanExample linkmanExample = new LinkmanExample();
        linkmanExample.createCriteria();
        try {
            linkmanMapper.updateByPrimaryKey(linkman);
        }catch(NullPointerException e) {
            response.put("msg", "更新失败");
            return response;
        }
        response.put("msg", "更新成功");
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
            response.put("msg", "查询成功");
            response.put("linkmanList", list);
        }
        else {
            response.put("msg", "联系人不存在");
            response.put("linkmanList", null);
        }
        return response;
    }

}
