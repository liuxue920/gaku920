package com.fafamc.forfun.leetcode;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 *  Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * L       U
 * E     Y R
 * E   T   4
 * T R     G
 * S       T
 */
public class Zchange {

    private static String STR;
    private static Integer NUM_ROWS;
    //一个竖钩的元素数量
    private static Integer NUM;
    //一个方块的宽度
    private static Integer WIDTH;

    @Before
    public void init(){
        STR = "LEETCODEISHIRING";//DEISHIRING
        NUM_ROWS = 4;
        NUM = 2*NUM_ROWS-2;
        WIDTH = NUM - NUM_ROWS +1;
    }

    @Test
    public void test(){
        System.out.println(convert());
    }

    public static String convert(){
        String[][]strings = initArray();
        strings = fillArray(strings);
        return readArray(strings);
    }

    /**
     * 将字符串转换成一个二维数组，没有的字符为空
     * @return
     */
    public static String[][] initArray(){

        //包含的一个竖钩的数量，也是一个容纳竖钩长方格的数量
        int count = STR.length()%NUM == 0 ? STR.length()/NUM : STR.length()/NUM+1;
        return new String[(NUM_ROWS-1)*count][NUM_ROWS];
    }

    /**
     * 填充二维数组
     * @param strings
     * @return
     */
    public static String[][] fillArray(String[][] strings){
        String sources[] = STR.split("");
        int eee = 1;
        while(eee<=sources.length){
            String target = sources[eee-1];

            int x = eee%NUM == 0 ? eee/NUM : eee/NUM + 1; //判断当前是第几个方块
            int y = eee%NUM == 0 ? NUM : eee%NUM; //判断当前方块的第几个元素

            //竖着填充的
            if(y <= NUM_ROWS){
                int i = WIDTH * (x - 1);
                int j = y - 1;
                strings[i][j]=target;
            }else{//斜着填充的

                // 1. 在一个方块内，横坐标和纵坐标的和是2*NUM_ROWS-2，则有以下的逻辑

                int i = y-NUM_ROWS + (WIDTH * (x - 1));
                // i+1+j+1=NUM -2
                // i = y-NUM_ROWS
                int j = NUM -2 - (y-NUM_ROWS) - 1;
                strings[i][j]=target;
            }
            eee++;
        }
        System.out.println(Arrays.toString(strings));
        return strings;
    }

    public static String readArray(String[][] strings){
        StringBuilder sb = new StringBuilder();
        for(int j = 0 ; j<strings[j].length;j++){
            for(int i = 0 ; i<strings.length;i++){
                if(StringUtils.isNotBlank(strings[i][j])){
                    sb.append(strings[i][j]);
                }
            }
        }
        return sb.toString();
    }
}
