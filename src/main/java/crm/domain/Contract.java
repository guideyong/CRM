package crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Setter@Getter
public class Contract extends BaseDomain{
    private String sn;//合同单号
    private Potentialcustomer customer;//合同客户
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date signtime;//签订时间
    private Employee seller;//营销人员
    private Long sum;//合同金额
    private Long money;//付款金额
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date paytime;//付款时间
    private String intro;//合同摘要
    private Integer status;//审核状态0:初始录入.1:审核通过,2:审核拒绝
    private String file;//附件
    private Employee modifyuser;//最近修改人
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date modifytime;//最近修改时间
}