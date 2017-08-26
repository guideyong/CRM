package crm.mapper;

import crm.domain.Contract;
import crm.query.ContractQueryObject;
import crm.query.PotentialcustomerQueryObject;
import crm.query.QueryObject;

import java.util.List;

public interface ContractMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Contract record);

    Contract selectByPrimaryKey(Long id);

    List<Contract> selectAll();

    int updateByPrimaryKey(Contract record);

    Long queryByConditionCount(QueryObject qo);

    List<Contract> queryByCondition(QueryObject qo);

    int examine(Long id);

    Long queryByConditionCount2(ContractQueryObject qo);

    List<Contract> queryByCondition2(ContractQueryObject qo);
}