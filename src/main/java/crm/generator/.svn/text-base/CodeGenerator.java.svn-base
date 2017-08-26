package crm.generator;

import crm.domain.*;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.text.MessageFormat;

//代码生成器
public class CodeGenerator {

    private static Configuration config;

    static {
        try {
            //1:创建配置对象
            config = new Configuration(Configuration.VERSION_2_3_22);
            //2:设置模板文件加载目录
            config.setDirectoryForTemplateLoading(new File("templates"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
       // generateCode();
        System.out.println("生成完毕");
    }

    private static void generateCode() throws Exception {
        ClassInfo classInfo = new ClassInfo(Sign.class);
        //2:生成service组件
        createFile(classInfo, "IService.java", "src/main/java/{0}/service/" + "I{1}Service.java");
        createFile(classInfo, "ServiceImpl.java", "src/main/java/{0}/service/impl/" + "{1}ServiceImpl.java");
        //3:生成Query和Controller组件
        createFile(classInfo, "QueryObject.java", "src/main/java/{0}/query/" + "{1}QueryObject.java");
        createFile(classInfo, "Controller.java", "src/main/java/{0}/controller/" + "{1}Controller.java");
        //4:生成list.jsp和input.jsp以及映射文件
        createFile(classInfo, "list.jsp", "src/main/webapp/WEB-INF/views/{2}.jsp");
        createFile(classInfo, "list.js", "src/main/webapp/js/views/{2}.js");
    }


    /**
     * 生成文件
     *
     * @param classInfo    封装数据的对象
     * @param templateName 对应的模板名称
     * @param path         生成文件的路径,需要把.换成/
     */
    private static void createFile(ClassInfo classInfo, String templateName, String path) throws Exception {
        Template template = config.getTemplate(templateName);
        //设置{0}和{1}的值
        String filePath = MessageFormat.format(path, classInfo.getBasePkg().replace(".", "/"), classInfo.getClassName(), classInfo.getObjectName());
        File file = new File(filePath);//生成的文件对象
        if(!file.getParentFile().exists()){//判断当前文件的父目录是否存在,如果不存在,则生成
            file.getParentFile().mkdirs();
        }
        template.process(classInfo, new FileWriter(file));
    }
}
