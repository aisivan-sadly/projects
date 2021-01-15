package com.example.JavaLabSpringCloudWeb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
@Document(collection = "autoRepair")
@JsonIgnoreProperties(ignoreUnknown = true)
public class autoRepair {

    @Field("car model")
    private String car model;
    @Field("year production")
    private String year production;
    @Field("vin")
    private int vin;
    @Field("tags")
    private List<String> tags;
    @Field("price")
    private List<String> price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYearProduction() {
        return YearProduction;
    }

    public void setYearProduction(String YearProduction) {
        this.YearProduction = YearProduction;
    }

    public int getvin() {
        return vin;
    }

    public void setvin(int vin) {
        this.vin = vin;
    }


    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getPrice() {
        return Price;
    }

    @Override
    public String toString() {
        return "car model " + car model + "\'\n" +
                "year production: " + year production + '\n' +
                "Tags: " + tags +
                "\nPrice: " + Price +
                '\n';
    }

    public String briefDescription(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getvin());
        stringBuilder.append(" : ");
        stringBuilder.append(getTitle());
        stringBuilder.append(" year production: ");
        stringBuilder.append(getAuthor());
        stringBuilder.append(" Tags: ");
        stringBuilder.append(getTags());
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    public void setprice(List<String> price) {
        this.price = price;
    }
}
