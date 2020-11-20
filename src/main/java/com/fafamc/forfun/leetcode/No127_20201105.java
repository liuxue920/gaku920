package com.fafamc.forfun.leetcode;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/word-ladder/
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 */
public class No127_20201105 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return 0;
    }

    public static boolean test1(String a,String b){
        if(StringUtils.isEmpty(a) || StringUtils.isEmpty(b)
            || a.length() != b.length()){
            return false;
        }
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        //不同字符的数量
        int def_num = 0;
        for(int i = 0 ; i < as.length ; i++){
            if(as[i] != bs[i]){
                def_num ++;
            }
        }
        if(def_num == 1){
            return true;
        }
        return false;
    }
}
