package crm.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by acer1 on 2017/6/14.
 */
//将请求绑定到线程
public class UserContext {
    public static final String USER_IN_SESSION="userINsession";
    public static final String PERMISSION_IN_SESSION="permissionINsession";
    private static ThreadLocal<HttpServletRequest> local=new ThreadLocal<HttpServletRequest>();
    public static void set(HttpServletRequest request){
        local.set(request);
    }
    public static HttpServletRequest get(){
        return local.get();
    }
}
