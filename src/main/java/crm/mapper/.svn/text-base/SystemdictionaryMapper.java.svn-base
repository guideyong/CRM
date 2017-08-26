package crm.mapper;

import crm.domain.Systemdictionary;
import crm.query.QueryObject;

import java.util.List;

public interface SystemdictionaryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Systemdictionary record);

    Systemdictionary selectByPrimaryKey(Long id);

    List<Systemdictionary> selectAll();

    int updateByPrimaryKey(Systemdictionary record);

    Long queryByConditionCount(QueryObject qo);

    List<Systemdictionary> queryByCondition(QueryObject qo);
}