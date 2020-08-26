package com.fafamc.testpackage.test1;

import java.util.*;

/**
    若干学生，随机收取数字，班级所有的数字用数组表示，要求对学生分组

    1.每组有n个学生
    2.每组内的学生数组都相同
    3.按学生数升序
    4.数组相同尽量在一个分组

    如果可以学生分组，且n>2，返回结果，否则返回空
 **/
public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        List<Integer> scanInner = new ArrayList<>();
//        while(in.hasNextLine()){
//            scanInner.add(in.nextInt());
//        }
        //demo

        {
            scanInner =  new ArrayList<>();
            scanInner.add(3);
            scanInner.add(3);
            scanInner.add(3);
            scanInner.add(3);
            scanInner.add(1);
            //scanInner.add(1);
        }
        //key -数字   value -个数
        Map<Integer,Integer> map =  Main.toMap(scanInner);

        //最大公约数
        Integer maxG = Main.maxG(map);

        Integer [][] returnInts= {};
        if(maxG == 1){
            System.out.println(returnInts);
            return;
        }
        returnInts = new Integer[map.keySet().size()][maxG];
        List<Integer> keys = Main.sortAsc(map.keySet());
        for(int i_key = 0 ; i_key < keys.size() ; i_key++){
            for(int j = 0 ; j< maxG ; j++){
                returnInts[i_key][j]= keys.get(i_key);
            }
        }
        System.out.println(Arrays.toString(returnInts));
    }

    //得到数字及对应的个数
    public static Map<Integer,Integer> toMap(List<Integer>integers){
        Map<Integer,Integer> returnMap = new HashMap<>();
        for(Integer in : integers){
            if(returnMap.containsKey(in)){
                returnMap.put(in,returnMap.get(in)+1);
            }else{
                returnMap.put(in,1);
            }
        }
        return returnMap;
    }
    //升序排序
    public static List<Integer> sortAsc(Set<Integer> set){
        List<Integer> arrayList = new ArrayList<>(set);
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        return arrayList;
    }

    //升序排序
    public static List<Integer> sortAsc(List<Integer> list){
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        return list;
    }

    //求最大公约数
    public static Integer maxG(Map<Integer,Integer> map){
        List<Integer> list = new ArrayList<>();
        for(Integer va : map.values()){
            list.add(va);
        }
        Main.sortAsc(list);
        int returnValue = 1;
        while(true){
            int index = 1;

            boolean flag = true;
            for(Integer i : list){
                if(i%returnValue != 0){
                    flag = false;
                }
            }
            if(flag){
                returnValue++;
            }

            index++;
            if(index >= list.get(0)){
                break;
            }
        }
        return returnValue;
    }

}
