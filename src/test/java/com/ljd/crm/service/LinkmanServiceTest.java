package test.java.com.ljd.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.com.ljd.crm.pojo.Linkman;
import main.java.com.ljd.crm.service.LinkmanService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring//applicationContext-dao.xml","classpath:spring//applicationContext-service.xml" })
public class LinkmanServiceTest {

    @Autowired
    private LinkmanService service;

    @Test
    public void testFindAll() throws JsonProcessingException {
        List<Linkman> list = service.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        String a[] = json.split("},");
        System.out.println("testFindAll----------------------------------------------------------------------------------");
        for(String x : a) {
            System.out.println(x);
        }
        System.out.println("---------------------------------------------------------------------------------------------");
    }
    
    @Test
    public void testFindById() throws JsonProcessingException {
        List<Linkman> list = new ArrayList<Linkman>();
        for(int i=0 ;i<10 ;i++) {
            list.add(service.findById((long)i));
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        System.out.println("testFindById---------------------------------------------------------------------------------");
        System.out.println(json);
        System.out.println("---------------------------------------------------------------------------------------------");
    }
    
    @Test
    public void testSave() throws JsonProcessingException {
        Linkman linkman = new Linkman();
        linkman.setLkmId((long)999);
        linkman.setLkmCustId((long)4);
        linkman.setLkmName("testsave");
        linkman.setLkmGender('m');
        linkman.setLkmPhone("testsave");
        linkman.setLkmMobile("testsave");
        linkman.setLkmEmail("testsave");
        linkman.setLkmWechat("testsave");
        linkman.setLkmPosition("testsave");
        linkman.setLkmMemo("testsave");
        
        service.save(linkman);
        Linkman linkman1 = service.findById((long)999);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(linkman1);
        System.out.println("testSave-------------------------------------------------------------------------------------");
        System.out.println(json);
        System.out.println("---------------------------------------------------------------------------------------------");
        service.deleteById((long)999);
    }
    
    @Test
    public void testDelete() throws JsonProcessingException {
        Linkman linkman = new Linkman();
        linkman.setLkmId((long)888);
        linkman.setLkmCustId((long)4);
        linkman.setLkmName("testDelete");
        linkman.setLkmGender('m');
        linkman.setLkmPhone("testDelete");
        linkman.setLkmMobile("testDelete");
        linkman.setLkmEmail("testDelete");
        linkman.setLkmWechat("testDelete");
        linkman.setLkmPosition("testDelete");
        linkman.setLkmMemo("testDelete");
        
        service.save(linkman);
        Linkman linkman1 = service.findById((long)888);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(linkman1);
        System.out.println("testDelete------------------------------------------------------------------------------------");
        System.out.println("Before: "+json);
        service.deleteById((long)888);
        Linkman linkman2 = service.findById((long)888);
        String json1 = mapper.writeValueAsString(linkman2);
        System.out.println("After: "+json1);
        System.out.println("---------------------------------------------------------------------------------------------");
    }
    
    @Test
    public void testUpdate() throws JsonProcessingException {
        Linkman linkman = new Linkman();
        linkman.setLkmId((long)777);
        linkman.setLkmCustId((long)4);
        linkman.setLkmName("testupdate");
        linkman.setLkmGender('m');
        linkman.setLkmPhone("testupdate");
        linkman.setLkmMobile("testupdate");
        linkman.setLkmEmail("testupdate");
        linkman.setLkmWechat("testupdate");
        linkman.setLkmPosition("testupdate");
        linkman.setLkmMemo("testupdate");
        service.save(linkman);
        
        Linkman linkman1 = new Linkman();
        linkman1.setLkmId((long)777);
        linkman1.setLkmCustId((long)4);
        linkman1.setLkmName("Update");
        linkman1.setLkmGender('f');
        linkman1.setLkmPhone("Update");
        linkman1.setLkmMobile("Update");
        linkman1.setLkmEmail("Update");
        linkman1.setLkmWechat("Update");
        linkman1.setLkmPosition("Update");
        linkman1.setLkmMemo("Update");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(linkman);
        System.out.println("testUpdate------------------------------------------------------------------------------------");
        System.out.println("Before: "+json);
        service.update(linkman1);
        Linkman linkman2 = service.findById((long)777);
        String json1 = mapper.writeValueAsString(linkman2);
        System.out.println("After: "+json1);
        System.out.println("---------------------------------------------------------------------------------------------");
        service.deleteById((long)777);
    }
}
