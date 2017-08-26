package crm.controller;

import crm.domain.Systemdictionary;
import crm.domain.Systemdictionary;
import crm.page.AjaxResult;
import crm.page.PageResult;
import crm.query.SystemdictionaryQueryObject;
import crm.service.ISystemdictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SystemdictionaryController {
    @Autowired
    private ISystemdictionaryService systemdictionaryservice;

    @RequestMapping("/systemdictionary")
    public String systemdictionary(){
        return "systemdictionary";
    }
    @RequestMapping("/systemdictionary_list")
    @ResponseBody
    public List<Systemdictionary> list(){
        List<Systemdictionary> result=null;
        result=systemdictionaryservice.selectAll();
        return result;
    }
    @RequestMapping("/systemdictionary_save")
    @ResponseBody
    public AjaxResult save(Systemdictionary obj){
        AjaxResult result=null;
        try {
            int effectCount=systemdictionaryservice.save(obj);
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
    @RequestMapping("/systemdictionary_update")
    @ResponseBody
    public AjaxResult update(Systemdictionary obj){
        AjaxResult result=null;
        try {
            int effectCount=systemdictionaryservice.update(obj);
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
    @RequestMapping("/systemdictionary_delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        AjaxResult result=null;
        try {
            int effectCount=systemdictionaryservice.delete(id);
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
