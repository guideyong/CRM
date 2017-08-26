package crm.service.impl;

import crm.domain.Employee;
import crm.domain.Systemdictionaryitem;
import crm.mapper.SystemdictionaryitemMapper;
import crm.page.PageResult;
import crm.query.QueryObject;
import crm.service.ISystemdictionaryitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SystemdictionaryitemServiceImpl implements ISystemdictionaryitemService {
    @Autowired
    private SystemdictionaryitemMapper dao;
    public PageResult queryByCondition(QueryObject qo) {
        Long count=dao.queryByConditionCount(qo);
        if (count>0){
            List<Systemdictionaryitem> result=dao.queryByCondition(qo);
            return new PageResult(count,result);
        }else{
            return PageResult.EMPTY;
        }
    }

    @Override
    public List<Systemdictionaryitem> selectByPrimaryKey(Long id) {
        return dao.selectByPrimaryKey(id);
    }

public List<Systemdictionaryitem> selectAll() {
        return dao.selectAll();
        }

    @Override
    public int save(Systemdictionaryitem per) {
        return dao.insert(per);
    }

    @Override
    public int update(Systemdictionaryitem per) {
        return dao.updateByPrimaryKey(per);
    }

    @Override
    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }
}
