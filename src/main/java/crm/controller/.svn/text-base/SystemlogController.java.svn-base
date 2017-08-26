package crm.controller;

import crm.domain.Systemlog;
import crm.domain.Systemlog;
import crm.page.AjaxResult;
import crm.page.PageResult;
import crm.query.SystemlogQueryObject;
import crm.service.ISystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SystemlogController {
    @Autowired
    private ISystemLogService systemlogservice;

    @RequestMapping("/systemlog")
    public String systemlog(){
        return "systemlog";
    }
    @RequestMapping("/systemlog_list")
    @ResponseBody
    public PageResult list(SystemlogQueryObject qo){
        PageResult result=null;
        result=systemlogservice.queryByCondition(qo);
        return result;
    }
    @RequestMapping("/systemlog_save")
    @ResponseBody
    public AjaxResult save(Systemlog obj){
        AjaxResult result=null;
        try {
            int effectCount=systemlogservice.save(obj);
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
    @RequestMapping("/systemlog_update")
    @ResponseBody
    public AjaxResult update(Systemlog obj){
        AjaxResult result=null;
        try {
            int effectCount=systemlogservice.update(obj);
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
    @RequestMapping("/systemlog_delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        AjaxResult result=null;
        try {
            int effectCount=systemlogservice.delete(id);
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
