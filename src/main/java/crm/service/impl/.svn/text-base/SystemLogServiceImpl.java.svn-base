package crm.service.impl;

import crm.domain.Systemlog;
import crm.mapper.SystemlogMapper;
import crm.page.PageResult;
import crm.query.QueryObject;
import crm.service.ISystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SystemLogServiceImpl implements ISystemLogService {
    @Autowired
    private SystemlogMapper dao;

    public PageResult queryByCondition(QueryObject qo) {
        Long count = dao.queryByConditionCount(qo);
        if (count > 0) {
            List<Systemlog> result = dao.queryByCondition(qo);
            return new PageResult(count, result);
        } else {
            return PageResult.EMPTY;
        }
    }

    public Systemlog get(Long id) {
        return dao.selectByPrimaryKey(id);
    }


    public List<Systemlog> selectAll() {
        return dao.selectAll();
    }

    @Override
    public int save(Systemlog per) {
        return dao.insert(per);
    }

    @Override
    public int update(Systemlog per) {
        return dao.updateByPrimaryKey(per);
    }

    @Override
    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }
}
