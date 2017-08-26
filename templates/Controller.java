package crm.controller;

import crm.domain.${className};
import crm.domain.${className};
import crm.page.AjaxResult;
import crm.page.PageResult;
import crm.query.${className}QueryObject;
import crm.service.I${className}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ${className}Controller {
    @Autowired
    private I${className}Service ${objectName}service;

    @RequestMapping("/${objectName}")
    public String ${objectName}(){
        return "${objectName}";
    }
    @RequestMapping("/${objectName}_list")
    @ResponseBody
    public PageResult list(${className}QueryObject qo){
        PageResult result=null;
        result=${objectName}service.queryByCondition(qo);
        return result;
    }
    @RequestMapping("/${objectName}_save")
    @ResponseBody
    public AjaxResult save(${className} obj){
        AjaxResult result=null;
        try {
            int effectCount=${objectName}service.save(obj);
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
    @RequestMapping("/${objectName}_update")
    @ResponseBody
    public AjaxResult update(${className} obj){
        AjaxResult result=null;
        try {
            int effectCount=${objectName}service.update(obj);
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
    @RequestMapping("/${objectName}_delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        AjaxResult result=null;
        try {
            int effectCount=${objectName}service.delete(id);
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
