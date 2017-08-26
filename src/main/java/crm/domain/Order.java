package crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Setter@Getter
public class Order extends BaseDomain{
    private Potentialcustomer customer;//定金客户
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date signtime;//签订时间
    private Employee seller;//营销人员
    private Long totalsum;//总金额
    private Long sum;//定金金额
    private String intro;//摘要
    private String file;//附件
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createtime;//创建时间
    private Employee modifyuser;//最近修改人
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date modifytime;//最近修改时间
    private Integer status;//订单状态0:初始录入1:已生成合同2:已退款
}