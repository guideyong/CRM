package crm.mapper;

import crm.domain.Sign;
import crm.query.QueryObject;
import crm.query.Sign2QueryObject;

import java.util.List;

public interface SignMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Sign record);

    Sign selectByPrimaryKey(Long id);

    List<Sign> selectAll();

    int updateByPrimaryKey(Sign record);

    Long queryByConditionCount(QueryObject qo);

    List<Sign> queryByCondition(QueryObject qo);

    Sign selectByUserAndTime(Sign2QueryObject obj);

    int addsign(Sign obj);
}