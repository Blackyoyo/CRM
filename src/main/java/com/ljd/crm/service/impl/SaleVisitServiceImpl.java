package main.java.com.ljd.crm.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.ljd.crm.mapper.SaleVisitMapper;
import main.java.com.ljd.crm.pojo.SaleVisit;
import main.java.com.ljd.crm.pojo.SaleVisitExample;
import main.java.com.ljd.crm.pojo.SaleVisitExample.Criteria;
import main.java.com.ljd.crm.service.SaleVisitService;

/**
* 客户拜访记录的Service的实现类
* @author ljd
*/
@Service
@Transactional
public class SaleVisitServiceImpl implements SaleVisitService{

    @Autowired
    private SaleVisitMapper saleVisitMapper;
    
    //查询所有
    @Override
    public List<SaleVisit> findAll() {
        SaleVisitExample saleVisitExample = new SaleVisitExample();
        saleVisitExample.createCriteria();
        List<SaleVisit> list = saleVisitMapper.selectByExample(saleVisitExample);
        
        return list;
    }
    //根据id查询
    @Override
    public SaleVisit findById(Long id) {
        SaleVisitExample saleVisitExample = new SaleVisitExample();
        saleVisitExample.createCriteria();
        SaleVisit saleVisit = saleVisitMapper.selectByPrimaryKey(id);
        return saleVisit;
    }
    //保存
    @Override
    public Map<String,Object> save(SaleVisit saleVisit) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        SaleVisitExample saleVisitExample = new SaleVisitExample();
        saleVisitExample.createCriteria();
        try {
            saleVisitMapper.insert(saleVisit);
        }catch(NullPointerException e) {
            response.put("msg", "保存失败");
            return response;
        }
        response.put("msg", "保存成功");
        return response;
    }
    //删除
    @Override
    public Map<String,Object> deleteById(Long id) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        SaleVisitExample saleVisitExample = new SaleVisitExample();
        saleVisitExample.createCriteria();
        try {
            saleVisitMapper.deleteByPrimaryKey(id);
        }catch(NullPointerException e) {
            response.put("msg", "删除失败");
            return response;
        }
        response.put("msg", "删除成功");
        return response;
    }
    //更新
    @Override
    public Map<String,Object> update(SaleVisit saleVisit) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        SaleVisitExample saleVisitExample = new SaleVisitExample();
        saleVisitExample.createCriteria();
        try {
            saleVisitMapper.updateByPrimaryKey(saleVisit);
        }catch(NullPointerException e) {
            response.put("msg", "更新失败");
            return response;
        }
        response.put("msg", "更新成功");
        return response;
    }
    @Override
    public Map<String,Object> findByTime(String time1,String time2) throws ParseException {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        SaleVisitExample saleVisitExample = new SaleVisitExample();
        Criteria criteria = saleVisitExample.createCriteria();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        if(time1.length() != 0 && time2.length() != 0) {
            Date date1 = sdf.parse(time1);
            Date date2 = sdf.parse(time2);
            criteria.andVisitTimeBetween(date1, date2);
            List<SaleVisit> list = saleVisitMapper.selectByExample(saleVisitExample);
            if(list.size() > 0) {
                response.put("msg", "查询成功");
                response.put("salevisit_list", list);
                return response;
            }else {
                response.put("msg", "记录不存在");
                response.put("salevisit_list", null);
                return response;
            }
        }
        if(time1.length() != 0 && time2.length() == 0) {
            Date date1 = sdf.parse(time1);
            criteria.andVisitTimeGreaterThanOrEqualTo(date1);
            List<SaleVisit> list = saleVisitMapper.selectByExample(saleVisitExample);
            if(list.size() > 0) {
                response.put("msg", "查询成功");
                response.put("salevisit_list", list);
                return response;
            }else {
                response.put("msg", "记录不存在");
                response.put("salevisit_list", null);
                return response;
            }
        }
        if(time1.length() == 0 && time2.length() != 0) {
            Date date2 = sdf.parse(time2);
            criteria.andVisitTimeLessThanOrEqualTo(date2);
            List<SaleVisit> list = saleVisitMapper.selectByExample(saleVisitExample);
            if(list.size() > 0) {
                response.put("msg", "查询成功");
                response.put("salevisit_list", list);
                return response;
            }else {
                response.put("msg", "记录不存在");
                response.put("salevisit_list", null);
                return response;
            }
        }
        return null;
    }
    @Override
    public Map<String, Object> query(SaleVisit saleVisit) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        SaleVisitExample saleVisitExample = new SaleVisitExample();
        Criteria criteria = saleVisitExample.createCriteria();
        criteria.andVisitIdEqualTo(saleVisit.getVisitId()).andVisitCustIdEqualTo(saleVisit.getVisitCustId())
            .andVisitUserIdEqualTo(saleVisit.getVisitUserId()).andVisitAddrLike(saleVisit.getVisitAddr())
            .andVisitDetailLike(saleVisit.getVisitDetail());
        List<SaleVisit> list = saleVisitMapper.selectByExample(saleVisitExample);
        if(list.size() > 0) {
            response.put("msg", "查询成功");
            response.put("salevisit_list", list);
            return response;
        }else {
            response.put("msg", "记录不存在");
            response.put("salevisit_list", null);
            return response;
        }
    }

}
