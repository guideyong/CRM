package crm.service;

import crm.domain.Employee;
import crm.page.PageResult;
import crm.query.QueryObject;

import java.util.List;

/**
 * Created by acer1 on 2017/6/14.
 */
public interface IEmployeeService {
    int save(Employee e);
    int update(Employee e);
    int delete(Long id);
    Employee get(Long id);
    List<Employee> selectAll();
    PageResult queryByCondition(QueryObject qo);
    Employee queryBylogin(String username, String password);
    int updateState(Long id);

    int passwordupdate(Employee e);
}
