package com.fafamc.redpackage.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CalculationUtil {

    /**
     *
     * @param total 总结
     * @param pNum 人数
     * @return
     */
    public static List<Integer> groupMoney(int total,int pNum){
        if(pNum<1){
            throw new RuntimeException("xx异常");
        }
        if(pNum == 1){
            List<Integer> returnList = new ArrayList<>();
            returnList.add(total);
            return returnList;
        }
        //分段
        List<Integer> list = new ArrayList<>(pNum);
        Random random = new Random();
        while(list.size() != pNum - 1){
            int i = random.nextInt(total)+1;
            if(list.indexOf(i)<0){
                list.add(i);
            }
        }
        //将这个点分段排序
        Collections.sort(list);
        list.add(total);
        List<Integer> returnList = new ArrayList<>();

        returnList.add(list.get(0));
        for(int i = 1;i<list.size();i++){
            returnList.add(list.get(i) - list.get(i-1));
        }
        return returnList;
    }
}
