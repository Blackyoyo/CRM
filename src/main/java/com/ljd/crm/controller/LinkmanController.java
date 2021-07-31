package main.java.com.ljd.crm.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import main.java.com.ljd.crm.pojo.Customer;
import main.java.com.ljd.crm.pojo.Linkman;
import main.java.com.ljd.crm.service.CustomerService;
import main.java.com.ljd.crm.service.LinkmanService;

/**
* ��ϵ����Ϣ�������Controller
* @author ljd
*/
@Controller
public class LinkmanController {
    
    @Autowired
    private LinkmanService linkmanService;
    @Autowired
    private CustomerService customerService;
    
    //������ϵ���б�
    
    @SuppressWarnings("unchecked")
    @RequestMapping("linkman_list")
    public String list(@RequestParam(required = false) String lkmName,Model model){
        List<Linkman> list = linkmanService.findAll();
        List<Customer> clist = customerService.findAll();
        Map<Long, String> cmap = new LinkedHashMap<Long, String>();
        for(Customer c : clist) {
            cmap.put(c.getCustId(), c.getCustName());
        }
        if(lkmName != null) {
            Map<String, Object> response = linkmanService.findByName(lkmName);
            list = (List<Linkman>)response.get("linkmanList");
            model.addAttribute("cmap", cmap);
            model.addAttribute("msg", response.get("msg"));
        }
        model.addAttribute("cmap", cmap);
        model.addAttribute("linkman_list", list);
        return "linkman/list";
    }
    //����ҳ��
    @RequestMapping("linkman_add")
    public String add(Model model) {
            List<Customer> list = customerService.findAll();
            model.addAttribute("customer_list", list);
            return "linkman/add";
    }
    //������ϵ��
    @RequestMapping("linkman_save")
    public String save(Linkman linkman,Model model) {
            Map<String, Object> response = linkmanService.save(linkman);
            model.addAttribute("msg", response.get("msg"));
            return "forward:/linkman_add";
    }
    //ɾ����ϵ��
    @RequestMapping("linkman_delete")
    public String delete(@RequestParam long lkmId,Model model) {
            Map<String, Object> response = linkmanService.deleteById(lkmId);
            model.addAttribute("msg", response.get("msg"));
            return "forward:/linkman_list";
    }
    //�༭ҳ��
    @RequestMapping("linkman_edit")
    public String edit(@RequestParam long lkmId,Model model){
            List<Customer> list = customerService.findAll();
            model.addAttribute("customer_list", list);
            Linkman linkman = linkmanService.findById(lkmId);
            if(linkman == null) {
                return "error";
            }
            model.addAttribute("linkman", linkman);
            return "linkman/edit";
    }
    //������ϵ��
    @RequestMapping("linkman_update")
    public String update(@RequestParam long lkmId,Linkman linkman,Model model) {
            linkman.setLkmId(lkmId);
            Map<String, Object> response = linkmanService.update(linkman);
            model.addAttribute("msg", response.get("msg"));
            return "linkman/edit";
    }
    //�ۺϲ�ѯ
    @SuppressWarnings("unchecked")
    @RequestMapping("linkman_query")
    public String query(Linkman linkman,Model model) {
        Map<String, Object> response = linkmanService.query(linkman);
        List<Customer> clist = customerService.findAll();
        Map<Long, String> cmap = new LinkedHashMap<Long, String>();
        for(Customer c : clist) {
            cmap.put(c.getCustId(), c.getCustName());
        }
        List<Linkman> list = (List<Linkman>) response.get("linkmanList");
        model.addAttribute("cmap", cmap);
        model.addAttribute("msg", response.get("msg"));
        model.addAttribute("linkman_list", list);
        return "linkman/list";
    }
}
