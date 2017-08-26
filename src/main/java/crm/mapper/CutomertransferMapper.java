package crm.mapper;

import crm.domain.Cutomertransfer;
import crm.query.QueryObject;

import java.util.List;

public interface CutomertransferMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Cutomertransfer record);

    Cutomertransfer selectByPrimaryKey(Long id);

    List<Cutomertransfer> selectAll();

    int updateByPrimaryKey(Cutomertransfer record);

    Long queryByConditionCount(QueryObject qo);

    List<Cutomertransfer> queryByCondition(QueryObject qo);
}