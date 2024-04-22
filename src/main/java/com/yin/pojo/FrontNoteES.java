package com.yin.pojo;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Data
@Document(indexName = "frontnote")
public class FrontNoteES  implements Serializable {
    @Field(type = FieldType.Keyword)
    private String id;
    @Field(type = FieldType.Text)
    private String context;
    @Field(type = FieldType.Text)
    private String location;
}
