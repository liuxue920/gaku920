package com.fafamc.forfun.stringtest;

public class Father {

    public static String NAME="father";

    static {
        System.out.println("Father static");
    }

    public Father(){
        System.out.println("Father 11111111111");
    }

    public static void main(String[] args) {
        System.out.println(NAME);
        Father f = new Son();
    }
}
