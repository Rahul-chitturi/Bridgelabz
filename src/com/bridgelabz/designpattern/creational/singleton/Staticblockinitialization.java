package com.bridgelabz.designpattern.creational.singleton;

public class Staticblockinitialization {
private static Staticblockinitialization instance;
     
    private Staticblockinitialization(){}
    
    //static block initialization for exception handling
    static{
        try{
            instance = new Staticblockinitialization();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    
    public static Staticblockinitialization getInstance(){
        return instance;
    }
}
