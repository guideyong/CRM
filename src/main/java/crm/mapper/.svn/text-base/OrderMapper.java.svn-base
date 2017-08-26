package crm.mapper;

import crm.domain.Order;
import crm.query.QueryObject;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    Order selectByPrimaryKey(Long id);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);

    Long queryByConditionCount(QueryObject qo);

    List<Order> queryByCondition(QueryObject qo);

    int addContract(Long id);

    int refund(Long id);
}