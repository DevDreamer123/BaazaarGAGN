package com.example.neerajinnostore.Utils;

import com.google.gson.annotations.SerializedName;

public class ProductIDModel {
    @SerializedName("ProductID")
    private String ProductID;

    public ProductIDModel(String productID) {
        ProductID = productID;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }
}
