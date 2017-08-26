package crm.mapper;

import crm.domain.Systemdictionaryitem;
import crm.query.QueryObject;

import java.util.List;

public interface SystemdictionaryitemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Systemdictionaryitem record);

    List<Systemdictionaryitem> selectByPrimaryKey(Long id);

    List<Systemdictionaryitem> selectAll();

    int updateByPrimaryKey(Systemdictionaryitem record);

    Long queryByConditionCount(QueryObject qo);

    List<Systemdictionaryitem> queryByCondition(QueryObject qo);
}