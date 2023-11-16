package com.it.es.dao;

import com.it.es.entity.EsUser;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EsUserRepository extends ElasticsearchRepository<EsUser, String> {
    List<EsUser> findByName(String name);
}