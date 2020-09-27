package com.fafamc.forfun.jdk8.four_function;

import com.fafamc.forfun.jdk8.Domain;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class TestSupplier {

    @Test
    public void testSupplier(){
        List<String> arList = Lists.newArrayList();
        Supplier<Domain> supplier = () -> {
            System.out.println("创建对象之前123");
            arList.add("ccccc");
            return new Domain();
        };
        System.out.println("11111");
        Domain domain = supplier.get();
        System.out.println("333333");

        System.out.println(Arrays.toString(arList.toArray()));
    }
}
