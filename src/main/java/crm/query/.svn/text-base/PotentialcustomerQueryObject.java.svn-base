package crm.query;

import crm.domain.Employee;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter@Getter
public class PotentialcustomerQueryObject extends QueryObject {
    private String keyword;
    private Integer status;
    private String groupType;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date beginDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;
}
