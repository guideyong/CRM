package crm.controller;

import crm.domain.Contract;
import crm.domain.Contract;
import crm.domain.Potentialcustomer;
import crm.page.AjaxResult;
import crm.page.PageResult;
import crm.query.ContractQueryObject;
import crm.service.IContractService;
import crm.service.IPotentialcustomerService;
import crm.util.FileUploadUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class ContractController {
    @Autowired
    private IContractService contractservice;
    @Autowired
    private IPotentialcustomerService potentialcustomerService;
    Contract contract=new Contract();
    String classpath = this.getClass().getResource("/").getPath().replaceFirst("/", "");
    String webappRoot = classpath.replaceAll("/WEB-INF/classes/", "");
    @RequestMapping("/contract")
    public String contract(){
        return "contract";
    }
    @RequestMapping("/contract_list")
    @ResponseBody
    public PageResult list(ContractQueryObject qo){
        PageResult result=null;
        result=contractservice.queryByCondition(qo);
        return result;
    }
    @RequestMapping("/contract_save")
    @ResponseBody
    public AjaxResult save(HttpServletRequest request){
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile file = req.getFile("file");
        AjaxResult result = null;
        InputStream is = null;
        FileOutputStream os = null;
        try {
            Potentialcustomer p=potentialcustomerService.get(Long.valueOf(req.getParameter("customer_id")));
            contract.setCustomer(p);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            contract.setSigntime(df.parse(req.getParameter("signtime")));
            contract.setSum(Long.valueOf(req.getParameter("sum")));
            contract.setMoney(Long.valueOf(req.getParameter("money")));
            contract.setPaytime(df.parse(req.getParameter("paytime")));
            contract.setIntro(req.getParameter("intro"));
            if (file.isEmpty()){
                contract.setFile("");
            }else {
                String filename=FileUploadUtil.uploadFile(file.getOriginalFilename());
                is = file.getInputStream();
                os = new FileOutputStream(new File(webappRoot+"//upload//" + filename));
                IOUtils.copy(is, os);
                contract.setFile("/upload/" + filename);
            }
            int effectCount=contractservice.save(contract);
            if (effectCount>0){
                result=new AjaxResult(true,"保存成功");
            }else{
                result=new AjaxResult(false,"保存失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result=new AjaxResult(false,"保存异常，请联系管理员");
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return result;
    }
    @RequestMapping("/contract_update")
    @ResponseBody
    public AjaxResult update(HttpServletRequest request){
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile file = req.getFile("file");
        AjaxResult result = null;
        InputStream is = null;
        FileOutputStream os = null;
        try {
            Potentialcustomer p=potentialcustomerService.get(Long.valueOf(req.getParameter("customer_id")));
            contract.setId(Long.valueOf(req.getParameter("id")));
            contract.setCustomer(p);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            contract.setSigntime(df.parse(req.getParameter("signtime")));
            contract.setSum(Long.valueOf(req.getParameter("sum")));
            contract.setMoney(Long.valueOf(req.getParameter("money")));
            contract.setPaytime(df.parse(req.getParameter("paytime")));
            contract.setIntro(req.getParameter("intro"));
            if (file.isEmpty()){
                contract.setFile(contractservice.get(Long.valueOf(req.getParameter("id"))).getFile());
            }else {
                String filename=FileUploadUtil.uploadFile(file.getOriginalFilename());
                is = file.getInputStream();
                os = new FileOutputStream(new File(webappRoot+"//upload//" + filename));//linux兼容
                IOUtils.copy(is, os);
                contract.setFile("/upload/" + filename);
            }
            int effectCount=contractservice.update(contract);
            if (effectCount>0){
                result=new AjaxResult(true,"更新成功");
            }else{
                result=new AjaxResult(false,"更新失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result=new AjaxResult(false,"更新异常，请联系管理员");
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return result;
    }
    @RequestMapping("/contract_delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        AjaxResult result=null;
        try {
            String file=contractservice.get(id).getFile();
            String filepath=webappRoot+file;
            FileUploadUtil.deleteFile(filepath);
            int effectCount=contractservice.delete(id);
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
    @RequestMapping("/contract_examine")
    @ResponseBody
    public AjaxResult examine(Long id){
        AjaxResult result=null;
        try {
            int effectCount=contractservice.examine(id);
            if (effectCount>0){
                result=new AjaxResult(true,"审核成功");
            }else{
                result=new AjaxResult(false,"审核失败");
            }
        }catch (Exception e){
            result=new AjaxResult(false,"审核异常，请联系管理员");
        }
        return result;
    }
}
