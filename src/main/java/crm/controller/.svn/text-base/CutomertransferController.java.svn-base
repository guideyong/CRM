package crm.controller;

import crm.domain.Cutomertransfer;
import crm.domain.Cutomertransfer;
import crm.page.AjaxResult;
import crm.page.PageResult;
import crm.query.CutomertransferQueryObject;
import crm.service.ICutomertransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CutomertransferController {
    @Autowired
    private ICutomertransferService cutomertransferservice;

    @RequestMapping("/cutomertransfer")
    public String cutomertransfer(){
        return "cutomertransfer";
    }
    @RequestMapping("/cutomertransfer_list")
    @ResponseBody
    public PageResult list(CutomertransferQueryObject qo){
        PageResult result=null;
        result=cutomertransferservice.queryByCondition(qo);
        return result;
    }
    @RequestMapping("/cutomertransfer_save")
    @ResponseBody
    public AjaxResult save(Cutomertransfer obj){
        AjaxResult result=null;
        try {
            int effectCount=cutomertransferservice.save(obj);
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
    @RequestMapping("/cutomertransfer_update")
    @ResponseBody
    public AjaxResult update(Cutomertransfer obj){
        AjaxResult result=null;
        try {
            int effectCount=cutomertransferservice.update(obj);
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
    @RequestMapping("/cutomertransfer_delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        AjaxResult result=null;
        try {
            int effectCount=cutomertransferservice.delete(id);
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
