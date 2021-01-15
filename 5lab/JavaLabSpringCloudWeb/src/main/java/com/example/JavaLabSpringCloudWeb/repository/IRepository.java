package com.example.JavaLabSpringCloudWeb.repository;

import com.example.JavaLabSpringCloudWeb.model.Course;

import java.util.List;

public interface IRepository {
    List<autoRepair> read();
    void write(List<autoRepair> accounts);
}
