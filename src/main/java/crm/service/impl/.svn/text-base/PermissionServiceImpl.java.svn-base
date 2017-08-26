package crm.service.impl;

import crm.domain.Permission;
import crm.mapper.PermissionMapper;
import crm.page.PageResult;
import crm.query.PermissionQueryObject;
import crm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by acer1 on 2017/6/17.
 */
@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private PermissionMapper dao;
    public PageResult queryByCondition(PermissionQueryObject qo) {
        Long count=dao.queryByConditionCount(qo);
        if (count>0){
            List<Permission> result=dao.queryByCondition(qo);
            return new PageResult(count,result);
        }else{
            return PageResult.EMPTY;
        }
    }

    @Override
    public List<Long> queryByPrimaryKey(Long rid) {
        return dao.queryByPrimaryKey(rid);
    }

    @Override
    public List<Permission> queryByIds(List<Long> ids) {
        return dao.queryByIds(ids);
    }

    @Override
    public int save(Permission per) {
        return dao.insert(per);
    }

    @Override
    public int update(Permission per) {
        return dao.updateByPrimaryKey(per);
    }

    @Override
    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public Permission queryByResource(String function) {
        return dao.queryByResource(function);
    }

    @Override
    public List<Permission> queryPermissionByEid(Long id) {
        return dao.queryPermissionByEid(id);
    }

    @Override
    public List<Long> permissionlistByRId(Long id) {
        return dao.permissionlistByRId(id);
    }
}
