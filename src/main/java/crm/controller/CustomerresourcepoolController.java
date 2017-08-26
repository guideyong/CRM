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

import java.util.List;

@Controller
public class CustomerresourcepoolController {
    @Autowired
    private IPotentialcustomerService customerresourcepoolservice;

    @RequestMapping("/customerresourcepool")
    public String customerresourcepool(){
        return "customerresourcepool";
    }
    @RequestMapping("/customerresourcepool_list")
    @ResponseBody
    public PageResult list(PotentialcustomerQueryObject qo){
        PageResult result=null;
        result=customerresourcepoolservice.queryByCondition3(qo);
        return result;
    }
    @RequestMapping("/customerresourcepool_receive")
    @ResponseBody
    public AjaxResult receive(Potentialcustomer obj){
        AjaxResult result=null;
        try {
            int effectCount=customerresourcepoolservice.receive(obj);
            if (effectCount>0){
                result=new AjaxResult(true,"吸纳成功");
            }else{
                result=new AjaxResult(false,"吸纳失败");
            }
        }catch (Exception e){
            result=new AjaxResult(false,"吸纳异常，请联系管理员");
        }
        return result;
    }
}
