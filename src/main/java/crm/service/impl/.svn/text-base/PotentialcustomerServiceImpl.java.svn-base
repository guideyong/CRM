package crm.service.impl;

import crm.domain.Cutomertransfer;
import crm.domain.Employee;
import crm.domain.Potentialcustomer;
import crm.mapper.CutomertransferMapper;
import crm.mapper.PotentialcustomerMapper;
import crm.page.PageResult;
import crm.query.PotentialcustomerQueryObject;
import crm.query.QueryObject;
import crm.service.IPotentialcustomerService;
import crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@Service
public class PotentialcustomerServiceImpl implements IPotentialcustomerService {
    @Autowired
    private PotentialcustomerMapper dao;
    @Autowired
    private CutomertransferMapper dao2;
    Potentialcustomer potentialcustomer=new Potentialcustomer();
    Cutomertransfer cutomertransfer=new Cutomertransfer();
    public PageResult queryByCondition(QueryObject qo) {
        Long count=dao.queryByConditionCount(qo);
        if (count>0){
            List<Potentialcustomer> result=dao.queryByCondition(qo);
            return new PageResult(count,result);
        }else{
            return PageResult.EMPTY;
        }
    }

    @Override
    public int transfer(Potentialcustomer obj){
        potentialcustomer=dao.selectByPrimaryKey(obj.getId());
        HttpServletRequest request= UserContext.get();
        Employee user= (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
        cutomertransfer.setTransuser(user);
        cutomertransfer.setTranstime(new Date());
        cutomertransfer.setCustomer(obj);
        cutomertransfer.setOldseller(potentialcustomer.getInchargeuser());
        cutomertransfer.setNewseller(obj.getInchargeuser());
        cutomertransfer.setTransreason("快速移交");
        dao2.insert(cutomertransfer);
        return dao.updateByInchargeuser(obj);
    }

    @Override
    public int change(Potentialcustomer obj) {
        obj.setChangetime(new Date());
        return dao.change(obj);
    }

    @Override
    public int failOpen(Long id) {
        return dao.failOpen(id);
    }

    @Override
    public PageResult queryByCondition2(PotentialcustomerQueryObject qo) {
        Long count=dao.queryByConditionCount2(qo);
        if (count>0){
            List<Potentialcustomer> result=dao.queryByCondition2(qo);
            return new PageResult(count,result);
        }else{
            return PageResult.EMPTY;
        }
    }

    @Override
    public int lost(Long id) {
        return dao.lost(id);
    }

    @Override
    public int intoPull(Long id) {
        return dao.intoPull(id);
    }

    @Override
    public List<Potentialcustomer> selectAll2() {
        return dao.selectAll2();
    }

    @Override
    public int save2(Potentialcustomer per) {
        HttpServletRequest request=UserContext.get();
        Employee user= (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
        per.setInchargeuser(user);
        per.setInputuser(user);
        per.setInputtime(new Date());
        per.setChangetime(new Date());
        per.setStatus(1);
        System.out.println(per);
        return dao.insert(per);
    }

    @Override
    public List<Potentialcustomer> selectAll3() {
        return dao.selectAll3();
    }

    @Override
    public PageResult queryByCondition3(PotentialcustomerQueryObject qo) {
        Long count=dao.queryByConditionCount3(qo);
        if (count>0){
            List<Potentialcustomer> result=dao.queryByCondition3(qo);
            return new PageResult(count,result);
        }else{
            return PageResult.EMPTY;
        }
    }

    @Override
    public int receive(Potentialcustomer obj) {
        HttpServletRequest request=UserContext.get();
        Employee user= (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
        obj.setInchargeuser(user);
        return dao.receive(obj);
    }

    @Override
    public PageResult queryByCondition4(PotentialcustomerQueryObject qo) {
        Long count=dao.queryByConditionCount4(qo);
        if (count>0){
            List<Potentialcustomer> result=dao.queryByCondition4(qo);
            return new PageResult(count,result);
        }else{
            return PageResult.EMPTY;
        }
    }

    @Override
    public PageResult queryByCondition5(PotentialcustomerQueryObject qo) {
        Long count=dao.queryByConditionCount5(qo);
        if (count>0){
            List<Potentialcustomer> result=dao.queryByCondition5(qo);
            return new PageResult(count,result);
        }else{
            return PageResult.EMPTY;
        }
    }

    public Potentialcustomer get(Long id) {
        return dao.selectByPrimaryKey(id);
        }


public List<Potentialcustomer> selectAll() {
        return dao.selectAll();
        }

    @Override
    public int save(Potentialcustomer per) {
        HttpServletRequest request=UserContext.get();
        Employee user= (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
        per.setInchargeuser(user);
        per.setInputuser(user);
        per.setInputtime(new Date());
        per.setStatus(0);
        System.out.println(per);
        return dao.insert(per);
    }

    @Override
    public int update(Potentialcustomer per) {
        return dao.updateByPrimaryKey(per);
    }

    @Override
    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }
}
