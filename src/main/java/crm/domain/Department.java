package crm.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Alias("Department")
@Setter@Getter
public class Department extends BaseDomain{
    private Long id;
    private String sn;//部门编码
    private String name;//部门名称

    private Employee manager;//部门经理
    private Department parent;//上级部门
    private Boolean state;//部门状态
}