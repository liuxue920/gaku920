package com.fafamc.forfun.leetcode;


public class Test2 {
    public int count(int num){
        if(num == 1){
            return 1;
        }
        if(num == 2){
            return 1;
        }
        if(num == 3){
            return 2;
        }
        if(num >3){
            return count(num-3) + count(num-1);
        }
        return 0;
    }

    public static void main(String[] args) {
        Test2 t = new Test2();
        System.out.println(t.count(5));
    }
}
