package com.example.lenovo.triptogether.mailPage;

public class TestModel {
    public int position;
    public String title;
    public String ChatContext;
    public int contactImage;

    public TestModel(int contactImage,int position, String title,String ChatContext) {
        this.position = position;
        this.title = title;
        this.ChatContext = ChatContext;
        this.contactImage = contactImage;
    }
}
