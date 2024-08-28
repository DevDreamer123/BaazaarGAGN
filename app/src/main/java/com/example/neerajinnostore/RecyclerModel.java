package com.example.neerajinnostore;

public class RecyclerModel {
    private String Shop_Name;
    private int Shop_Image;
    private String Shop_Type;

    // Constructor


    public RecyclerModel(String shop_Name, int shop_Image, String shop_Type) {
        Shop_Name = shop_Name;
        Shop_Image = shop_Image;
        Shop_Type = shop_Type;
    }

    // Getter and Setter

    public String getShop_Name() {
        return Shop_Name;
    }

    public void setShop_Name(String shop_Name) {
        Shop_Name = shop_Name;
    }

    public int getShop_Image() {
        return Shop_Image;
    }

    public void setShop_Image(int shop_Image) {
        Shop_Image = shop_Image;
    }

    public String getShop_Type() {
        return Shop_Type;
    }

    public void setShop_Type(String shop_Type) {
        Shop_Type = shop_Type;
    }
}
