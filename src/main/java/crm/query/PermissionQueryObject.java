package crm.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 * Created by acer1 on 2017/6/17.
 */
@Setter@Getter
public class PermissionQueryObject extends QueryObject {
    private String keyword;
}
