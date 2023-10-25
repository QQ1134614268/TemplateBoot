package com.it.oa.util;

import com.baomidou.mybatisplus.annotation.TableName;
import org.hibernate.annotations.Table;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Entity;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;


public class GetClassUtil {
    public static List<Class> getClassByPackage(String packageName) throws ClassNotFoundException, IOException {
        List<Class> classList = new ArrayList<>();
        Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(packageName.replace(".", "/"));
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            String[] file = new File(url.getFile()).list();
            Assert.notNull(file, "not null");
            for (String s : file) {
                classList.add(Class.forName(packageName + "." + s.replaceAll("\\.class", "")));
            }
        }
        return classList;
    }

    public static String getTableName(Class clazz) {
        Annotation[] tableNameAnno = clazz.getDeclaredAnnotationsByType(TableName.class);
        if (tableNameAnno.length > 0) {
            TableName tableName = (TableName) tableNameAnno[0];
            return tableName.value();
        }
        Annotation[] tableAnno = clazz.getDeclaredAnnotationsByType(Table.class);
        if (tableAnno.length > 0) {
            Table tableName = (Table) tableAnno[0];
            return tableName.appliesTo();
        }
        Annotation[] entityAnno = clazz.getDeclaredAnnotationsByType(Entity.class);
        if (entityAnno.length > 0) {
            Entity entity = (Entity) entityAnno[0];
            return entity.name();
        }
        return null;
    }

    public static List<String> getTableName(List<Class> list) {
        return list.stream().map(GetClassUtil::getTableName).collect(Collectors.toList());
    }

    public static String getControllerUrl(Class clazz) {
        Annotation[] annoArr = clazz.getDeclaredAnnotationsByType(RequestMapping.class);
        if (annoArr.length > 0) {
            RequestMapping tableName = (RequestMapping) annoArr[0];
            return tableName.value()[0];
        }
        return "";
    }
}
