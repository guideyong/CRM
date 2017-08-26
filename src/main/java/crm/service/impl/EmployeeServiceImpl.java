package crm.service.impl;

import crm.domain.Employee;
import crm.domain.Role;
import crm.mapper.EmployeeMapper;
import crm.page.PageResult;
import crm.query.QueryObject;
import crm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by acer1 on 2017/6/14.
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper dao;

    public int save(Employee e) {
        int effectCount = dao.insert(e);
        List<Role> roles = e.getRoles();
        if (roles != null) {
            for (Role role : roles) {
                dao.handlerRelation(e.getId(), role.getId());
            }
        }
        return effectCount;
    }

    public int update(Employee e) {
        int effectCount = dao.updateByPrimaryKey(e);
        dao.deleteRelation(e.getId());
        List<Role> roles = e.getRoles();
        if (roles != null) {
            for (Role role : roles) {
                dao.handlerRelation(e.getId(), role.getId());
            }
        }
        return effectCount;
    }


    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }


    public Employee get(Long id) {
        return dao.selectByPrimaryKey(id);
    }


    public List<Employee> selectAll() {
        return dao.selectAll();
    }


    public PageResult queryByCondition(QueryObject qo) {
        Long count = dao.queryByConditionCount(qo);
        if (count > 0) {
            List<Employee> result = dao.queryByCondition(qo);
            return new PageResult(count, result);
        } else {
            return PageResult.EMPTY;
        }
    }

    public Employee queryBylogin(String username, String password) {
        return dao.queryByLogin(username, password);
    }

    public int updateState(Long id) {
        return dao.updateState(id);
    }

    @Override
    public int passwordupdate(Employee e) {
        return dao.passwordupdate(e);
    }
}
