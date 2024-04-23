package com.yin.pojo;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.*;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;

import java.io.Serializable;


@Data
@Document(indexName = "frontnote")
public class FrontNoteES  implements Serializable {
    @Field(type = FieldType.Keyword)
    private String id;
//    @Field(type = FieldType.Text,                   //生成索引时使用 ik_max_word，在搜索时用ik_smart
//            analyzer = "ik_max_word",       //最细粒度拆分-->(字会重复被使用)(生成索引时,进行分词使用)
//            searchAnalyzer = "ik_smart")    //最粗粒度拆分-->智能拆分(字不会被重复使用)(搜索时,对搜索词进行分词)
@Field(type = FieldType.Text  , searchAnalyzer = "ik_smart", analyzer = "ik_max_word")             //生成索引时使用 ik_max_word，在搜索时用ik_smart
    private String context;
    @Field(type = FieldType.Keyword)
    private String location;


}
