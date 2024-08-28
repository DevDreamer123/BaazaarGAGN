package com.example.neerajinnostore.Utils;

import com.google.gson.annotations.SerializedName;

public class StoreModel {
    @SerializedName("ID")
    private float ID;
    @SerializedName("StoreID")
    private String StoreID;
    @SerializedName("Title")
    private String Title;
    @SerializedName("Description")
    private String Description;
    @SerializedName("Category")
    private String Category;
    @SerializedName("Address")
    private String Address;
    @SerializedName("ServicePartnerID")
    private String ServicePartnerID;


    // Getter Methods

    public float getID() {
        return ID;
    }

    public String getStoreID() {
        return StoreID;
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

    public String getAddress() {
        return Address;
    }

    public String getServicePartnerID() {
        return ServicePartnerID;
    }

    // Setter Methods

    public void setID(float ID) {
        this.ID = ID;
    }

    public void setStoreID(String StoreID) {
        this.StoreID = StoreID;
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

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setServicePartnerID(String ServicePartnerID) {
        this.ServicePartnerID = ServicePartnerID;
    }
}
