package crm.controller;

import crm.domain.Order;
import crm.domain.Order;
import crm.domain.Potentialcustomer;
import crm.page.AjaxResult;
import crm.page.PageResult;
import crm.query.OrderQueryObject;
import crm.service.IOrderService;
import crm.service.IPotentialcustomerService;
import crm.util.FileUploadUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

@Controller
public class OrderController {
    @Autowired
    private IOrderService orderservice;
    @Autowired
    private IPotentialcustomerService potentialcustomerService;
    Order order = new Order();
    String classpath = this.getClass().getResource("/").getPath().replaceFirst("/", "");
    String webappRoot = classpath.replaceAll("WEB-INF/classes/", "");
    @RequestMapping("/order")
    public String order() {
        return "order";
    }

    @RequestMapping("/order_list")
    @ResponseBody
    public PageResult list(OrderQueryObject qo) {
        PageResult result = null;
        result = orderservice.queryByCondition(qo);
        return result;
    }

    @RequestMapping("/order_save")
    @ResponseBody
    public AjaxResult save(HttpServletRequest request) {
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile file = req.getFile("file");
        AjaxResult result = null;
        InputStream is = null;
        FileOutputStream os = null;
        try {
            Potentialcustomer p=potentialcustomerService.get(Long.valueOf(req.getParameter("customer_id")));
            order.setCustomer(p);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            order.setSigntime(df.parse(req.getParameter("signtime")));
            order.setTotalsum(Long.valueOf(req.getParameter("totalsum")));
            order.setSum(Long.valueOf(req.getParameter("sum")));
            order.setIntro(req.getParameter("intro"));
            if (file.isEmpty()){
                order.setFile("");
            }else {
                String filename=FileUploadUtil.uploadFile(file.getOriginalFilename());
                is = file.getInputStream();
                os = new FileOutputStream(new File(webappRoot+"//upload//" +filename));
                IOUtils.copy(is, os);
                order.setFile("/upload/" + filename);
            }
            int effectCount = orderservice.save(order);
            if (effectCount > 0) {
                result = new AjaxResult(true, "保存成功");
            } else {
                result = new AjaxResult(false, "保存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "保存异常，请联系管理员");
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

    @RequestMapping("/order_update")
    @ResponseBody
    public AjaxResult update(HttpServletRequest request) {
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile file = req.getFile("file");
        AjaxResult result = null;
        InputStream is = null;
        FileOutputStream os = null;
        try {
            Potentialcustomer p=potentialcustomerService.get(Long.valueOf(req.getParameter("customer_id")));
            order.setCustomer(p);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            order.setId(Long.valueOf(req.getParameter("id")));
            order.setSigntime(df.parse(req.getParameter("signtime")));
            order.setTotalsum(Long.valueOf(req.getParameter("totalsum")));
            order.setSum(Long.valueOf(req.getParameter("sum")));
            order.setIntro(req.getParameter("intro"));
            if (file.isEmpty()){
                order.setFile(orderservice.get(Long.valueOf(req.getParameter("id"))).getFile());
            }else {
                String filename=FileUploadUtil.uploadFile(file.getOriginalFilename());
                is = file.getInputStream();
                os = new FileOutputStream(new File(webappRoot+"//upload//" +filename));//linux兼容
                IOUtils.copy(is, os);
                order.setFile("/upload/" +filename);
            }
            int effectCount = orderservice.update(order);
            if (effectCount > 0) {
                result = new AjaxResult(true, "更新成功");
            } else {
                result = new AjaxResult(false, "更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "更新异常，请联系管理员");
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

    @RequestMapping("/order_delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        try {
            String file=orderservice.get(id).getFile();
            String filepath=webappRoot+file;
            FileUploadUtil.deleteFile(filepath);
            int effectCount = orderservice.delete(id);
            if (effectCount > 0) {
                result = new AjaxResult(true, "删除成功");
            } else {
                result = new AjaxResult(false, "删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "删除异常，请联系管理员");
        }
        return result;
    }
    @RequestMapping("/order_addContract")
    @ResponseBody
    public AjaxResult addContract(Long id) {
        AjaxResult result = null;
        try {
            int effectCount = orderservice.addContract(id);
            if (effectCount > 0) {
                result = new AjaxResult(true, "生成合同成功");
            } else {
                result = new AjaxResult(false, "生成合同失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "生成合同异常，请联系管理员");
        }
        return result;
    }
    @RequestMapping("/order_refund")
    @ResponseBody
    public AjaxResult refund(Long id) {
        AjaxResult result = null;
        try {
            int effectCount = orderservice.refund(id);
            if (effectCount > 0) {
                result = new AjaxResult(true, "退款成功");
            } else {
                result = new AjaxResult(false, "退款失败");
            }
        } catch (Exception e) {
            result = new AjaxResult(false, "退款异常，请联系管理员");
        }
        return result;
    }
}
