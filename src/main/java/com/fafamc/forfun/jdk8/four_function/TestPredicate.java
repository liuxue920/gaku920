package com.fafamc.forfun.jdk8.four_function;

import com.fafamc.forfun.jdk8.Domain;
import org.junit.Test;

import java.util.function.Predicate;

/**
 * 用来判断某项条件是否满足。经常用来进行筛滤操作
 */
public class TestPredicate {

    @Test
    public void testPredicate(){
        Predicate<Domain> pr = domain-> domain.getFather() == null;

        Predicate<Domain> pr2 = domain->{
            return domain.getFather() != null;
        };

        System.out.println(pr.test(Domain.getList().get(1)));
        System.out.println(pr.test(Domain.getList().get(1)));
        System.out.println(pr2.test(Domain.getList().get(2)));
    }
}
