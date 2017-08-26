package crm.generator;


import crm.domain.BaseDomain;
import lombok.Getter;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

/**
 * 表示数据模型对象,封装了模板中占位符的数据
 */
@Getter
public class ClassInfo {
    private String basePkg;//基础包报名
    private String className;//domain类的简单类名
    private String objectName;//domain类对象名称,首字母小写
    private List<String> props = new ArrayList<>();//当前对象中所有的属性名称

    public ClassInfo(Class<?> clazz) throws Exception {
        //截取包名
        basePkg =clazz.getPackage().getName().substring(0, clazz.getPackage().getName().lastIndexOf("."));
        className = clazz.getSimpleName();
        objectName = className.substring(0, 1).toLowerCase() + className.substring(1);
        //内省
        BeanInfo beanInfo  = Introspector.getBeanInfo(clazz, BaseDomain.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            props.add(pd.getName());
        }
    }
}
