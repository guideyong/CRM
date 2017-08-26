package crm.service;

import crm.domain.Systemlog;
import crm.page.PageResult;
import crm.query.QueryObject;

import java.util.List;


public interface ISystemLogService {
    int save(Systemlog obj);
    int update(Systemlog obj);
    int delete(Long id);
    Systemlog get(Long id);
    List<Systemlog> selectAll();
    PageResult queryByCondition(QueryObject qo);
}
