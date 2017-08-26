package crm.controller;

import crm.domain.Potentialcustomer;
import crm.domain.Potentialcustomer;
import crm.page.AjaxResult;
import crm.page.PageResult;
import crm.query.PotentialcustomerQueryObject;
import crm.service.IPotentialcustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PotentialcustomerController {
    @Autowired
    private IPotentialcustomerService potentialcustomerservice;

    @RequestMapping("/potentialcustomer")
    public String potentialcustomer(){
        return "potentialcustomer";
    }
    @RequestMapping("/potentialcustomer_list")
    @ResponseBody
    public PageResult list(PotentialcustomerQueryObject qo){
        PageResult result=null;
        result=potentialcustomerservice.queryByCondition(qo);
        return result;
    }
    @RequestMapping("/potentialcustomer_save")
    @ResponseBody
    public AjaxResult save(Potentialcustomer obj){
        AjaxResult result=null;
        try {
            int effectCount=potentialcustomerservice.save(obj);
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
    @RequestMapping("/potentialcustomer_update")
    @ResponseBody
    public AjaxResult update(Potentialcustomer obj){
        AjaxResult result=null;
        try {
            int effectCount=potentialcustomerservice.update(obj);
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
    @RequestMapping("/potentialcustomer_delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        AjaxResult result=null;
        try {
            int effectCount=potentialcustomerservice.delete(id);
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
    @RequestMapping("/potentialcustomer_transfer")
    @ResponseBody
    public AjaxResult transfer(Potentialcustomer obj){
        AjaxResult result=null;
        try {
            int effectCount=potentialcustomerservice.transfer(obj);
            if (effectCount>0){
                result=new AjaxResult(true,"移交成功");
            }else{
                result=new AjaxResult(false,"移交失败");
            }
        }catch (Exception e){
            result=new AjaxResult(false,"移交异常，请联系管理员");
        }
        return result;
    }
    @RequestMapping("/potentialcustomer_change")
    @ResponseBody
    public AjaxResult change(Long id){
        AjaxResult result=null;
        try {
            Potentialcustomer obj=new Potentialcustomer();
            obj.setId(id);
            int effectCount=potentialcustomerservice.change(obj);
            if (effectCount>0){
                result=new AjaxResult(true,"转正成功");
            }else{
                result=new AjaxResult(false,"转正失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result=new AjaxResult(false,"转正异常，请联系管理员");
        }
        return result;
    }
    @RequestMapping("/potentialcustomer_failOpen")
    @ResponseBody
    public AjaxResult failOpen(Long id){
        AjaxResult result=null;
        try {
            int effectCount=potentialcustomerservice.failOpen(id);
            if (effectCount>0){
                result=new AjaxResult(true,"标记为开发失败成功");
            }else{
                result=new AjaxResult(false,"标记失败");
            }
        }catch (Exception e){
            result=new AjaxResult(false,"转正异常，请联系管理员");
        }
        return result;
    }
    @RequestMapping("/potentialcustomer_all")
    @ResponseBody
    public List<Potentialcustomer> all(){
        List<Potentialcustomer> result=null;
        result=potentialcustomerservice.selectAll();
        return result;
    }
    @RequestMapping("/potentialcustomer_all2")
    @ResponseBody
    public List<Potentialcustomer> all2(){
        List<Potentialcustomer> result=null;
        result=potentialcustomerservice.selectAll2();
        return result;
    }
    @RequestMapping("/potentialcustomer_all3")
    @ResponseBody
    public List<Potentialcustomer> all3(){
        List<Potentialcustomer> result=null;
        result=potentialcustomerservice.selectAll3();
        return result;
    }
}
