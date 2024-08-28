package com.example.neerajinnostore;

import com.google.gson.annotations.SerializedName;

public class IncreaseDecreaseModel {
    @SerializedName("ID")
    private float ID;
    @SerializedName("Staus")
    private String Staus;
    @SerializedName("Message")
    private String Message;


    // Getter Methods

    public float getID() {
        return ID;
    }

    public String getStaus() {
        return Staus;
    }

    public String getMessage() {
        return Message;
    }

    // Setter Methods

    public void setID(float ID) {
        this.ID = ID;
    }

    public void setStaus(String Staus) {
        this.Staus = Staus;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }
}
