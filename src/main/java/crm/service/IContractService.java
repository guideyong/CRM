package crm.service;

import crm.domain.Contract;
import crm.page.PageResult;
import crm.query.ContractQueryObject;
import crm.query.PotentialcustomerQueryObject;
import crm.query.QueryObject;

import java.util.List;

public interface IContractService {
    int save(Contract obj);
    int update(Contract obj);
    int delete(Long id);
    Contract get(Long id);
    List<Contract> selectAll();
    PageResult queryByCondition(QueryObject qo);

    int examine(Long id);

    PageResult queryByCondition2(ContractQueryObject qo);
}
