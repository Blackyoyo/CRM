package test.java.com.ljd.crm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.com.ljd.crm.pojo.SaleVisit;
import main.java.com.ljd.crm.service.SaleVisitService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring//applicationContext-dao.xml","classpath:spring//applicationContext-service.xml" })
public class SaleVisitServiceTest {

    @Autowired
    private SaleVisitService service;

    @Test
    public void testFindAll() throws JsonProcessingException {
        List<SaleVisit> list = service.findAll();
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
        List<SaleVisit> list = new ArrayList<SaleVisit>();
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
        SaleVisit saleVisit = new SaleVisit();
        saleVisit.setVisitId((long)999);
        saleVisit.setVisitCustId((long)4);
        saleVisit.setVisitUserId((long)2);
        saleVisit.setVisitTime(new Date());
        saleVisit.setVisitAddr("testsave");
        saleVisit.setVisitDetail("testsave");
        saleVisit.setVisitNexttime(new Date());
        
        service.save(saleVisit);
        SaleVisit saleVisit1 = service.findById((long)999);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(saleVisit1);
        System.out.println("testSave-------------------------------------------------------------------------------------");
        System.out.println(json);
        System.out.println("---------------------------------------------------------------------------------------------");
        service.deleteById((long)999);
    }
    
    @Test
    public void testDelete() throws JsonProcessingException {
        SaleVisit saleVisit = new SaleVisit();
        saleVisit.setVisitId((long)888);
        saleVisit.setVisitCustId((long)4);
        saleVisit.setVisitUserId((long)2);
        saleVisit.setVisitTime(new Date());
        saleVisit.setVisitAddr("testdelete");
        saleVisit.setVisitDetail("testdelete");
        saleVisit.setVisitNexttime(new Date());
        
        service.save(saleVisit);
        SaleVisit saleVisit1 = service.findById((long)888);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(saleVisit1);
        System.out.println("testDelete------------------------------------------------------------------------------------");
        System.out.println("Before: "+json);
        service.deleteById((long)888);
        SaleVisit saleVisit2 = service.findById((long)888);
        String json1 = mapper.writeValueAsString(saleVisit2);
        System.out.println("After: "+json1);
        System.out.println("---------------------------------------------------------------------------------------------");
    }
    
    @Test
    public void testUpdate() throws JsonProcessingException {
        SaleVisit saleVisit = new SaleVisit();
        saleVisit.setVisitId((long)777);
        saleVisit.setVisitCustId((long)4);
        saleVisit.setVisitUserId((long)2);
        saleVisit.setVisitTime(new Date());
        saleVisit.setVisitAddr("testupdate");
        saleVisit.setVisitDetail("testupdate");
        saleVisit.setVisitNexttime(new Date());
        service.save(saleVisit);
        
        SaleVisit saleVisit1 = new SaleVisit();
        saleVisit1.setVisitId((long)777);
        saleVisit1.setVisitCustId((long)4);
        saleVisit1.setVisitUserId((long)2);
        saleVisit1.setVisitTime(new Date());
        saleVisit1.setVisitAddr("Update");
        saleVisit1.setVisitDetail("Update");
        saleVisit1.setVisitNexttime(new Date());
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(saleVisit);
        System.out.println("testUpdate------------------------------------------------------------------------------------");
        System.out.println("Before: "+json);
        service.update(saleVisit1);
        SaleVisit saleVisit2 = service.findById((long)777);
        String json1 = mapper.writeValueAsString(saleVisit2);
        System.out.println("After: "+json1);
        System.out.println("---------------------------------------------------------------------------------------------");
        service.deleteById((long)777);
    }
}
