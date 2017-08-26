package crm.query;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by acer1 on 2017/6/14.
 */
@Getter@Setter
public class QueryObject {
    private Integer page;
    private Integer rows;//每页显示几条
    public Integer getStart(){
        if (page!=null){
            return (this.page-1)*this.rows;
        }else {
            return null;
        }
    }
}
