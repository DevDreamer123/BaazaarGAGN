package com.example.neerajinnostore.Utils;

import com.google.gson.annotations.SerializedName;

public class CartListModel {
    @SerializedName("ID")
    private float ID;
    @SerializedName("UserID")
    private String UserID;
    @SerializedName("ItemID")
    private String ItemID;
    @SerializedName("Qty")
    private float Qty;
    @SerializedName("ServicePartnerID")
    private String ServicePartnerID;


    // Getter Methods

    public float getID() {
        return ID;
    }

    public String getUserID() {
        return UserID;
    }

    public String getItemID() {
        return ItemID;
    }

    public float getQty() {
        return Qty;
    }

    public String getServicePartnerID() {
        return ServicePartnerID;
    }

    // Setter Methods

    public void setID(float ID) {
        this.ID = ID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public void setItemID(String ItemID) {
        this.ItemID = ItemID;
    }

    public void setQty(float Qty) {
        this.Qty = Qty;
    }

    public void setServicePartnerID(String ServicePartnerID) {
        this.ServicePartnerID = ServicePartnerID;
    }
}
