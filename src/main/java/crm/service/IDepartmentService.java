package crm.service;

import crm.domain.Department;
import crm.page.PageResult;
import crm.query.DepartmentQueryObject;
import crm.query.QueryObject;

import java.util.List;

/**
 * Created by acer1 on 2017/6/14.
 */
public interface IDepartmentService {
    int save(Department dept);
    int update(Department dept);
    int delete(Long id);
    Department get(Long id);
    List<Department> selectAll();
    PageResult queryByCondition(DepartmentQueryObject qo);
    int updateState(Long id);
}
