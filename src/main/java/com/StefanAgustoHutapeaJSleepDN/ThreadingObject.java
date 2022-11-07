package com.StefanAgustoHutapeaJSleepDN;


public class ThreadingObject extends Thread {
    private final String name;

    public ThreadingObject(String name){
        this.name = name;
    }

    public void run(){
        System.out.println(name + " is running");
        System.out.println("Id Thread: " + Thread.currentThread().getId());
    }
}
