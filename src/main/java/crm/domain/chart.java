package crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by acer1 on 2017/7/12.
 */
@Setter@Getter
public class chart {
    @JsonFormat(pattern="yyyy-MM",timezone="GMT+8")
    private Date groupType;
    private Long number;
}
