package crm.controller;

import crm.domain.Employee;
import crm.domain.Sign;
import crm.domain.Sign;
import crm.page.AjaxResult;
import crm.page.PageResult;
import crm.query.Sign2QueryObject;
import crm.query.SignQueryObject;
import crm.service.ISignService;
import crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class SignController {
    @Autowired
    private ISignService signservice;
    Sign2QueryObject oqo = new Sign2QueryObject();

    @RequestMapping("/sign")
    public String sign() {
        return "sign";
    }

    @RequestMapping("/sign_list")
    @ResponseBody
    public PageResult list(SignQueryObject qo) {
        PageResult result = null;
        result = signservice.queryByCondition(qo);
        return result;
    }

    @RequestMapping("/sign_in")
    @ResponseBody
    public AjaxResult sign_in(Sign obj) {
        HttpServletRequest request = UserContext.get();
        Employee user = (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
        obj.setId(user.getId());
        AjaxResult result = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(" HH:mm:ss ");
            Date d1 = new Date(); //第一个时间
            Date d2 = sdf.parse(" 8:30:00 ");
            SimpleDateFormat f = new SimpleDateFormat("HHmmss"); //格式化为 hhmmss
            int d1Number = Integer.parseInt(f.format(d1).toString()); //将第一个时间格式化后转为int
            int d2Number = Integer.parseInt(f.format(d2).toString()); //将第一个时间格式化后转为int
            if (d1Number > d2Number) {
                obj.setStatus(1);
            } else {
                obj.setStatus(0);
            }
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            oqo.setUser_id(user.getId());
            oqo.setItime(df.parse(df.format(new Date())));
            if (signservice.selectByUserAndTime(oqo) != null) {
                result = new AjaxResult(false, "您已经签到，无需重复签到");
            } else {
                int effectCount = signservice.save(obj);
                if (effectCount > 0) {
                    result = new AjaxResult(true, "签到成功");
                } else {
                    result = new AjaxResult(false, "签到失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "签到异常，请截图并联系管理员");
        }
        return result;
    }

    @RequestMapping("/sign_out")
    @ResponseBody
    public AjaxResult sign_out(Sign obj) {
        HttpServletRequest request = UserContext.get();
        Employee user = (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
        obj.setId(user.getId());
        AjaxResult result = null;
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            oqo.setUser_id(user.getId());
            oqo.setItime(df.parse(df.format(new Date())));
            SimpleDateFormat sdf = new SimpleDateFormat(" HH:mm:ss ");
            Date d1 = new Date(); //第一个时间
            Date d2 = sdf.parse(" 17:30:00 ");
            SimpleDateFormat f = new SimpleDateFormat("HHmmss"); //格式化为 hhmmss
            int d1Number = Integer.parseInt(f.format(d1).toString()); //将第一个时间格式化后转为int
            int d2Number = Integer.parseInt(f.format(d2).toString()); //将第一个时间格式化后转为int
            int status = signservice.selectByUserAndTime(oqo).getStatus();
            if (d1Number < d2Number) {
                if (status == 0) {
                    obj.setStatus(2);
                } else if (status == 1) {
                    obj.setStatus(3);
                }
            } else {
                if (status == 0 || status == 1) {
                    obj.setStatus(status);
                } else if (status == 2) {
                    obj.setStatus(0);
                } else if (status == 3) {
                    obj.setStatus(1);
                }
            }
            if (signservice.selectByUserAndTime(oqo) == null) {
                result = new AjaxResult(false, "您尚未签到无法签退");
            } else {
                obj.setId(signservice.selectByUserAndTime(oqo).getId());
                int effectCount = signservice.update(obj);
                if (effectCount > 0) {
                    result = new AjaxResult(true, "签退成功");
                } else {
                    result = new AjaxResult(false, "签退失败");
                }
            }
    }catch(
    Exception e)

    {
        e.printStackTrace();
        result = new AjaxResult(false, "签退异常，请截图并联系管理员");
    }
        return result;
}

    @RequestMapping("/sign_update")
    @ResponseBody
    public AjaxResult update(Sign obj) {
        AjaxResult result = null;
        try {
            int effectCount = signservice.update(obj);
            if (effectCount > 0) {
                result = new AjaxResult(true, "更新成功");
            } else {
                result = new AjaxResult(false, "更新失败");
            }
        } catch (Exception e) {
            result = new AjaxResult(false, "更新异常，请联系管理员");
        }
        return result;
    }
    @RequestMapping("/sign_addsign")
    @ResponseBody
    public AjaxResult addsign(Sign obj) {
        AjaxResult result = null;
        Calendar cal = Calendar.getInstance();
        try {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
            cal.setTime(new Date());
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            int day = cal.get(Calendar.DAY_OF_MONTH);
            String d1=year+"-"+month+"-"+day+" 8:00:00 ";
            String d2=year+"-"+month+"-"+day+" 19:00:00 ";
            obj.setItime(sdf.parse(d1));
            obj.setOtime(sdf.parse(d2));
            int effectCount = signservice.addsign(obj);
            if (effectCount > 0) {
                result = new AjaxResult(true, "补签成功");
            } else {
                result = new AjaxResult(false, "补签失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "补签异常，请联系管理员");
        }
        return result;
    }

    @RequestMapping("/sign_delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        try {
            int effectCount = signservice.delete(id);
            if (effectCount > 0) {
                result = new AjaxResult(true, "删除成功");
            } else {
                result = new AjaxResult(false, "删除失败");
            }
        } catch (Exception e) {
            result = new AjaxResult(false, "删除异常，请联系管理员");
        }
        return result;
    }
}
