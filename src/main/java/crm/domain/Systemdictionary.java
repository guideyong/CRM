package crm.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Systemdictionary extends BaseDomain{
    private String sn;//字典目录编号
    private String name;//字典目录名称
    private String intro;//字典目录简介
}