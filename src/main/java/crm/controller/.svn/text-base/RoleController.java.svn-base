package crm.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import crm.domain.Role;
import crm.page.AjaxResult;
import crm.page.PageResult;
import crm.query.EmployeeQueryObject;
import crm.query.RoleQueryObject;
import crm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by acer1 on 2017/6/17.
 */
@Controller
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping("/role")
    public String role() {
        return "role";
    }

    @RequestMapping("/role_list")
    @ResponseBody
    public PageResult list(RoleQueryObject qo) {
        PageResult result = null;
        result = roleService.queryByCondition(qo);
        return result;
    }
    @RequestMapping("/role_save")
    @ResponseBody
    public AjaxResult save(Role role){
        AjaxResult result=null;
        try {
            int effectCount=roleService.save(role);
            if (effectCount>0){
                result=new AjaxResult(true,"保存成功");
            }else {
                result=new AjaxResult(false,"保存失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result=new AjaxResult(false,"保存异常，请联系管理员");
        }
        return result;
    }

    @RequestMapping("/role_queryForEmp")
    @ResponseBody
    public List<Role> queryForEmp(){
        List<Role> result=null;
        result=roleService.selectAll();
        return result;
    }
    @RequestMapping("/role_queryRoleByEid")
    @ResponseBody
    public List<Long> queryRoleByEid(Long eid) {
        List<Long> result = null;
        result = roleService.queryRoleByEid(eid);
        return result;
    }

    @RequestMapping("/role_update")
    @ResponseBody
    public AjaxResult update(Role role){
        AjaxResult result=null;
        try {
            int effectCount=roleService.update(role);
            if (effectCount>0){
                result=new AjaxResult(true,"更新成功");
            }else {
                result=new AjaxResult(false,"更新失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result=new AjaxResult(false,"更新异常，请联系管理员");
        }
        return result;
    }
    @RequestMapping("/role_delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        AjaxResult result=null;
        try {
            int effectCount=roleService.delete(id);
            if (effectCount>0){
                result=new AjaxResult(true,"删除成功");
            }else{
                result=new AjaxResult(false,"删除失败");
            }
        }catch (Exception e){
            result=new AjaxResult(false,"删除异常，请联系管理员");
        }
        return result;
    }
}
