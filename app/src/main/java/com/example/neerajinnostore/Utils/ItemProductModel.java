package com.example.neerajinnostore.Utils;

public class ItemProductModel {
    String Title;
    String Description;
    String Gram;
    String Rupee;
    int Image;

    public ItemProductModel(String title, String description, String gram, String rupee, int image) {
        Title = title;
        Description = description;
        Gram = gram;
        Rupee = rupee;
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getGram() {
        return Gram;
    }

    public void setGram(String gram) {
        Gram = gram;
    }

    public String getRupee() {
        return Rupee;
    }

    public void setRupee(String rupee) {
        Rupee = rupee;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
