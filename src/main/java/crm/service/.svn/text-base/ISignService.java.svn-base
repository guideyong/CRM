package crm.service;

import crm.domain.Sign;
import crm.page.PageResult;
import crm.query.QueryObject;
import crm.query.Sign2QueryObject;

import java.util.List;

public interface ISignService {
    int save(Sign obj);
    int update(Sign obj);
    int delete(Long id);
    Sign get(Long id);
    List<Sign> selectAll();
    PageResult queryByCondition(QueryObject qo);

    Sign selectByUserAndTime(Sign2QueryObject obj);

    int addsign(Sign obj);
}
