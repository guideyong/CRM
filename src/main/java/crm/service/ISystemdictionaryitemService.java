package crm.service;

import crm.domain.Systemdictionaryitem;
import crm.page.PageResult;
import crm.query.QueryObject;

import java.util.List;

public interface ISystemdictionaryitemService {
    int save(Systemdictionaryitem obj);
    int update(Systemdictionaryitem obj);
    int delete(Long id);
    List<Systemdictionaryitem> selectAll();
    PageResult queryByCondition(QueryObject qo);
    List<Systemdictionaryitem> selectByPrimaryKey(Long id);
 }
