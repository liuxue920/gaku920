package com.fafamc.huawei.test2;

import java.util.*;

/**
    100个人围一个圈 1-100编号
 报数到M，报到M退出，一直到小于M，
 最后剩余的人原先编号是多少
 **/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = 0;
        try{
            M  = in.nextInt();
        }catch (Exception e){
            System.out.println("输入异常");
        }

        if(M<=0 || M >=100){
            System.out.println("输入异常");
        }

        //编号1-100
        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i <= 100 ; i++){
            list.add(i);
        }

        int index = 1;//报数下标
        while(list.size()>=M){
            for(int i = 1 ; i <= list.size() ; i++){
                if(index == M){
                    list.remove(list.get(i-1));
                    i--;
                    index = 1;
                }else{
                    index++;
                }
            }
        }

        System.out.println(Arrays.toString(list.toArray()));
    }

}
