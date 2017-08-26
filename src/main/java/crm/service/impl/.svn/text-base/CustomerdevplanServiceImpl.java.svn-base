package crm.service.impl;

import crm.domain.Employee;
import crm.domain.Customerdevplan;
import crm.mapper.CustomerdevplanMapper;
import crm.page.PageResult;
import crm.query.CustomerdevplanQueryObject;
import crm.query.QueryObject;
import crm.service.ICustomerdevplanService;
import crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@Service
public class CustomerdevplanServiceImpl implements ICustomerdevplanService {
    @Autowired
    private CustomerdevplanMapper dao;
    public PageResult queryByCondition(QueryObject qo) {
        Long count=dao.queryByConditionCount(qo);
        if (count>0){
            List<Customerdevplan> result=dao.queryByCondition(qo);
            return new PageResult(count,result);
        }else{
            return PageResult.EMPTY;
        }
    }

    @Override
    public PageResult queryByCondition2(CustomerdevplanQueryObject qo) {
        Long count=dao.queryByConditionCount2(qo);
        if (count>0){
            List<Customerdevplan> result=dao.queryByCondition2(qo);
            return new PageResult(count,result);
        }else{
            return PageResult.EMPTY;
        }
    }

    @Override
    public int save2(Customerdevplan obj) {
        HttpServletRequest request= UserContext.get();
        Employee user= (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
        obj.setInputuser(user);
        obj.setInputtime(new Date());
        obj.setType(1);
        return dao.insert(obj);
    }

    public Customerdevplan get(Long id) {
        return dao.selectByPrimaryKey(id);
        }


public List<Customerdevplan> selectAll() {
        return dao.selectAll();
        }

    @Override
    public int save(Customerdevplan per) {
        HttpServletRequest request= UserContext.get();
        Employee user= (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
        per.setInputuser(user);
        per.setInputtime(new Date());
        per.setType(0);
        return dao.insert(per);
    }

    @Override
    public int update(Customerdevplan per) {
        return dao.updateByPrimaryKey(per);
    }

    @Override
    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }
}
