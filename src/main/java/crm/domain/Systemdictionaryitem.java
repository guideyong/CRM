package crm.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Systemdictionaryitem extends BaseDomain{
    private Long id;
    private Systemdictionary parent;//字典目录
    private String name;//字典明细名称
    private String intro;//字典明细简介
}