package crm.controller;

import crm.domain.Permission;
import crm.domain.Permission;
import crm.page.AjaxResult;
import crm.page.PageResult;
import crm.query.PermissionQueryObject;
import crm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by acer1 on 2017/6/17.
 */
@Controller
public class PermissionController {
    @Autowired
    private IPermissionService service;

    @RequestMapping("/permission")
    public String permission(){
        return "permission";
    }
    @RequestMapping("/permission_list")
    @ResponseBody
    public PageResult list(PermissionQueryObject qo){
        PageResult result=null;
        result=service.queryByCondition(qo);
        return result;
    }
    @RequestMapping("/permission_listById")
    @ResponseBody
    public List<Permission> listById(Long rid){
        List<Long> ids=null;
        ids=service.queryByPrimaryKey(rid);
        List<Permission> result=null;
        result=service.queryByIds(ids);
        return result;
    }
    @RequestMapping("/permission_listByRId")
    @ResponseBody
    public List<Long> permissionlistById(Long id) {
        List<Long> result = null;
        result = service.permissionlistByRId(id);
        return result;
    }
    @RequestMapping("/permission_save")
    @ResponseBody
    public AjaxResult save(Permission per){
        AjaxResult result=null;
        try {
            int effectCount=service.save(per);
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
    @RequestMapping("/permission_update")
    @ResponseBody
    public AjaxResult update(Permission per){
        AjaxResult result=null;
        try {
            int effectCount=service.update(per);
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
    @RequestMapping("/permission_delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        AjaxResult result=null;
        try {
            int effectCount=service.delete(id);
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
