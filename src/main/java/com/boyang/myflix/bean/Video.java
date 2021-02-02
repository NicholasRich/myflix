package com.boyang.myflix.bean;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Video {
    @Id
    private String id;
    private String name;
    private String fileName;
    private Binary thumb;
    private List<String> category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Binary getThumb() {
        return thumb;
    }

    public void setThumb(Binary thumb) {
        this.thumb = thumb;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }
}
