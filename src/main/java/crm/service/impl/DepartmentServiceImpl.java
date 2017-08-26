package crm.service.impl;

import crm.domain.Department;
import crm.domain.Employee;
import crm.mapper.DepartmentMapper;
import crm.page.PageResult;
import crm.query.DepartmentQueryObject;
import crm.query.QueryObject;
import crm.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by acer1 on 2017/6/14.
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    private DepartmentMapper dao;
    public int save(Department dept) {
        return dao.insert(dept);
    }


    public int update(Department dept) {
        return dao.updateByPrimaryKey(dept);
    }


    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }


    public Department get(Long id) {
        return dao.selectByPrimaryKey(id);
    }


    public List<Department> selectAll() {
        return dao.selectAll();
    }

    public PageResult queryByCondition(DepartmentQueryObject qo) {
        Long count = dao.queryByConditionCount(qo);
        if (count > 0) {
            List<Employee> result = dao.queryByCondition(qo);
            return new PageResult(count, result);
        } else {
            return PageResult.EMPTY;
        }
    }

    public int updateState(Long id) {
        return dao.updateState(id);
    }


}
