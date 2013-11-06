package com.arjun.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MessageHandler {
    private String message;

    public MessageHandler( String setme ){
        this.message=setme;
    }

    public void setMessage(String message){
        this.message  = message;
    }

    public String getMessage(){
        return message;
    }
}