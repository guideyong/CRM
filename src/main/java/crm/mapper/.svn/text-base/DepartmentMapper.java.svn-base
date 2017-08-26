package crm.mapper;

import crm.domain.Department;
import crm.domain.Employee;
import crm.query.DepartmentQueryObject;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Department record);

    Department selectByPrimaryKey(Long id);

    List<Department> selectAll();

    int updateByPrimaryKey(Department record);

    Long queryByConditionCount(DepartmentQueryObject qo);

    List<Employee> queryByCondition(DepartmentQueryObject qo);

    int updateState(Long id);
}