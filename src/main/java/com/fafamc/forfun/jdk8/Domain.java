package com.fafamc.forfun.jdk8;

import lombok.Data;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;


@Data
public class Domain {

    private String id;
    private String name;
    private Domain father;
    private int type=0;
    private List<Domain> sonList= new ArrayList<>();

    public Domain(){
//        System.out.println("domain 构造函数");
    }

    public static List<Domain> getList(){
        Domain t1 = new Domain();
        t1.setId("1");
        t1.setName("t1");
        t1.setType(0);

        Domain t2 = new Domain();
        t2.setId("2");
        t2.setName("t2");
        t2.setFather(t1);
        t2.setType(1);

        Domain t3 = new Domain();
        t3.setId("3");
        t3.setName("t3");
        t3.setFather(t2);
        t3.setType(1);

        return Lists.list(t1,t2,t3);
    }
}
