package crm.service.impl;

import crm.domain.Contract;
import crm.domain.Employee;
import crm.domain.Order;
import crm.domain.Potentialcustomer;
import crm.mapper.ContractMapper;
import crm.mapper.OrderMapper;
import crm.mapper.PotentialcustomerMapper;
import crm.page.PageResult;
import crm.query.QueryObject;
import crm.service.IOrderService;
import crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper dao;
    @Autowired
    private ContractMapper dao2;
    Contract contract = new Contract();

    public PageResult queryByCondition(QueryObject qo) {
        Long count = dao.queryByConditionCount(qo);
        if (count > 0) {
            List<Order> result = dao.queryByCondition(qo);
            return new PageResult(count, result);
        } else {
            return PageResult.EMPTY;
        }
    }

    @Override
    public int addContract(Long id) {
        Order order = dao.selectByPrimaryKey(id);
        contract.setSn(UUID.randomUUID().toString());
        contract.setCustomer(order.getCustomer());
        contract.setSigntime(order.getModifytime());
        contract.setSeller(order.getSeller());
        contract.setSum(order.getTotalsum());
        contract.setMoney(order.getTotalsum());
        contract.setIntro(order.getIntro());
        contract.setFile(order.getFile());
        contract.setStatus(0);
        contract.setModifyuser(order.getModifyuser());
        contract.setModifytime(order.getCreatetime());
        dao2.insert(contract);
        return dao.addContract(id);
    }

    @Override
    public int refund(Long id) {
        return dao.refund(id);
    }

    public Order get(Long id) {
        return dao.selectByPrimaryKey(id);
    }


    public List<Order> selectAll() {
        return dao.selectAll();
    }

    @Override
    public int save(Order per) {
        HttpServletRequest request = UserContext.get();
        Employee user = (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
        per.setSeller(user);
        per.setCreatetime(new Date());
        per.setStatus(0);
        return dao.insert(per);
    }

    @Override
    public int update(Order per) {
        HttpServletRequest request = UserContext.get();
        Employee user = (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
        per.setModifyuser(user);
        per.setModifytime(new Date());
        return dao.updateByPrimaryKey(per);
    }

    @Override
    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }
}
