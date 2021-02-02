package com.fafamc.forfun.clone;

import java.io.*;

//@Data 这个注解会重新equels方法
public class Bottle implements Cloneable, Serializable {

    private String name;
    private String code;
    private SonBottle son;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    private static int i = 1;

    public Bottle() {
        System.out.println("i = " + i);
        System.out.println("执行了构造函数"+i);
        i++;
    }


    public Object deepClone() throws Exception{

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bo);
        out.writeObject(this);

        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return oi.readObject();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SonBottle getSon() {
        return son;
    }

    public void setSon(SonBottle son) {
        this.son = son;
    }
}

