package com.shravan.learn;

public class Tuple {
    int id;
    String value;

    public Tuple(int id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
