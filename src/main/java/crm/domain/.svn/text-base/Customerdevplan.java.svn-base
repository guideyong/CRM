package crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Setter@Getter
public class Customerdevplan extends BaseDomain{
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date plantime;//计划时间
    private String plansubject;//计划主题
    private String plandetails;//计划内容
    private Systemdictionaryitem plantype;//计划实施方式
    private Integer traceresult;//跟进效果
    private String remark;//备注
    private Potentialcustomer customerid;//潜在客户
    private Employee inputuser;//创建人
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date inputtime;//创建时间
    private Integer type;//类型
}