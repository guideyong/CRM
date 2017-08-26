package crm.mapper;

import crm.domain.Systemlog;
import crm.query.QueryObject;

import java.util.List;

public interface SystemlogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Systemlog record);

    Systemlog selectByPrimaryKey(Long id);

    List<Systemlog> selectAll();

    int updateByPrimaryKey(Systemlog record);

    Long queryByConditionCount(QueryObject qo);

    List<Systemlog> queryByCondition(QueryObject qo);
}