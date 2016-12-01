package com.example.shubham_v.recyclecardview;

/**
 * Created by shubham_v on 01-12-2016.
 */

public class FruitDetailHolder {


    private int image_Id;
    private  String fruit_Name,fruit_Small_Description;


    public FruitDetailHolder()
    {

    }
    public FruitDetailHolder(int image_Id, String fruit_Name, String fruit_Small_Description) {
        this.image_Id = image_Id;
        this.fruit_Name = fruit_Name;
        this.fruit_Small_Description = fruit_Small_Description;
    }
    public int getImage_Id() {
        return image_Id;
    }

    public void setImage_Id(int image_Id) {
        this.image_Id = image_Id;
    }

    public String getFruit_Name() {
        return fruit_Name;
    }

    public void setFruit_Name(String fruit_Name) {
        this.fruit_Name = fruit_Name;
    }

    public String getFruit_Small_Description() {
        return fruit_Small_Description;
    }

    public void setFruit_Small_Description(String fruit_Small_Description) {
        this.fruit_Small_Description = fruit_Small_Description;
    }

}
