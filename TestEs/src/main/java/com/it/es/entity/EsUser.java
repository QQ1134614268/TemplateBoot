package com.it.es.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.it.es.config.IndexConf;
import com.it.es.config.TimeConf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@Document(indexName = IndexConf.ES_USER_INDEX)
@AllArgsConstructor
@NoArgsConstructor
public class EsUser {
    @Id //用来将对象中id属性与文档中_id 一一对应
    private String id;

    // 用在属性上 代表mapping中一个属性 一个字段 type:属性 用来指定字段类型 analyzer:指定分词器
    @Field(type = FieldType.Text, analyzer = "Standard") //
    private String name;

    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    @JsonFormat(pattern = TimeConf.DATE_FORMAT)
    private Date birthday;

    @Field(type = FieldType.Text, analyzer = "Standard")
    private String desc;

    @Field(type = FieldType.Text, analyzer = "Standard")
    private String address;

    @Field(type = FieldType.Float)
    private Float height;
}
