package com.boyang.myflix.bean;

import org.springframework.data.mongodb.core.index.Indexed;

public class Category {
    private String id;
    @Indexed
    private String name;

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
}
