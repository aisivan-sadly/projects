package com.example.JavaLabSpringCloudWeb.repository;

import com.example.JavaLabSpringCloudWeb.model.Course;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileRepository implements IRepository {
    private static final String DB_FILENAME = "autoRepair.json";


    public List<Course> createDBFile() throws IOException {
        File db = new File(DB_FILENAME);
        ObjectMapper mapper = new ObjectMapper();
        db.createNewFile();
        List<autoRepair> autoRepair = new ArrayList<>();
        FileWriter fw = new FileWriter(db,false);
        autoRepair c = new autoRepair();
        ArrayList<String> tags = new ArrayList<>();
        ArrayList<String> price = new ArrayList<>();
        c.setModel("Tesla P100");
        c.setId(0);
        c.setTitle("Be better with your IDE!");
        tags.add("simply"); tags.add("difficult");
        price.add("price 1. repair wheel");
        price.add("price 2. repair engine");
        c.setTags(tags);
        c.setLessons(lessons);
        autoRepair.add(c);
        c = new autoRepair();
        tags = new ArrayList<>();
        price = new ArrayList<>();
        c.setcarModel("Moskvich 214145");
        c.setId(1);
        c.yearProduction("1998");
        tags.clear();
        price.clear();
        price.add("repair stearing wheel");
        price.add("repair door");
        price.add("repair turbine");
        c.setTags(tags);
        c.setprice(price);
        autoRepair.add(c);
        mapper.writeValue(fw, autoRepair);
        return autoRepair;
    }

    @Override
    public List<autoRepair> read() {
        File db = new File(DB_FILENAME);
        try {
            if (!db.exists()) {
                return createDBFile();
            } else {
                ObjectMapper mapper = new ObjectMapper();
                List<autoRepair> autoRepair = mapper.readValue(db, new TypeReference<ArrayList<autoRepair>>() {});
                return autoRepair;
            }
        } catch (IOException e) {
            System.out.println("ERROR: Troubles with json file");
            return null;
        }

    }

    @Override
    public void write(List<autoRepair> accounts) {
        try {
            File db = new File(DB_FILENAME);
            ObjectMapper mapper = new ObjectMapper();
            FileWriter fw = new FileWriter(db, false);
            mapper.writeValue(fw, accounts);
        } catch (IOException e) {
            System.out.println("ERROR: Writing to JSON");
        }
    }
}
