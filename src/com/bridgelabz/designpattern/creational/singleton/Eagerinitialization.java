package com.bridgelabz.designpattern.creational.singleton;

public class Eagerinitialization {
    
    private static final Eagerinitialization instance = new Eagerinitialization();
    
    //private constructor to avoid client applications to use constructor
    private Eagerinitialization(){}

    public static Eagerinitialization getInstance(){
        return instance;
}
}