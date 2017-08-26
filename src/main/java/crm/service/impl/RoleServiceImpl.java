package crm.service.impl;

import crm.domain.Permission;
import crm.domain.Role;
import crm.mapper.RoleMapper;
import crm.page.PageResult;
import crm.query.QueryObject;
import crm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by acer1 on 2017/6/14.
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper dao;

    public int save(Role r) {
        int effectCount=dao.insert(r);
        //处理中间表关系
        List<Permission> permissions=r.getPermissions();
        if (permissions!=null){
            for (Permission permission : permissions) {
                dao.handlerRelation(r.getId(),permission.getId());
            }
        }
        return effectCount;
    }

    public int update(Role r) {
        int effectCount= dao.updateByPrimaryKey(r);
        dao.deleteRelation(r.getId());
        //处理中间表关系
        List<Permission> permissions=r.getPermissions();
        if (permissions!=null){
            for (Permission permission : permissions) {
                dao.handlerRelation(r.getId(),permission.getId());
            }
        }
        return effectCount;
    }


    public int delete(Long id) {
        dao.deleteRelation(id);
        return dao.deleteByPrimaryKey(id);
    }


    public Role get(Long id) {
        return dao.selectByPrimaryKey(id);
    }


    public List<Role> selectAll() {
        return dao.selectAll();
    }


    public PageResult queryByCondition(QueryObject qo) {
        Long count=dao.queryByConditionCount(qo);
        if (count>0){
            List<Role> result=dao.queryByCondition(qo);
            return new PageResult(count,result);
        }else{
            return PageResult.EMPTY;
        }
    }

    public List<Long> queryRoleByEid(Long eid) {
        return dao.queryRoleByEid(eid);
    }

}
