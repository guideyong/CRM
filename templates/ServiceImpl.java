package crm.service.impl;

import crm.domain.Employee;
import crm.domain.${className};
import crm.mapper.${className}Mapper;
import crm.page.PageResult;
import crm.query.QueryObject;
import crm.service.I${className}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ${className}ServiceImpl implements I${className}Service {
    @Autowired
    private ${className}Mapper dao;
    public PageResult queryByCondition(QueryObject qo) {
        Long count=dao.queryByConditionCount(qo);
        if (count>0){
            List<${className}> result=dao.queryByCondition(qo);
            return new PageResult(count,result);
        }else{
            return PageResult.EMPTY;
        }
    }

public ${className} get(Long id) {
        return dao.selectByPrimaryKey(id);
        }


public List<${className}> selectAll() {
        return dao.selectAll();
        }

    @Override
    public int save(${className} per) {
        return dao.insert(per);
    }

    @Override
    public int update(${className} per) {
        return dao.updateByPrimaryKey(per);
    }

    @Override
    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }
}
