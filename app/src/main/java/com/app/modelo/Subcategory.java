package com.app.modelo;

import android.os.Parcel;
import android.os.Parcelable;

public class Subcategory implements Parcelable {
    private int id;
    private String name;
    private int category_id;
    private String created_at;
    private String updated_at;

    protected Subcategory(Parcel in) {
        id = in.readInt();
        name = in.readString();
        category_id = in.readInt();
        created_at = in.readString();
        updated_at = in.readString();
    }

    public static final Creator<Subcategory> CREATOR = new Creator<Subcategory>() {
        @Override
        public Subcategory createFromParcel(Parcel in) {
            return new Subcategory(in);
        }

        @Override
        public Subcategory[] newArray(int size) {
            return new Subcategory[size];
        }
    };

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

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(category_id);
        dest.writeString(created_at);
        dest.writeString(updated_at);
    }
}
