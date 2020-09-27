package com.fafamc.forfun.jdk8.optional;

import com.fafamc.forfun.jdk8.Domain;

import java.util.Optional;

/**
 * Optional 工具类的学习
 * 任重而道远啊
 */
public class OptionalLesson {

    public static void main(String[] args) {


//        String rootName =
//                Optional.ofNullable(t3.getFather())
////                        .map(OptionalDomain::getFather)
//                        .map(OptionalDomain::getName)
//                        .orElse("NULL");
        Domain test = Optional.ofNullable(Domain.getList().get(2)).flatMap( t-> Optional.of(t.getFather())).orElse(Domain.getList().get(0));
        String rootName = test.getName();
        System.out.println(rootName);

    }
}
