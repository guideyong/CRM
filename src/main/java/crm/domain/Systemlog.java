package crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.Date;
@Setter@Getter
@Alias("Systemlog")
public class Systemlog extends BaseDomain{
    private Employee opuser;//操作用户
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date optime;//操作时间
    private String opip;//登录IP
    private String function;//使用功能
    private String params;//操作参数信息
}