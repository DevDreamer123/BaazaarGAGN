package com.example.neerajinnostore.Utils;

import com.google.gson.annotations.SerializedName;

public class ProductItemListModel {
    @SerializedName("ID")
    private float ID;
    @SerializedName("ItemID")
    private String ItemID;
    @SerializedName("ProductID")
    private String ProductID;
    @SerializedName("Title")
    private String Title;
    @SerializedName("Unit")
    private String Unit;
    @SerializedName("Size")
    private float Size;
    @SerializedName("MRP")
    private float MRP;
    @SerializedName("Price")
    private String Price;
    @SerializedName("OfferPrice")
    private String OfferPrice;


    // Getter Methods

    public float getID() {
        return ID;
    }

    public String getItemID() {
        return ItemID;
    }

    public String getProductID() {
        return ProductID;
    }

    public String getTitle() {
        return Title;
    }

    public String getUnit() {
        return Unit;
    }

    public float getSize() {
        return Size;
    }

    public float getMRP() {
        return MRP;
    }

    public String getPrice() {
        return Price;
    }

    public String getOfferPrice() {
        return OfferPrice;
    }

    // Setter Methods

    public void setID(float ID) {
        this.ID = ID;
    }

    public void setItemID(String ItemID) {
        this.ItemID = ItemID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public void setSize(float Size) {
        this.Size = Size;
    }

    public void setMRP(float MRP) {
        this.MRP = MRP;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public void setOfferPrice(String OfferPrice) {
        this.OfferPrice = OfferPrice;
    }
}
