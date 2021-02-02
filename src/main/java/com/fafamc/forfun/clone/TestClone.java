package com.fafamc.forfun.clone;

public class TestClone {
    public static void main(String[] args) throws Exception {
        Bottle bottle = new Bottle();
        bottle.setCode("123");
        bottle.setName("乐百氏");

        Bottle copy = (Bottle) bottle.clone();

        System.out.println("bottle: "+ bottle.toString());
        System.out.println("copy: "+ copy.toString());
        System.out.println("bottle == copy ? " + (bottle == copy));//false
        System.out.println("bottle Class == copy Class ? " + (bottle.getClass() == copy.getClass()));
        System.out.println("bottle.equals(copy) ? " + bottle.equals(copy));//true







        SonBottle son = new SonBottle();
        son.setCode("son");
        son.setName("son name");
        bottle.setSon(son);
        Bottle deepCopy = (Bottle) bottle.deepClone();
        System.out.println("----------------------------------------");
        System.out.println("son class ?" + (bottle.getSon().getClass() == copy.getSon().getClass()));
        System.out.println("son == ?" + (bottle.getSon() == copy.getSon()));
        System.out.println("son equals ?" + (bottle.getSon().equals(copy.getSon())));
        System.out.println("----------------------------------------");
        System.out.println("son class ?" + (bottle.getSon().getClass() == deepCopy.getSon().getClass()));
        System.out.println("son == ?" + (bottle.getSon() == deepCopy.getSon()));
        System.out.println("son equals ?" + (bottle.getSon().equals(deepCopy.getSon())));
    }
}
