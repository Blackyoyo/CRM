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

import main.java.com.ljd.crm.pojo.SysUser;
import main.java.com.ljd.crm.service.SysUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring//applicationContext-dao.xml","classpath:spring//applicationContext-service.xml" })
public class SysUserServiceTest {

    @Autowired
    private SysUserService service;

    @Test
    public void testFindAll() throws JsonProcessingException {
        List<SysUser> list = service.findAll();
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
        List<SysUser> list = new ArrayList<SysUser>();
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
        SysUser sysUser = new SysUser();
        sysUser.setUserId((long)999);
        sysUser.setUserCode("testsave");
        sysUser.setUserName("testsave");
        sysUser.setUserPassword("testsave");
        sysUser.setUserState('1');

        service.save(sysUser);
        SysUser sysUser1 = service.findById((long)999);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(sysUser1);
        System.out.println("testSave-------------------------------------------------------------------------------------");
        System.out.println(json);
        System.out.println("---------------------------------------------------------------------------------------------");
        service.deleteById((long)999);
    }
    
    @Test
    public void testDelete() throws JsonProcessingException {
        SysUser sysUser = new SysUser();
        sysUser.setUserId((long)888);
        sysUser.setUserCode("testdelete");
        sysUser.setUserName("testdelete");
        sysUser.setUserPassword("testdelete");
        sysUser.setUserState('1');

        service.save(sysUser);
        SysUser sysUser1 = service.findById((long)888);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(sysUser1);
        System.out.println("testDelete------------------------------------------------------------------------------------");
        System.out.println("Before: "+json);
        service.deleteById((long)888);
        SysUser sysUser2 = service.findById((long)888);
        String json1 = mapper.writeValueAsString(sysUser2);
        System.out.println("After: "+json1);
        System.out.println("---------------------------------------------------------------------------------------------");
    }
    
    @Test
    public void testUpdate() throws JsonProcessingException {
        SysUser sysUser = new SysUser();
        sysUser.setUserId((long)777);
        sysUser.setUserCode("testUpdate");
        sysUser.setUserName("testUpdate");
        sysUser.setUserPassword("testUpdate");
        sysUser.setUserState('1');

        service.save(sysUser);
        
        SysUser sysUser1 = new SysUser();
        sysUser1.setUserId((long)777);
        sysUser1.setUserCode("Update");
        sysUser1.setUserName("Update");
        sysUser1.setUserPassword("Update");
        sysUser1.setUserState('0');

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(sysUser);
        System.out.println("testUpdate------------------------------------------------------------------------------------");
        System.out.println("Before: "+json);
        service.update(sysUser1);
        SysUser sysUser2 = service.findById((long)777);
        String json1 = mapper.writeValueAsString(sysUser2);
        System.out.println("After: "+json1);
        System.out.println("---------------------------------------------------------------------------------------------");
        service.deleteById((long)777);
    }
}
