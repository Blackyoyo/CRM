package main.java.com.ljd.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import main.java.com.ljd.crm.pojo.Customer;
import main.java.com.ljd.crm.pojo.SysUser;
import main.java.com.ljd.crm.service.CustomerService;
import main.java.com.ljd.crm.service.SysUserService;

/**
* Ò³ÃæÌø×ª  µÄController
* @author ljd
*/
@RequestMapping("/")
@Controller
public class DispatcherController {
    
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SysUserService sysuserService;

    @RequestMapping({"/","/index"})
    public String index(HttpServletRequest request) {
        if(request.getSession().getAttribute("existUser") != null) {
            return "index";
        }
        return "user/login";
    }
    
    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
    @RequestMapping("/menu")
    public String menu() {
        return "menu";
    }
    @RequestMapping("/top")
    public String top() {
        return "top";
    }
    @RequestMapping("/registPage")
    public String regist() {
        return "user/regist";
    }
    @RequestMapping("/customer/add")
    public String customerAdd() {
        return "/customer/add";
    }
    @RequestMapping("/customer/list")
    public String customerList() {
        return "redirect:/customer_list";
    }
    @RequestMapping("/customer_queryPage")
    public String customerQuery() {
        return "/customer/query";
    }
    @RequestMapping("/linkman_queryPage")
    public String linkmanQuery(Model model) {
        List<Customer> list = customerService.findAll();
        model.addAttribute("customer_list", list);
        return "/linkman/query";
    }
    @RequestMapping("/salevisit_queryPage")
    public String salevisitQuery(Model model) {
        List<SysUser> ulist = sysuserService.findAll();
        List<Customer> clist = customerService.findAll();
        model.addAttribute("customer_list", clist);
        model.addAttribute("user_list", ulist);
        return "/salevisit/query";
    }

}
