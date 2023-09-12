package com.example.OnlineOrder.rest.castomExeption;

public class NotFIndExeption extends  RuntimeException{


    public  NotFIndExeption (String typeElement, String id) {
    super("is not find "+typeElement+"whit id:"+id);
}
}
