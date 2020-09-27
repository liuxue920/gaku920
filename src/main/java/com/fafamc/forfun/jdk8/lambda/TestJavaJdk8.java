package com.fafamc.forfun.jdk8.lambda;

import org.junit.Test;

import java.math.BigDecimal;

/**
 *
 */
public class TestJavaJdk8 {

    FunctionInterface anInterface = new FunctionInterface() {
        @Override
        public BigDecimal calculation(BigDecimal x, BigDecimal y) {
            System.out.println("内部匿名类做加操作");
            return x.add(y);
        }
    };

    FunctionInterface anotherInterface = ((x, y) -> {
        System.out.println("lambda表达式做加操作");
        return x.add(y);
    });

    @Test
    public void test(){
        BigDecimal returnValue = anInterface.calculation(new BigDecimal(5),new BigDecimal(6));
        System.out.println(returnValue);


        BigDecimal va = anotherInterface.calculation(new BigDecimal(11),new BigDecimal(12));
        System.out.println(va);
    }
}
