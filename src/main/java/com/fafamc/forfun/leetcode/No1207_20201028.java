package com.fafamc.forfun.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class No1207_20201028 {
    public boolean uniqueOccurrences(int[] arr) {
        //数组转换 数字，个数map
        Map<String,Long> map = Arrays.stream(arr).mapToObj(i -> String.valueOf(i)).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        //判断条件，map的values去重后个数和map的values个数比较
        Predicate<Map<String,Long>> pr2 = m->{
            return m.values().stream().distinct().collect(Collectors.toList()).size()
                      ==
                   m.values().size();
        };
        return pr2.test(map);
    }

    public static void main(String[] args) {
        No1207_20201028 solution = new No1207_20201028();
        int arr[] = {1,2,2,1,1,3};
        //int arr2[] = {1,2};
        //int arr3[] ={-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(solution.uniqueOccurrences(arr));
    }
}
