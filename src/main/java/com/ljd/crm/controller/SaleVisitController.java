package main.java.com.ljd.crm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import main.java.com.ljd.crm.pojo.Customer;
import main.java.com.ljd.crm.pojo.Linkman;
import main.java.com.ljd.crm.pojo.SaleVisit;
import main.java.com.ljd.crm.pojo.SysUser;
import main.java.com.ljd.crm.service.CustomerService;
import main.java.com.ljd.crm.service.SaleVisitService;
import main.java.com.ljd.crm.service.SysUserService;

/**
* 拜访记录请求处理的Controller
* @author ljd
*/
@Controller
public class SaleVisitController {

    @Autowired
    private SaleVisitService salevisitService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SysUserService sysuserService;
    
    //所有记录列表
    @SuppressWarnings("unchecked")
    @RequestMapping("salevisit_list")
    public String list(@RequestParam(required = false) String time1,@RequestParam(required = false) String time2,Model model){
        List<SysUser> ulist = sysuserService.findAll();
        List<Customer> clist = customerService.findAll();
        Map<Long, String> cmap = new LinkedHashMap<Long, String>();
        Map<Long, String> umap = new LinkedHashMap<Long, String>();
        for(Customer c : clist) {
            cmap.put(c.getCustId(), c.getCustName());
        }
        for(SysUser u : ulist) {
            umap.put(u.getUserId(), u.getUserName());
        }
        if(time1 != null || time2 != null) {
            Map<String, Object> response;
            try {
                response = salevisitService.findByTime(time1,time2);
            } catch (ParseException e) {
                return "error";
            }
            if(response == null) {
                return "error";
            }
            
            List<SaleVisit> list = (List<SaleVisit>)response.get("salevisit_list");
            model.addAttribute("msg", response.get("msg"));
            model.addAttribute("salevisit_list", list);
            model.addAttribute("cmap", cmap);
            model.addAttribute("umap", umap);
            return "salevisit/list";
        }
        List<SaleVisit> list = salevisitService.findAll();
        model.addAttribute("cmap", cmap);
        model.addAttribute("umap", umap);
        model.addAttribute("salevisit_list", list);
        return "salevisit/list";
    }
    //新增页面
    @RequestMapping("salevisit_add")
    public String add(Model model,HttpServletRequest request) {
            SysUser user = (SysUser)request.getSession().getAttribute("existUser");
            List<Customer> list = customerService.findAll();
            model.addAttribute("customer_list", list);
            model.addAttribute("user", user);
            return "salevisit/add";
    }
    //保存记录
    @RequestMapping("salevisit_save")
    public String save(@RequestParam(required = false) String time1,@RequestParam(required = false) String time2,SaleVisit salevisit,Model model) throws ParseException {
            if(time1 == null || time2 == null) {
                return "error";
            }
            if(time1.length() == 0 || time2.length() == 0) {
                return "error";
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdf.parse(time1);
            Date date2 = sdf.parse(time2);
            salevisit.setVisitTime(date1);
            salevisit.setVisitNexttime(date2);
            Map<String, Object> response = salevisitService.save(salevisit);
            model.addAttribute("msg", response.get("msg"));
            return "forward:/salevisit_add";
    }
    //删除记录
    @RequestMapping("salevisit_delete")
    public String delete(@RequestParam Long visitId,Model model) {
            Map<String, Object> response = salevisitService.deleteById(visitId);
            model.addAttribute("msg", response.get("msg"));
            return "forward:/salevisit_list";
    }
    //编辑页面
    @RequestMapping("salevisit_edit")
    public String edit(@RequestParam long visitId,Model model){
            List<Customer> clist = customerService.findAll();
            List<SysUser> ulist = sysuserService.findAll();
            model.addAttribute("customer_list", clist);
            model.addAttribute("sysuser_list", ulist);
            SaleVisit salevisit = salevisitService.findById(visitId);
            if(salevisit == null) {
                return "error";
            }
            model.addAttribute("salevisit", salevisit);
            return "salevisit/edit";
    }
    //更新记录
    @RequestMapping("salevisit_update")
    public String update(@RequestParam String time1,@RequestParam String time2,@RequestParam long visitId,SaleVisit salevisit,Model model) throws ParseException {
            salevisit.setVisitId(visitId);
            if(time1 == null || time2 == null) {
                return "error";
            }
            if(time1.length() == 0 || time2.length() == 0) {
                return "error";
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdf.parse(time1);
            Date date2 = sdf.parse(time2);
            salevisit.setVisitTime(date1);
            salevisit.setVisitNexttime(date2);
            Map<String, Object> response = salevisitService.update(salevisit);
            model.addAttribute("msg", response.get("msg"));
            return "salevisit/edit";
    }
    //综合查询
    @SuppressWarnings("unchecked")
    @RequestMapping("salevisit_query")
    public String query(SaleVisit salevisit,Model model) {
        Map<String, Object> response = salevisitService.query(salevisit);
        List<Customer> clist = customerService.findAll();
        List<SysUser> ulist = sysuserService.findAll();
        Map<Long, String> umap = new LinkedHashMap<Long, String>();
        Map<Long, String> cmap = new LinkedHashMap<Long, String>();
        for(Customer c : clist) {
            cmap.put(c.getCustId(), c.getCustName());
        }
        for(SysUser u : ulist) {
            umap.put(u.getUserId(), u.getUserName());
        }
        List<Linkman> list = (List<Linkman>) response.get("salevisit_list");
        model.addAttribute("cmap", cmap);
        model.addAttribute("umap", umap);
        model.addAttribute("msg", response.get("msg"));
        model.addAttribute("salevisit_list", list);
        return "salevisit/list";
    }
}
