package com.example.agileblaze.foodorderclint;

/**
 * Created by agileblaze on 3/11/17.
 */

public class Food {

    private  String name,price,image,desc;
    public  Food()
    {

    }
    public  Food(String name,String price,String image,String desc)
    {
        this.name=name;
        this.price=price;
        this.image=image;
        this.desc=desc;
    }

    public  String getPrice()
    {
        return  price;
    }
    public  String getName()
    {
        return  name;
    }
    public  String getDesc()
    {
        return  desc;
    }
    public  String getImage()
    {
        return image;
    }

    public void setPrice(String price)
    {
        this.price=price;
    }
    public  void  setName(String name)
    {
        this.name=name;
    }
    public  void  setDesc(String desc)
    {
        this.desc=desc;
    }
    public  void  setImage(String image)
    {
        this.image=image;
    }
}
