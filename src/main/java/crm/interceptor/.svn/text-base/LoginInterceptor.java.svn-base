package crm.interceptor;

import crm.domain.Employee;
import crm.util.PermissionUtils;
import crm.util.UserContext;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by acer1 on 2017/6/14.
 */
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        UserContext.set(httpServletRequest);
        Employee user= (Employee) httpServletRequest.getSession().getAttribute(UserContext.USER_IN_SESSION);
        if (user==null){
            httpServletResponse.sendRedirect("/login.jsp");
            return false;
        }
        //对于静态资源handler对应的类为为defaultservlethttphandler此时不需要url控制
        //当handler是handlermethod类型的对象，此时才需要访问控制器的方法，才需要url控制
        //URL权限控制
        //1.将请求变成权限表达式
        if (handler instanceof  HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Object bean = handlerMethod.getBean();
            Method method = handlerMethod.getMethod();
            String function = bean.getClass().getName() + ":" + method.getName();
            //如果返回结果为true表示用户拥有这样的权限或该请求不受控制
            //如果返回false，拦截请求
            if (PermissionUtils.checkPermission(function)) {
                return true;
            } else {
                if (method.isAnnotationPresent(ResponseBody.class)) {
                    httpServletResponse.sendRedirect("nopermission.json");
                } else {
                    httpServletResponse.sendRedirect("nopermission.jsp");
                }
                return false;
            }
        }
        return true;
    }


    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }


    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
