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

import main.java.com.ljd.crm.pojo.Customer;
import main.java.com.ljd.crm.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring//applicationContext-dao.xml","classpath:spring//applicationContext-service.xml" })
public class CustomerServiceTest {

    @Autowired
    private CustomerService service;

    @Test
    public void testFindAll() throws JsonProcessingException {
        List<Customer> list = service.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        String a[] = json.split("},");
        System.out.println("testFindAll----------------------------------------------------------------------------------");
        //System.out.println(json);
        for(String x : a) {
            System.out.println(x);
        }
        System.out.println("---------------------------------------------------------------------------------------------");
    }
    
    @Test
    public void testFindById() throws JsonProcessingException {
        List<Customer> list = new ArrayList<Customer>();
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
        Customer customer = new Customer();
        customer.setCustId((long)999);
        customer.setCustIndustry("testsave");
        customer.setCustLevel("testsave");
        customer.setCustMobile("testsave");
        customer.setCustName("testsave");
        customer.setCustPhone("testsave");
        customer.setCustSource("testsave");
        service.save(customer);
        Customer customer1 = service.findById((long)999);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(customer1);
        System.out.println("testSave-------------------------------------------------------------------------------------");
        System.out.println(json);
        System.out.println("---------------------------------------------------------------------------------------------");
        service.deleteById((long)999);
    }
    
    @Test
    public void testDelete() throws JsonProcessingException {
        Customer customer = new Customer();
        customer.setCustId((long)888);
        customer.setCustIndustry("testdelete");
        customer.setCustLevel("testdelete");
        customer.setCustMobile("testdelete");
        customer.setCustName("testdelete");
        customer.setCustPhone("testdelete");
        customer.setCustSource("testdelete");
        service.save(customer);
        Customer customer1 = service.findById((long)888);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(customer1);
        System.out.println("testDelete------------------------------------------------------------------------------------");
        System.out.println("Before: "+json);
        service.deleteById((long)888);
        Customer customer2 = service.findById((long)888);
        String json1 = mapper.writeValueAsString(customer2);
        System.out.println("After: "+json1);
        System.out.println("---------------------------------------------------------------------------------------------");
    }
    
    @Test
    public void testUpdate() throws JsonProcessingException {
        Customer customer = new Customer();
        customer.setCustId((long)777);
        customer.setCustIndustry("testUpdate");
        customer.setCustLevel("testUpdate");
        customer.setCustMobile("testUpdate");
        customer.setCustName("testUpdate");
        customer.setCustPhone("testUpdate");
        customer.setCustSource("testUpdate");
        service.save(customer);
        
        Customer customer1 = new Customer();
        customer1.setCustId((long)777);
        customer1.setCustIndustry("Update");
        customer1.setCustLevel("Update");
        customer1.setCustMobile("Update");
        customer1.setCustName("Update");
        customer1.setCustPhone("Update");
        customer1.setCustSource("Update");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(customer);
        System.out.println("testUpdate------------------------------------------------------------------------------------");
        System.out.println("Before: "+json);
        service.update(customer1);
        Customer customer2 = service.findById((long)777);
        String json1 = mapper.writeValueAsString(customer2);
        System.out.println("After: "+json1);
        System.out.println("---------------------------------------------------------------------------------------------");
        service.deleteById((long)777);
    }
}
