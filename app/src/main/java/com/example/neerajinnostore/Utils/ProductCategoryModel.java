package com.example.neerajinnostore.Utils;

import com.google.gson.annotations.SerializedName;

public class ProductCategoryModel {
    @SerializedName("ID")
    private float ID;
    @SerializedName("Title")
    private String Title;
    @SerializedName("Description")
    private String Description ;
    @SerializedName("ParentID")
    private String ParentID ;


    // Getter Methods

    public float getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getParentID() {
        return ParentID;
    }

    // Setter Methods

    public void setID(float ID) {
        this.ID = ID;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setParentID(String ParentID) {
        this.ParentID = ParentID;
    }
}
