package crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.List;

@Alias("Employee")
@Getter@Setter@ToString
public class Employee extends BaseDomain{
    private String username;//员工账号
    private String realname;//真实姓名
    private String password;//密码
    private String tel;//电话
    private String email;//邮箱
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date inputtime;//录入时间
    private boolean state;//状态0 正常 ，-1离职
    private boolean admin;//超级管理员身份1超级管理员 0普通

    private Department dept;//部门
    private List<Role> roles;//角色
}