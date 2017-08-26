package crm.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by acer1 on 2017/6/14.
 */
@Setter@Getter
public class EmployeeQueryObject extends QueryObject {
    private Boolean state;
    private String keyword;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date beginDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;
}
