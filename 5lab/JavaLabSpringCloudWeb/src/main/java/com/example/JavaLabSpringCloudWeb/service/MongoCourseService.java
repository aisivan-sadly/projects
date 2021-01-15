package com.example.JavaLabSpringCloudWeb.service;

import com.example.JavaLabSpringCloudWeb.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MongoAutoRepairService implements autoRepairService {
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public List<autoRepair> getAllautoRepair() {
        return mongoTemplate.findAll(autoRepair.class);
    }

    @Override
    public List<autoRepair> getautoRepair(List<Integer> autoRepairIds) {
        List<autoRepair> autoRepair = new ArrayList<>();
        for (Integer i: autoRepairIds){
            autoRepair.add(getCautoRepair(i));
        }
        return autoRepair;
    }

    @Override
    public autoRepair getautoRepair(int id) {
        AutoRepair autoRepair = mongoTemplate.query(autoRepair.class).matching(Query.query(Criteria.where("id").is(id))).oneValue();
        return autoRepair;
    }
}
