package com.example.neerajinnostore.Utils;

import com.google.gson.annotations.SerializedName;

public class UserIDModel {
    @SerializedName("UserID")
    private String UserID;

    public UserIDModel(String userID) {
        UserID = userID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }
}
