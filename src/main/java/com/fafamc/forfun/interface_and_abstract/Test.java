package com.fafamc.forfun.interface_and_abstract;

import com.alibaba.fastjson.JSON;
import org.assertj.core.util.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
//        Employee emp = new FaEmployee();
//        emp.computePay();
//
//        Do d = new Do() {
//            @Override
//            public void play() {
//
//            }
//        };
//        d.play();
        Employee emp1 = new FaEmployee();
        emp1.setName("lx");
        emp1.setNumber(12);
        Employee emp2 = new FaEmployee();
        emp2.setName("lx");
        emp2.setNumber(13);

        System.out.println(emp1.equals(emp2));


        List<Employee> list = Lists.newArrayList(emp1,emp2);
        System.out.println(list.size());

        Map<Employee,String> map = new HashMap<>();
        map.put(emp1,"1");
        map.put(emp2,"2");
        System.out.println(JSON.toJSON(map));
    }
}
