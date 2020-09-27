package com.fafamc.forfun.jdk8.four_function;

import com.fafamc.forfun.jdk8.Domain;
import org.junit.Test;

import java.util.function.Consumer;

/**
 * 跟Function的唯一不同是它没有返回值。
 */
public class TestConsumer {

    @Test
    public void testConsumer(){
        Consumer<Domain> consumer = new Consumer<Domain>() {
            @Override
            public void accept(Domain domain) {
                domain.setName(domain.getName()+"rrr");
            }

        };

        Consumer<Domain> consumer2 = domain -> {
            domain.setName(domain.getName()+"fff");
        };

        consumer.andThen(consumer2).accept(Domain.getList().get(2));
        System.out.println(Domain.getList().get(2).getName());
    }
}
