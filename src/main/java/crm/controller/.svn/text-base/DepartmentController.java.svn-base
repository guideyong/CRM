package crm.controller;

import crm.domain.Department;
import crm.domain.Department;
import crm.page.AjaxResult;
import crm.page.PageResult;
import crm.query.DepartmentQueryObject;
import crm.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by acer1 on 2017/6/14.
 */
@Controller
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("/department")
    public String department(){
        return "department";
    }
    @RequestMapping("/department_queryForEmp")
    @ResponseBody
    public List queryForEmp(){
        List result=null;
        result=departmentService.selectAll();
        return result;
    }
    @RequestMapping("/department_list")
    @ResponseBody
    public PageResult list(DepartmentQueryObject qo) {
        PageResult result=null;
        result= departmentService.queryByCondition(qo);
        return result;
    }
    @RequestMapping("/department_save")
    @ResponseBody
    public AjaxResult save(Department dept){
        AjaxResult result=null;
        try {
            dept.setState(true);
            int effectCount=departmentService.save(dept);
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
    @RequestMapping("/department_update")
    @ResponseBody
    public AjaxResult update(Department dept){
        AjaxResult result=null;
        try {
            int effectCount=departmentService.update(dept);
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
    @RequestMapping("/department_delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        AjaxResult result=null;
        try {
            int effectCount=departmentService.updateState(id);
            if (effectCount>0){
                result=new AjaxResult(true,"停用成功");
            }else{
                result=new AjaxResult(false,"停用失败");
            }
        }catch (Exception e){
            result=new AjaxResult(false,"停用异常，请联系管理员");
        }
        return result;
    }
}
