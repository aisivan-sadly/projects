package com.example.JavaLabSpringCloudWeb.service;

import com.example.JavaLabSpringCloudWeb.model.Course;
import com.example.JavaLabSpringCloudWeb.model.Store;
import com.example.JavaLabSpringCloudWeb.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class FileautoRepairService implements autoRepairService {

    @Autowired
    public Store store;

    @Autowired
    public IRepository repository;

    @Override
    public List<Course> getAllautoRepair() {
        return store.autoRepairList;
    }

    @Override
    public List<autoRepair> getautoRepair(List<Integer> autoRepairIds) {
        List<autoRepair> autoRepair = new ArrayList<>();
        for (int i : autoRepairIds) {
            autoRepair.add(getautoRepair(i));
        }
        return autoRepair;
    }

    @Override
    public Course getautoRepair(int id) {
        for (autoRepair c: store.autoRepairList){
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }





}