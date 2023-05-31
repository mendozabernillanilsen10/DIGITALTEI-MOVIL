package com.app.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Category implements Parcelable {
    private int id;
    private String name;
    private String image;
    private String created_at;
    private String updated_at;

    private List<Subcategory> subcategories;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

    public Category(int id, String name, String image, String created_at, String updated_at, List<Subcategory> subcategories) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.subcategories = subcategories;
    }

    protected Category(Parcel in) {
        id = in.readInt();
        name = in.readString();
        image = in.readString();
        created_at = in.readString();
        updated_at = in.readString();
        subcategories = new ArrayList<>();
        in.readTypedList(subcategories, Subcategory.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(image);
        dest.writeString(created_at);
        dest.writeString(updated_at);
        dest.writeTypedList(subcategories);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };
}