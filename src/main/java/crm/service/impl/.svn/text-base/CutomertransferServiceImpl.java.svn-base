package crm.service.impl;

import crm.domain.Employee;
import crm.domain.Cutomertransfer;
import crm.domain.Potentialcustomer;
import crm.mapper.CutomertransferMapper;
import crm.mapper.PotentialcustomerMapper;
import crm.page.PageResult;
import crm.query.QueryObject;
import crm.service.ICutomertransferService;
import crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@Service
public class CutomertransferServiceImpl implements ICutomertransferService {
    @Autowired
    private CutomertransferMapper dao;
    @Autowired
    private PotentialcustomerMapper dao2;
    Potentialcustomer potentialcustomer=new Potentialcustomer();
    public PageResult queryByCondition(QueryObject qo) {
        Long count=dao.queryByConditionCount(qo);
        if (count>0){
            List<Cutomertransfer> result=dao.queryByCondition(qo);
            return new PageResult(count,result);
        }else{
            return PageResult.EMPTY;
        }
    }

public Cutomertransfer get(Long id) {
        return dao.selectByPrimaryKey(id);
        }


public List<Cutomertransfer> selectAll() {
        return dao.selectAll();
        }

    @Override
    public int save(Cutomertransfer per) {
        HttpServletRequest request= UserContext.get();
        Employee user= (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
        potentialcustomer=dao2.selectByPrimaryKey(per.getCustomer().getId());
        per.setTransuser(user);
        per.setTranstime(new Date());
        per.setOldseller(potentialcustomer.getInchargeuser());
        potentialcustomer.setInchargeuser(per.getNewseller());
        dao2.updateByInchargeuser(potentialcustomer);
        return dao.insert(per);
    }

    @Override
    public int update(Cutomertransfer per) {
        return dao.updateByPrimaryKey(per);
    }

    @Override
    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }
}
