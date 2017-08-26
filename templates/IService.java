package crm.service;

import crm.domain.${className};
import crm.page.PageResult;
import crm.query.QueryObject;

import java.util.List;

public interface I${className}Service {
    int save(${className} obj);
    int update(${className} obj);
    int delete(Long id);
    ${className} get(Long id);
    List<${className}> selectAll();
    PageResult queryByCondition(QueryObject qo);
}
