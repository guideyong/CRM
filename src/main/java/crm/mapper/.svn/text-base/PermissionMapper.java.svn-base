package crm.mapper;

import crm.domain.Permission;
import crm.query.PermissionQueryObject;
import crm.query.QueryObject;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Long id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);

    long queryByConditionCount(PermissionQueryObject qo);
    List<Permission> queryByCondition(PermissionQueryObject qo);

    List<Long> queryByPrimaryKey(Long rid);

    List<Permission> queryByIds(List<Long> ids);

    Permission queryByResource(String function);

    List<Permission> queryPermissionByEid(Long id);

    List<Long> permissionlistByRId(Long id);
}