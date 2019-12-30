package com.java.springboot.sms.entity;

import java.util.List;

public class Value {
    private Integer id;
    private String joke;
    private List<String> categories;

    public Value() {}

    public Value(Integer id, String joke, List<String> categories) {
        this.id = id;
        this.joke = joke;
        this.categories = categories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Value{" +
                "id=" + id +
                ", name='" + joke + '\'' +
                ", categories=" + categories +
                '}';
    }
}
