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
* �˺���Ϣ�������Controller
* @author ljd
*/
@Controller
public class SysUserController {
    
    @Autowired
    private SysUserService sysUserService;
    
    //�����˺��б�
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
    
    //����User_code��ѯ�˺���Ϣ
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
    //ע���˺�
    @RequestMapping("regist")
    public String regist(SysUser sysUser,Model model,HttpServletRequest request) {
        Map<String,Object> response = sysUserService.regist(sysUser);
        if (response.get("user") == null) {
            model.addAttribute("msg",response.get("msg"));
            return "user/regist";
        }
        if(response.get("user") != null){
            //ע��ɹ�
            request.getSession().setAttribute("existUser", response.get("user"));
            return "redirect:/index";
        }
        if(response.get("msg") == null) {
            return "redirect:/error";
        }
        return "redirect:/error";
    }
    //�˳���¼
    @RequestMapping("quit")
    public String quit(HttpServletRequest request) {
        if(request.getSession().getAttribute("existUser") == null) {
            return "redirect:/error";
        }else {
            request.getSession().removeAttribute("existUser");
            return "user/login";
        }
    }
    //ͣ���˺�
    @RequestMapping("user_Deactivate")
    public String deactivate(@RequestParam long userId,Model model) {
        SysUser user = sysUserService.findById(userId);
        if(user == null) {
            return "error";
        }
        if(user.getUserState() == '0') {
            model.addAttribute("msg", "�˺���ͣ��");
            return "forward:/user_list";
        }
        user.setUserState('0');
        Map<String, Object> response = sysUserService.update(user);
        model.addAttribute("msg", response.get("msg"));
        return "forward:/user_list";
    }
    //�༭ҳ��
    @RequestMapping("user_edit")
    public String edit(@RequestParam long userId,Model model){
        SysUser user = sysUserService.findById(userId);
            if(user == null) {
                return "error";
            }
            model.addAttribute("user", user);
            return "user/edit";
    }
    //�����˺�
    @RequestMapping("user_update")
    public String update(@RequestParam long userId,SysUser user,Model model) {
            user.setUserId(userId);
            user.setUserState('1');
            Map<String, Object> response = sysUserService.update(user);
            model.addAttribute("msg", response.get("msg"));
            return "user/edit";
    }

}
