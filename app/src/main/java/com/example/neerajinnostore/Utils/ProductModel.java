package com.example.neerajinnostore.Utils;

import com.google.gson.annotations.SerializedName;

public class ProductModel {
    @SerializedName("ID")
    private float ID;
    @SerializedName("ProductID")
    private String ProductID;
    @SerializedName("Title")
    private String Title;
    @SerializedName("Description")
    private String Description;
    @SerializedName("Category")
    private String Category;


    // Getter Methods

    public float getID() {
        return ID;
    }

    public String getProductID() {
        return ProductID;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getCategory() {
        return Category;
    }

    // Setter Methods

    public void setID(float ID) {
        this.ID = ID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }
}
