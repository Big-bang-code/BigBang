package com.bang.sys.dao.fast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FastDao {

    //mongo直接使用mongoTemplate来访问
    @Autowired
    private MongoTemplate mongoTemplate;



}
