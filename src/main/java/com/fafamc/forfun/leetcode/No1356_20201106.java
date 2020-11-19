package com.fafamc.forfun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class No1356_20201106 {
    public int[] sortByBits(int[] arr) {
        int [] returnArray = new int[arr.length];
        List<Number> list = new ArrayList<>();
        for(int a : arr){
            list.add(new Number(a));
        }
        List<Number> result =
            list.stream().sorted((o1, o2) -> {
                if(o1.count_one == o2.count_one){
                    return o1.self - o2.self;
                }else{
                    return o1.count_one - o2.count_one;
                }
            }).collect(Collectors.toList());
        for(int i = 0  ; i < result.size();i++){
            returnArray[i] = result.get(i).self;
        }
        return returnArray;
    }

    class Number{
        int self;
        String self_two;
        int count_one;

        public Number(int self){
            this.self = self;
            this.self_two = Integer.toBinaryString(self);
            //Integer.toBinaryString(n) 十进制转二进制
            //Integer.toHexString(18);  十进制转十六进制
            this.count_one = (int) Stream.of(self_two.split("")).filter(a -> "1".equalsIgnoreCase(a)).count();

        }
    }

    public static void main(String[] args) {
        No1356_20201106 test = new No1356_20201106();
        int arr[]={2,3,5,7,11,13,17,19};
        System.out.println(Arrays.toString(test.sortByBits(arr)));
    }
}
