package com.it.boot.config.gen;

import com.google.gson.Gson;
import com.it.boot.TemplateBootApplication;
import com.it.boot.entity.UserEntity;
import com.it.boot.util.BuildDataUtil;
import com.it.boot.util.DateUtil;
import com.it.boot.util.GetClassUtil;
import com.it.boot.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * 自定义模板 代码生成器
 */
@Slf4j
@SpringBootTest
public class GenCodeTest {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    void toCode() throws IOException {
        String SRC_MAIN_JAVA = "/src/main/java/";
        String SRC_TEST_JAVA = "/src/test/java/";
        String base = TemplateBootApplication.class.getPackage().getName();
        AutoCode.Arg entity = new AutoCode.Arg(base+".entity.%sEntity", "templates/entity.java.vm", "huangran", SRC_MAIN_JAVA);
        AutoCode.Arg mapper = new AutoCode.Arg(base+".mapper.%sMapper", "templates/mapper.java.vm", "huangran", SRC_MAIN_JAVA);
        AutoCode.Arg service = new AutoCode.Arg(base+".service.%sService", "templates/serviceImpl.java.vm", "huangran", SRC_MAIN_JAVA);
        AutoCode.Arg controller = new AutoCode.Arg(base+".controller.%sController", "templates/controller.java.vm", "huangran", SRC_MAIN_JAVA);
        AutoCode.Arg test = new AutoCode.Arg(base+".controller.%sControllerTest", "templates/test.java.vm", "huangran", SRC_TEST_JAVA);

        // Class[] tables = GetClassUtil.getClassByPackage(BaseEntity.class.getPackage().getName()).stream().toArray(Class[]::new);
        Class<?>[] tables = {UserEntity.class};//UserEntity.class
        AutoCode.Arg[] args = {mapper, service, controller};
        for (Class<?> clazz : tables) {
            for (AutoCode.Arg arg : args) {
                String tableName = GetClassUtil.getTableName(clazz);
                if (tableName != null) AutoCode.toFile(jdbcTemplate, tableName, arg);
            }
        }
    }

    public static class AutoCode {

        public static void toFile(JdbcTemplate jdbcTemplate, String tableName, Arg arg) throws IOException {
            TableInfo a = AutoCode.getTableInfo(jdbcTemplate, tableName, arg.fmt, arg.author);
            //
            Gson gson = new Gson();
            String json = gson.toJson(a);
            Map<String, Object> map = gson.fromJson(json, Map.class);
            VelocityContext context = new VelocityContext(map);

            Properties p = new Properties();
            p.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
            Velocity.init(p);

            Template template = Velocity.getTemplate(arg.tpl);

            String systemPath = System.getProperty("user.dir");
            String outPath = systemPath + arg.path + a.classFullName.replace(".", "/") + ".java";
            try (FileWriter fileWriter = new FileWriter(outPath)) {
                template.merge(context, fileWriter);
            }
        }

        public static TableInfo getTableInfo(JdbcTemplate jdbcTemplate, String tableName, String fmt, String author) {
            // 获取表信息sql
            String tableSql = "select table_comment as tableComment from information_schema.tables where table_schema = (select database()) and table_name = ?";
            Object[] args = {tableName};
            TableInfo tableInfo = jdbcTemplate.queryForObject(tableSql, args, new BeanPropertyRowMapper<>(TableInfo.class));
            Assertions.assertNotNull(tableInfo);
            tableInfo.tableName = tableName;
            tableInfo.tableLowerCamel = StringUtil.toCamelCase(tableName);
            tableInfo.tableUpperCamel = StringUtil.upperFirst(tableInfo.tableLowerCamel);

            tableInfo.classFullName = String.format(fmt, tableInfo.tableUpperCamel);
            String tmp = tableInfo.classFullName.substring(0, tableInfo.classFullName.lastIndexOf("."));
            tableInfo.packageName = tmp.substring(0, tmp.lastIndexOf("."));
            tableInfo.fmt = fmt;
            tableInfo.author = author;

            tableInfo.tableFields = getCols(jdbcTemplate, tableName);
            return tableInfo;
        }

