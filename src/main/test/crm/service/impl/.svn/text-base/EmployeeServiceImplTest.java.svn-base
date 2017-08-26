package crm.service.impl;

import crm.domain.Employee;
import crm.service.IEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;



/**
 * Created by acer1 on 2017/6/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class EmployeeServiceImplTest {
    @Autowired
    IEmployeeService employeeService;
    @Test
    public void save() throws Exception {
        Employee e=new Employee();
        e.setAdmin(true);
        e.setEmail("898001387@qq.com");
        e.setInputtime(new Date());
        e.setPassword("123456");
        e.setState(true);
        e.setTel("18292164833");
        e.setUsername("桂德雍");
        e.setRealname("超级管理员");
        employeeService.save(e);
    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void get() throws Exception {

    }

    @Test
    public void selectAll() throws Exception {

    }

    @Test
    public void selectByCondition() throws Exception {

    }

}