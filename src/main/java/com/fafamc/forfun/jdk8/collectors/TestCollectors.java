package com.fafamc.forfun.jdk8.collectors;

import com.fafamc.forfun.jdk8.Domain;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestCollectors {

    @Test
    public void test1_forPreJdk8(){
        List<Domain> tasks = Domain.getList();
        Map<Integer, List<Domain>> map = new HashMap<>();
        for(Domain domain : tasks){
            if(map.containsKey(domain.getType())){
                map.get(domain.getType()).add(domain);
            }else{
                map.put(domain.getType(), Lists.list(domain));
            }
        }
        System.out.println(map);
    }

    @Test
    public void test1_forJdk8(){
        List<Domain> tasks = Domain.getList();
        Map<Integer, List<Domain>> map = tasks.stream().collect(Collectors.groupingBy(Domain::getType));
        System.out.println(map);
    }
    @Test
    public void test2_forJdk8(){
        List<Domain> tasks = Domain.getList();
        Map<Integer, Domain> map = tasks.stream().collect(Collectors.toMap(Domain::getType, Function.identity(),(s, s2) -> s.getId().compareTo(s2.getId()) >= 0 ? s : s2));
        System.out.println(map);
    }

}
