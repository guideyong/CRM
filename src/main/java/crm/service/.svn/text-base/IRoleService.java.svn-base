package crm.service;

import crm.domain.Role;
import crm.page.PageResult;
import crm.query.QueryObject;

import java.util.List;

/**
 * Created by acer1 on 2017/6/14.
 */
public interface IRoleService {
    int save(Role r);
    int update(Role r);
    int delete(Long id);
    Role get(Long id);
    List<Role> selectAll();
    PageResult queryByCondition(QueryObject qo);
    List<Long> queryRoleByEid(Long eid);
}
