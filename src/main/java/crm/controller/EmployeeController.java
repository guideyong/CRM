package crm.controller;

import crm.domain.Employee;
import crm.domain.Permission;
import crm.page.AjaxResult;
import crm.page.PageResult;
import crm.query.EmployeeQueryObject;
import crm.service.IEmployeeService;
import crm.service.IPermissionService;
import crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by acer1 on 2017/6/14.
 */
@Controller
public class  EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IPermissionService permissionService;
    @RequestMapping("/employee")
    public String employee(){
        return "employee";
    }
    @RequestMapping("/login")
    @ResponseBody
    public AjaxResult login(String username, String password, HttpServletRequest request) {
        UserContext.set(request);
        AjaxResult result=null;
        Employee user = employeeService.queryBylogin(username, password);
        if (user != null) {
            request.getSession().setAttribute(UserContext.USER_IN_SESSION, user);
            //查询用户权限
            List<Permission> userPermission=permissionService.queryPermissionByEid(user.getId());
            request.getSession().setAttribute(UserContext.PERMISSION_IN_SESSION,userPermission);
            result=new AjaxResult(true,"登陆成功");
        } else {
            result=new AjaxResult(false,"账号或密码有误");
        }
        return result;
    }

    @RequestMapping("/employee_list")
    @ResponseBody
    public PageResult list(EmployeeQueryObject qo) {
        PageResult result=null;
        result= employeeService.queryByCondition(qo);
        return result;
    }
    @RequestMapping("/employee_all")
    @ResponseBody
    public List<Employee> all() {
        List<Employee> result=null;
        result= employeeService.selectAll();
        return result;
    }


    @RequestMapping("/employee_save")
    @ResponseBody
    public AjaxResult save(Employee emp){
        AjaxResult result=null;
        try {
            emp.setAdmin(false);
            emp.setInputtime(new Date());
            emp.setState(true);
            emp.setPassword("123456");
            int effectCount=employeeService.save(emp);
            if (effectCount>0){
                result=new AjaxResult(true,"保存成功");
            }else{
                result=new AjaxResult(false,"保存失败");
            }
        }catch (Exception e){
            result=new AjaxResult(false,"保存异常，请联系管理员");
        }
        return result;
    }
    @RequestMapping("/employee_update")
    @ResponseBody
    public AjaxResult update(Employee emp){
        AjaxResult result=null;
        try {
            int effectCount=employeeService.update(emp);
            if (effectCount>0){
                result=new AjaxResult(true,"更新成功");
            }else{
                result=new AjaxResult(false,"更新失败");
            }
        }catch (Exception e){
            result=new AjaxResult(false,"更新异常，请联系管理员");
        }
        return result;
    }
    @RequestMapping("/password_update")
    @ResponseBody
    public AjaxResult passwordupdate(String oldpassword,String newpassword){
        HttpServletRequest request = UserContext.get();
        Employee user = (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
        AjaxResult result=null;
        Employee es=new Employee();
        try {
            if (oldpassword.equals(user.getPassword())){
                es.setId(user.getId());
                es.setPassword(newpassword);
                int effectCount = employeeService.passwordupdate(es);
                if (effectCount > 0) {
                    result = new AjaxResult(true, "密码修改成功,请重新登录");
                } else {
                    result = new AjaxResult(false, "修改失败");
                }
            }else {
                result=new AjaxResult(false,"原密码错误");
            }
        }catch (Exception e){
            e.printStackTrace();
            result=new AjaxResult(false,"修改异常，请联系管理员");
        }
        return result;
    }
    @RequestMapping("/employee_delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        AjaxResult result=null;
        try {
            int effectCount=employeeService.updateState(id);
            if (effectCount>0){
                result=new AjaxResult(true,"离职成功");
            }else{
                result=new AjaxResult(false,"离职失败");
            }
        }catch (Exception e){
            result=new AjaxResult(false,"离职异常，请联系管理员");
        }
        return result;
    }
    @RequestMapping("/employee_queryFordept")
    @ResponseBody
    public List queryFordept(){
        List result=null;
        result=employeeService.selectAll();
        return result;
    }
}
