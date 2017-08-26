package crm.controller;

import crm.domain.Potentialcustomer;
import crm.page.AjaxResult;
import crm.page.PageResult;
import crm.query.PotentialcustomerQueryObject;
import crm.service.IPotentialcustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {
    @Autowired
    private IPotentialcustomerService customerservice;

    @RequestMapping("/customer")
    public String customer(){
        return "customer";
    }
    @RequestMapping("/customer_list")
    @ResponseBody
    public PageResult list(PotentialcustomerQueryObject qo){
        PageResult result=null;
        result=customerservice.queryByCondition2(qo);
        return result;
    }
    @RequestMapping("/customer_save")
    @ResponseBody
    public AjaxResult save(Potentialcustomer obj){
        AjaxResult result=null;
        try {
            int effectCount=customerservice.save2(obj);
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
    @RequestMapping("/customer_update")
    @ResponseBody
    public AjaxResult update(Potentialcustomer obj){
        AjaxResult result=null;
        try {
            int effectCount=customerservice.update(obj);
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
    @RequestMapping("/customer_delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        AjaxResult result=null;
        try {
            int effectCount=customerservice.delete(id);
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
    @RequestMapping("/customer_transfer")
    @ResponseBody
    public AjaxResult transfer(Potentialcustomer obj){
        AjaxResult result=null;
        try {
            int effectCount=customerservice.transfer(obj);
            if (effectCount>0){
                result=new AjaxResult(true,"移交成功");
            }else{
                result=new AjaxResult(false,"移交失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result=new AjaxResult(false,"移交异常，请联系管理员");
        }
        return result;
    }

    @RequestMapping("/customer_lost")
    @ResponseBody
    public AjaxResult lost(Long id){
        AjaxResult result=null;
        try {
            Potentialcustomer obj=new Potentialcustomer();
            obj.setId(id);
            int effectCount=customerservice.lost(id);
            if (effectCount>0){
                result=new AjaxResult(true,"流失成功");
            }else{
                result=new AjaxResult(false,"流失失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result=new AjaxResult(false,"流失异常，请联系管理员");
        }
        return result;
    }
    @RequestMapping("/customer_intoPull")
    @ResponseBody
    public AjaxResult intoPull(Long id){
        AjaxResult result=null;
        try {
            Potentialcustomer obj=new Potentialcustomer();
            obj.setId(id);
            int effectCount=customerservice.intoPull(id);
            if (effectCount>0){
                result=new AjaxResult(true,"移入资源池成功");
            }else{
                result=new AjaxResult(false,"移入资源池失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result=new AjaxResult(false,"移入资源池异常，请联系管理员");
        }
        return result;
    }
}
