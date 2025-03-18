package com.learning.ex_productservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private int prd_id;
    private String prd_name;
    private String prd_desc;
    private int prd_price;
    private int prd_count;

    public Product() {

    }

    public Product(int prd_id, String prd_name, String prd_desc, int prd_price, int prd_count) {
        this.prd_id = prd_id;
        this.prd_name = prd_name;
        this.prd_desc = prd_desc;
        this.prd_price = prd_price;
        this.prd_count = prd_count;
    }

    public int getPrd_id() {
        return prd_id;
    }

    public void setPrd_id(int prd_id) {
        this.prd_id = prd_id;
    }

    public String getPrd_name() {
        return prd_name;
    }

    public void setPrd_name(String prd_name) {
        this.prd_name = prd_name;
    }

    public String getPrd_desc() {
        return prd_desc;
    }

    public void setPrd_desc(String prd_desc) {
        this.prd_desc = prd_desc;
    }

    public int getPrd_price() {
        return prd_price;
    }

    public void setPrd_price(int prd_price) {
        this.prd_price = prd_price;
    }

    public int getPrd_count() {
        return prd_count;
    }

    public void setPrd_count(int prd_count) {
        this.prd_count = prd_count;
    }
}
