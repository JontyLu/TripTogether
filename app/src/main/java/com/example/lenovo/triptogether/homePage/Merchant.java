package com.example.lenovo.triptogether.homePage;

/**
 * Created by dell on 2016/12/15.
 */
public class Merchant {
    private int imageId;
    private String service;
    private String price;
    private String address;
    public Merchant(int IMAGEID,String SERVICE,String PRICE,String ADDRESS)
    {
        this.imageId=IMAGEID;
        this.service=SERVICE;
        this.price = PRICE;
        this.address = ADDRESS;
    }
    public int getImageId()
    {
        return imageId;
    }
    public String getService()
    {
        return service;
    }
    public String getPrice()
    {
        return  price;
    }
    public String getAddress()
    {
        return address;
    }
}
