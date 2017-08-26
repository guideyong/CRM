package crm.service;

import crm.domain.Order;
import crm.page.PageResult;
import crm.query.QueryObject;

import java.util.List;

public interface IOrderService {
    int save(Order obj);
    int update(Order obj);
    int delete(Long id);
    Order get(Long id);
    List<Order> selectAll();
    PageResult queryByCondition(QueryObject qo);
    int addContract(Long id);
    int refund(Long id);
}