        public static List<TableField> getCols(JdbcTemplate jdbcTemplate, String tableName) {
            String columnSql = "select column_name, data_type, column_comment, column_type, column_key, is_nullable from information_schema.columns where table_schema = (select database()) and table_name = ?";
            Object[] arg = {tableName};
            List<TableField> fields = jdbcTemplate.query(columnSql, arg, new BeanPropertyRowMapper<>(TableField.class));
            for (TableField field : fields) {
                field.table_name = tableName;

                field.javaType = TypeConvert.columnTypeToJavaType(field.data_type);
                field.javaColumnComment = field.column_comment;
                field.javaColumnName = StringUtil.toCamelCase(field.column_name);
                field.javaColumnExample = String.valueOf(BuildDataUtil.getValue(TypeConvert.toJavaType(field.data_type)));
                field.unique = "UNI".equals(field.column_key);
                field.nullable = "YES".equals(field.is_nullable);
                field.required = "NO".equals(field.is_nullable);
            }

            return fields;
        }


        @Data
        static class TableField {
            String column_type;
            String table_name;
            String column_name;
            String data_type;
            String column_comment;
            String column_key;
            String is_nullable;

            String javaType;
            String javaColumnName;
            String javaColumnComment;
            String javaColumnExample;
            Boolean unique;
            Boolean nullable;
            Boolean required;
            // String javaColumnDefault;

        }

        @Data
        @AllArgsConstructor
        static class Arg {
            String fmt;
            String tpl;
            String author;
            String path;
        }

        @Data
        static class TableInfo {
            String tableName;
            String tableComment;

            String classFullName;
            String packageName;

            String tableLowerCamel;
            String tableUpperCamel;
            String author;
            String datetime = DateUtil.getCurrentDateTimeStr();
            String fmt;

            List<TableField> tableFields;

        }

        static class TypeConvert {
            /**
             * 数据库字符串类型
             */
            public static final String[] COLUMN_TYPE_STR = {"char", "varchar", "nvarchar", "varchar2"};
            /**
             * 数据库文本类型
             */
            public static final String[] COLUMN_TYPE_TEXT = {"tinytext", "text", "mediumtext", "longtext"};
            /**
             * 数据库时间类型
             */
            public static final String[] COLUMN_TYPE_TIME = {"datetime", "time", "date", "timestamp"};
            /**
             * 数据库数字类型
             */
            public static final String[] COLUMN_TYPE_NUMBER = {"tinyint", "smallint", "mediumint", "int", "number", "integer", "bit"};
            /**
             * 数据库bigint类型
             */
            public static final String[] COLUMN_TYPE_BIGINT = {"bigint"};
            /**
             * 数据库float类型
             */
            public static final String[] COLUMN_TYPE_FLOAT = {"float"};
            /**
             * 数据库double类型
             */
            public static final String[] COLUMN_TYPE_DOUBLE = {"double"};
            /**
             * 数据库decimal类型
             */
            public static final String[] COLUMN_TYPE_DECIMAL = {"decimal"};

            public static String columnTypeToJavaType(String columnType) {
                Class<?> clz = toJavaType(columnType);
                return clz.getSimpleName();
            }

            public static Class<?> toJavaType(String columnType) {
                Assert.notNull(columnType, "not null");
                if (Arrays.asList(COLUMN_TYPE_STR).contains(columnType)) {
                    return String.class;
                }
                if (Arrays.asList(COLUMN_TYPE_TEXT).contains(columnType)) {
                    return String.class;
                }
                if (Arrays.asList(COLUMN_TYPE_TIME).contains(columnType)) {
                    return Date.class;
                }
                if (Arrays.asList(COLUMN_TYPE_NUMBER).contains(columnType)) {
                    return Integer.class;
                }
                if (Arrays.asList(COLUMN_TYPE_BIGINT).contains(columnType)) {
                    return Long.class;
                }
                if (Arrays.asList(COLUMN_TYPE_FLOAT).contains(columnType)) {
                    return Float.class;
                }
                if (Arrays.asList(COLUMN_TYPE_DOUBLE).contains(columnType)) {
                    return Double.class;
                }
                if (Arrays.asList(COLUMN_TYPE_DECIMAL).contains(columnType)) {
                    return BigDecimal.class;
                }
                throw new IllegalArgumentException(columnType);
            }

        }
    }
}

