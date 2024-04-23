package com.yin.dao;

import com.yin.pojo.FrontNoteES;
import org.springframework.data.elasticsearch.annotations.Highlight;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.annotations.HighlightParameters;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FrontNoteESDao extends ElasticsearchRepository<FrontNoteES, String> {

    // 需要对查询参数进行分词处理，使用@Query注解来指定查询语句
    @Query("{\"match\": {\"context\": \"?0\"}}")
    @Highlight(fields = {
            @HighlightField(name = "context", parameters = @HighlightParameters(preTags = {"<span style='color:red'>"}, postTags = {"</span>"}, numberOfFragments = 5))
    })
    List<SearchHit<FrontNoteES>> findByContext(String keyC);

}
