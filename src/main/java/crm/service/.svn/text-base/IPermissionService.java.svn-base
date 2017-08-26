package crm.service;

import crm.domain.Permission;
import crm.page.PageResult;
import crm.query.PermissionQueryObject;

import java.util.List;

/**
 * Created by acer1 on 2017/6/17.
 */
public interface IPermissionService {
    PageResult queryByCondition(PermissionQueryObject qo);

    List<Long> queryByPrimaryKey(Long rid);

    List<Permission> queryByIds(List<Long> ids);

    int save(Permission per);

    int update(Permission per);

    int delete(Long id);

    Permission queryByResource(String function);

    List<Permission> queryPermissionByEid(Long id);

    List<Long> permissionlistByRId(Long id);
}
