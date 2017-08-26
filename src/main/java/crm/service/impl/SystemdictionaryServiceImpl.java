package crm.service.impl;

import crm.domain.Employee;
import crm.domain.Systemdictionary;
import crm.mapper.SystemdictionaryMapper;
import crm.page.PageResult;
import crm.query.QueryObject;
import crm.service.ISystemdictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SystemdictionaryServiceImpl implements ISystemdictionaryService {
    @Autowired
    private SystemdictionaryMapper dao;
    public PageResult queryByCondition(QueryObject qo) {
        Long count=dao.queryByConditionCount(qo);
        if (count>0){
            List<Systemdictionary> result=dao.queryByCondition(qo);
            return new PageResult(count,result);
        }else{
            return PageResult.EMPTY;
        }
    }

public Systemdictionary get(Long id) {
        return dao.selectByPrimaryKey(id);
        }


public List<Systemdictionary> selectAll() {
        return dao.selectAll();
        }

    @Override
    public int save(Systemdictionary per) {
        return dao.insert(per);
    }

    @Override
    public int update(Systemdictionary per) {
        return dao.updateByPrimaryKey(per);
    }

    @Override
    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }
}
