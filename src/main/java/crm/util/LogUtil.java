package crm.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import crm.domain.Employee;
import crm.domain.Systemlog;
import crm.service.ISystemLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by acer1 on 2017/6/17.
 */
public class LogUtil {
    @Autowired
    private ISystemLogService service;
    public void writeLog(JoinPoint joinPoint) throws JsonProcessingException {
        if (joinPoint.getTarget() instanceof ISystemLogService){
            return;
        }
        Systemlog log=new Systemlog();
        log.setOptime(new Date());
        HttpServletRequest request=UserContext.get();
        Employee user= (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
        log.setOpuser(user);
        log.setOpip(request.getRemoteAddr());//获取ip
        Object target=joinPoint.getTarget();//目标对象
        Signature signature = joinPoint.getSignature();//方法签名
        String function = target.getClass().getName() + ":" + signature.getName();//全限定名+“：”+;方法名
        log.setFunction(function);
        ObjectMapper mapper=new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);//不序列化空值
        String paramValue=mapper.writeValueAsString(joinPoint.getArgs());
        log.setParams(paramValue);
        service.save(log);
    }
}
