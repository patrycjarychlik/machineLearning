package com.patrycja.filip.machinelearning.adapter.model;

public class BadgeItem {

    Integer id;
    String text;
    Integer badge;

    public BadgeItem(Integer id, String text, Integer badge) {
        this.id = id;
        this.text = text;
        this.badge = badge;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getBadge() {
        return badge;
    }

    public void setBadge(Integer badge) {
        this.badge = badge;
    }
}
