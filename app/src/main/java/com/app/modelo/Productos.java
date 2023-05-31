package com.app.modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Productos  implements Serializable {

    @SerializedName("id")
    @Expose
    int id;
    @SerializedName("name")
    @Expose
     String name;
    @SerializedName("description")
    @Expose
     String description;
    @SerializedName("price")
    @Expose
     Double price ;
    @SerializedName("presentation")
    @Expose
     String presentation;
    @SerializedName("status")
    @Expose
     String  status;
    @SerializedName("slug")
    @Expose
     String   slug;
    @SerializedName("image")
    @Expose
     String image;
    @SerializedName("brand_name")
    @Expose
     String brand_name;
    @SerializedName("subcategory_name")
    @Expose
     String subcategory_name;
    @SerializedName("type_name")
    @Expose
     String type_name;


    public String getStatus() {
        return status;
    }

    public int getNumberOrder() {
        return numberOrder;
    }


    public void setNumberOrder(int numberOrder) {
        this.numberOrder = numberOrder;
    }

    private int numberOrder;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getSubcategory_name() {
        return subcategory_name;
    }

    public void setSubcategory_name(String subcategory_name) {
        this.subcategory_name = subcategory_name;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public Productos(int id, String name, String description, Double price, String presentation, String status, String slug, String image, String brand_name, String subcategory_name, String type_name) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.presentation = presentation;
        this.status = status;
        this.slug = slug;
        this.image = image;
        this.brand_name = brand_name;
        this.subcategory_name = subcategory_name;
        this.type_name = type_name;
    }

    public Productos() {
    }
}
