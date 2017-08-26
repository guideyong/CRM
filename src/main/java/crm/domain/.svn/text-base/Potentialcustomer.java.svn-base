package crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter@Getter
public class Potentialcustomer extends BaseDomain{
    private String name;
    private Integer age;
    private Integer gender;//客户性别
    private String tel;//；客户电话
    private String email;//客户邮箱
    private String qq;//客户qq
    private String wechart;//客户微信
    private Systemdictionaryitem job;//客户职业
    private Systemdictionaryitem salarylevel;//收入水平
    private Systemdictionaryitem customersource;//客户来源
    private Employee inchargeuser;//负责人
    private Employee inputuser;//创建人
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date inputtime;//创建时间
    private Integer status;//状态
    private Date changetime;//转正时间
}