package crm.mapper;

import crm.domain.Employee;
import crm.query.QueryObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Employee record);
    Employee selectByPrimaryKey(Long id);
    List<Employee> selectAll();
    int updateByPrimaryKey(Employee record);
    Long queryByConditionCount(QueryObject qo);
    List<Employee> queryByCondition(QueryObject qo);
    Employee queryByLogin(@Param("username")String username,@Param("password")String password);
    int updateState(Long id);
    int handlerRelation(@Param("eid") Long eid,@Param("rid") Long rid);
    int deleteRelation(Long eid);

    int passwordupdate(Employee e);
}