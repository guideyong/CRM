package crm.controller;

import crm.domain.Systemdictionaryitem;
import crm.domain.Systemdictionaryitem;
import crm.page.AjaxResult;
import crm.page.PageResult;
import crm.query.SystemdictionaryitemQueryObject;
import crm.service.ISystemdictionaryitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SystemdictionaryitemController {
    @Autowired
    private ISystemdictionaryitemService systemdictionaryitemservice;

    @RequestMapping("/systemdictionaryitem")
    public String systemdictionaryitem(){
        return "systemdictionaryitem";
    }
    @RequestMapping("/systemdictionaryitem_list")
    @ResponseBody
    public PageResult list(SystemdictionaryitemQueryObject qo){
        PageResult result=null;
        result=systemdictionaryitemservice.queryByCondition(qo);
        return result;
    }
    @RequestMapping("/systemdictionaryitem_save")
    @ResponseBody
    public AjaxResult save(Systemdictionaryitem obj){
        AjaxResult result=null;
        try {
            int effectCount=systemdictionaryitemservice.save(obj);
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
    @RequestMapping("/systemdictionaryitem_update")
    @ResponseBody
    public AjaxResult update(Systemdictionaryitem obj){
        AjaxResult result=null;
        try {
            int effectCount=systemdictionaryitemservice.update(obj);
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
    @RequestMapping("/systemdictionaryitem_delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        AjaxResult result=null;
        try {
            int effectCount=systemdictionaryitemservice.delete(id);
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
    @RequestMapping("/systemdictionaryitem_byone")
    @ResponseBody
    public List<Systemdictionaryitem> list(Long id){
        if (id==null){
            return null;
        }
        List<Systemdictionaryitem> result=null;
        result=systemdictionaryitemservice.selectByPrimaryKey(id);
        return result;
    }
}
