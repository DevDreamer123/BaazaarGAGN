package com.example.neerajinnostore.Utils;

import com.google.gson.annotations.SerializedName;

public class ItemQtyRequestModel {
    @SerializedName("UserID")
    private String UserID;
    @SerializedName("ItemID")
    private String ItemID;
    @SerializedName("ServicePartnerID")
    private String ServicePartnerID;

    public ItemQtyRequestModel(String userID, String itemID, String servicePartnerID) {
        UserID = userID;
        ItemID = itemID;
        ServicePartnerID = servicePartnerID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }

    public String getServicePartnerID() {
        return ServicePartnerID;
    }

    public void setServicePartnerID(String servicePartnerID) {
        ServicePartnerID = servicePartnerID;
    }
}
