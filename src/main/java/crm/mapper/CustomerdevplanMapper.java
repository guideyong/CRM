package crm.mapper;

import crm.domain.Customerdevplan;
import crm.query.CustomerdevplanQueryObject;
import crm.query.QueryObject;

import java.util.List;

public interface CustomerdevplanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Customerdevplan record);

    Customerdevplan selectByPrimaryKey(Long id);

    List<Customerdevplan> selectAll();

    int updateByPrimaryKey(Customerdevplan record);

    Long queryByConditionCount(QueryObject qo);

    List<Customerdevplan> queryByCondition(QueryObject qo);

    Long queryByConditionCount2(CustomerdevplanQueryObject qo);

    List<Customerdevplan> queryByCondition2(CustomerdevplanQueryObject qo);

}