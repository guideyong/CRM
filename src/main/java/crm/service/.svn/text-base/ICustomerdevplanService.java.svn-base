package crm.service;

import crm.domain.Customerdevplan;
import crm.page.PageResult;
import crm.query.CustomerdevplanQueryObject;
import crm.query.QueryObject;

import java.util.List;

public interface ICustomerdevplanService {
    int save(Customerdevplan obj);
    int update(Customerdevplan obj);
    int delete(Long id);
    Customerdevplan get(Long id);
    List<Customerdevplan> selectAll();
    PageResult queryByCondition(QueryObject qo);

    PageResult queryByCondition2(CustomerdevplanQueryObject qo);

    int save2(Customerdevplan obj);
}
