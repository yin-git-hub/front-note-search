package com.yin.dao;

import com.yin.pojo.FrontNoteES;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FrontNoteESDao extends ElasticsearchRepository<FrontNoteES, String> {

    List<FrontNoteES> findByContext(String keyC);

}
