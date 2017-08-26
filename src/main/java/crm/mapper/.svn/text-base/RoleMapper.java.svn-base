package crm.mapper;

import crm.domain.Role;
import crm.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    Long queryByConditionCount(QueryObject qo);

    List<Role> queryByCondition(QueryObject qo);
    int handlerRelation(@Param("rid") Long rid,@Param("pid") Long pid);

    List<Long> queryRoleByEid(Long eid);

    void deleteRelation(Long rid);

    List<Long> permissionlistById(Long id);
}