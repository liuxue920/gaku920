package com.fafamc.forfun.finalDemo;

import com.fafamc.forfun.Sex;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author gaku9
 * @Create 2020/7/29
 **/
public class FinalDemo {
    public static final List<Integer> arrayList = new ArrayList<>();
    public static final String TEST ;
    public static final StringBuilder sb = new StringBuilder("!23");
    public static final BigDecimal big = BigDecimal.ZERO;
    static {
        arrayList.add(1);
        arrayList.add(2);
        TEST = new String("234");
    }
    public static void main(String[] args) {
//        FinalDemo.arrayList.add(3);
//        FinalDemo.arrayList.remove(1);
//        System.out.println(Arrays.toString(arrayList.toArray()));
//
//        sb.append("456");
//        System.out.println(sb.toString());
//
//        big.add(new BigDecimal(5));
//        System.out.println(big);


        Sex ss[] = Sex.values();
        for(Sex s:ss){
//            System.out.println(s.getCode()+"  " +s.getMsg());
            System.out.println(s.name());
            System.out.println(s.toString());
        }
    }
}
