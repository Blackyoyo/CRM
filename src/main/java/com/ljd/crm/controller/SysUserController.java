package main.java.com.ljd.crm.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import main.java.com.ljd.crm.pojo.SysUser;
import main.java.com.ljd.crm.service.SysUserService;

/**
* 账号信息请求处理的Controller
* @author ljd
*/
@Controller
public class SysUserController {
    
    @Autowired
    private SysUserService sysUserService;
    
    //所有账号列表
    @SuppressWarnings("unchecked")
    @RequestMapping("user_list")
    public String list(@RequestParam(required = false) String userName,Model model){
        List<SysUser> list = sysUserService.findAll();
        if(userName != null) {
            Map<String, Object> response = sysUserService.findByName(userName);
            list = (List<SysUser>)response.get("user_list");
            model.addAttribute("msg", response.get("msg"));
        }
        model.addAttribute("user_list", list);
        return "user/list";
    }
    
    //根据User_code查询账号信息
    @RequestMapping("login")
    public String login(SysUser sysUser,Model model,HttpServletRequest request) {
        Map<String,Object> response = sysUserService.login(sysUser);
        if (response.get("user") == null) {
            model.addAttribute("msg",response.get("msg"));
            return "user/login";
        } else {
            request.getSession().setAttribute("existUser", response.get("user"));
            return "redirect:/index";
        }
        
    }
    //注册账号
    @RequestMapping("regist")
    public String regist(SysUser sysUser,Model model,HttpServletRequest request) {
        Map<String,Object> response = sysUserService.regist(sysUser);
        if (response.get("user") == null) {
            model.addAttribute("msg",response.get("msg"));
            return "user/regist";
        }
        if(response.get("user") != null){
            //注册成功
            request.getSession().setAttribute("existUser", response.get("user"));
            return "redirect:/index";
        }
        if(response.get("msg") == null) {
            return "redirect:/error";
        }
        return "redirect:/error";
    }
    //退出登录
    @RequestMapping("quit")
    public String quit(HttpServletRequest request) {
        if(request.getSession().getAttribute("existUser") == null) {
            return "redirect:/error";
        }else {
            request.getSession().removeAttribute("existUser");
            return "user/login";
        }
    }
    //停用账号
    @RequestMapping("user_Deactivate")
    public String deactivate(@RequestParam long userId,Model model) {
        SysUser user = sysUserService.findById(userId);
        if(user == null) {
            return "error";
        }
        if(user.getUserState() == '0') {
            model.addAttribute("msg", "账号已停用");
            return "forward:/user_list";
        }
        user.setUserState('0');
        Map<String, Object> response = sysUserService.update(user);
        model.addAttribute("msg", response.get("msg"));
        return "forward:/user_list";
    }
    //编辑页面
    @RequestMapping("user_edit")
    public String edit(@RequestParam long userId,Model model){
        SysUser user = sysUserService.findById(userId);
            if(user == null) {
                return "error";
            }
            model.addAttribute("user", user);
            return "user/edit";
    }
    //更新账号
    @RequestMapping("user_update")
    public String update(@RequestParam long userId,SysUser user,Model model) {
            user.setUserId(userId);
            user.setUserState('1');
            Map<String, Object> response = sysUserService.update(user);
            model.addAttribute("msg", response.get("msg"));
            return "user/edit";
    }

}
