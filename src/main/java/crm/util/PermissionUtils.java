package crm.util;

import crm.domain.Employee;
import crm.domain.Permission;
import crm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.List;

@Component
public class PermissionUtils {
    private static IPermissionService permissionService;
    @Autowired
    public void setPermissionService(IPermissionService permissionService) {
        PermissionUtils.permissionService = permissionService;
    }
    public static boolean checkPermission(String function) {
        HttpSession session=UserContext.get().getSession();
        Employee user= (Employee) session.getAttribute(UserContext.USER_IN_SESSION);
        if (user.isAdmin()){
            return true;
        }
        //需要查询权限表，来看是否需要权限控制
        Permission p=permissionService.queryByResource(function);
        if (p!=null){
            //该请求需要权限控制
            //获取用户权限
            String allFunction=function.split(":")[0]+":"+"All";
            List<Permission> userPermission= (List<Permission>) UserContext.get().getSession().getAttribute(UserContext.PERMISSION_IN_SESSION);
            for (Permission permission : userPermission) {
                //用户支持all权限，都放行,用户拥有该权限也放行
                if (permission.getResource().equals(function)||permission.getResource().equals(allFunction)){
                    //能找到说明用户有这样的权限集合
                    return true;
                }
            }
            return false;

        }else {
            //不需要权限控制直接放行
            return true;
        }
    }
}
