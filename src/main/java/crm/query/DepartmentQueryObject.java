package crm.query;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by acer1 on 2017/6/18.
 */
@Setter@Getter
public class DepartmentQueryObject extends QueryObject{
    private String keyword;
    private Boolean state;
}
