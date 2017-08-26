package crm.controller;

import crm.domain.Customerdevplan;
import crm.domain.Customerdevplan;
import crm.domain.Potentialcustomer;
import crm.page.AjaxResult;
import crm.page.PageResult;
import crm.query.CustomerdevplanQueryObject;
import crm.service.ICustomerdevplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CustomerdevplanController {
    @Autowired
    private ICustomerdevplanService customerdevplanservice;

    @RequestMapping("/customerdevplan")
    public String customerdevplan(){
        return "customerdevplan";
    }
    @RequestMapping("/customerdevplan_list")
    @ResponseBody
    public PageResult list(CustomerdevplanQueryObject qo){
        PageResult result=null;
        result=customerdevplanservice.queryByCondition(qo);
        return result;
    }
    @RequestMapping("/customerdevplan_save")
    @ResponseBody
    public AjaxResult save(Customerdevplan obj){
        AjaxResult result=null;
        try {

            int effectCount=customerdevplanservice.save(obj);
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
    @RequestMapping("/customerdevplan_update")
    @ResponseBody
    public AjaxResult update(Customerdevplan obj){
        AjaxResult result=null;
        try {
            int effectCount=customerdevplanservice.update(obj);
            if (effectCount>0){
                result=new AjaxResult(true,"更新成功");
            }else{
                result=new AjaxResult(false,"更新失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result=new AjaxResult(false,"更新异常，请联系管理员");
        }
        return result;
    }
    @RequestMapping("/customerdevplan_delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        AjaxResult result=null;
        try {
            int effectCount=customerdevplanservice.delete(id);
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
