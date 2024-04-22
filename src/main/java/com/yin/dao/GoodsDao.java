package com.yin.dao;

import com.yin.pojo.Goods;
import com.yin.pojo.VideoInfoES;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDao extends ElasticsearchRepository<Goods, String> {
    // Goods findByGoodsNameLike(String goodsName);
    //
    // List<Goods> findByGoodsName(String goodsName);
    // List<Goods> findById(String id);
    List<VideoInfoES> findByUserId(String goodsName);
}
