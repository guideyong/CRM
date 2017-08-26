package crm.service.impl;

import crm.domain.Employee;
import crm.domain.Sign;
import crm.mapper.SignMapper;
import crm.page.PageResult;
import crm.query.QueryObject;
import crm.query.Sign2QueryObject;
import crm.service.ISignService;
import crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@Service
public class SignServiceImpl implements ISignService {
    @Autowired
    private SignMapper dao;
    public PageResult queryByCondition(QueryObject qo) {
        Long count=dao.queryByConditionCount(qo);
        if (count>0){
            List<Sign> result=dao.queryByCondition(qo);
            return new PageResult(count,result);
        }else{
            return PageResult.EMPTY;
        }
    }

    @Override
    public Sign selectByUserAndTime(Sign2QueryObject oqo) {
        return dao.selectByUserAndTime(oqo);
    }

    @Override
    public int addsign(Sign obj) {
        HttpServletRequest request= UserContext.get();
        Employee user= (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
        obj.setStatus(0);
        obj.setIp(request.getRemoteAddr());
        obj.setAdduser(user);
        obj.setAddtime(new Date());
        return dao.addsign(obj);
    }

    public Sign get(Long id) {
        return dao.selectByPrimaryKey(id);
        }


public List<Sign> selectAll() {
        return dao.selectAll();
        }

    @Override
    public int save(Sign per) {
        HttpServletRequest request= UserContext.get();
        Employee user= (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
        per.setUserId(user);
        per.setIp(request.getRemoteAddr());
        per.setItime(new Date());
        return dao.insert(per);
    }

    @Override
    public int update(Sign per) {
        per.setOtime(new Date());
        return dao.updateByPrimaryKey(per);
    }

    @Override
    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }
}
