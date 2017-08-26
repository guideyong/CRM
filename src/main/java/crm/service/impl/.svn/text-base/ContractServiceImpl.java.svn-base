package crm.service.impl;

import crm.domain.Employee;
import crm.domain.Contract;
import crm.mapper.ContractMapper;
import crm.page.PageResult;
import crm.query.ContractQueryObject;
import crm.query.QueryObject;
import crm.service.IContractService;
import crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    private ContractMapper dao;
    public PageResult queryByCondition(QueryObject qo) {
        Long count=dao.queryByConditionCount(qo);
        if (count>0){
            List<Contract> result=dao.queryByCondition(qo);
            return new PageResult(count,result);
        }else{
            return PageResult.EMPTY;
        }
    }

    @Override
    public int examine(Long id) {
        return dao.examine(id);
    }

    @Override
    public PageResult queryByCondition2(ContractQueryObject qo) {
        Long count=dao.queryByConditionCount2(qo);
        if (count>0){
            List<Contract> result=dao.queryByCondition2(qo);
            return new PageResult(count,result);
        }else{
            return PageResult.EMPTY;
        }
    }

    public Contract get(Long id) {
        return dao.selectByPrimaryKey(id);
        }


public List<Contract> selectAll() {
        return dao.selectAll();
        }

    @Override
    public int save(Contract per) {
        HttpServletRequest request= UserContext.get();
        Employee user= (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
        per.setSeller(user);
        per.setStatus(0);
        per.setSn(UUID.randomUUID().toString());
        return dao.insert(per);
    }

    @Override
    public int update(Contract per) {
        HttpServletRequest request= UserContext.get();
        Employee user= (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
        per.setModifyuser(user);
        per.setModifytime(new Date());
        return dao.updateByPrimaryKey(per);
    }

    @Override
    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }
}
