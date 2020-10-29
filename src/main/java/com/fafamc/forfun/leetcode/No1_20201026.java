package com.fafamc.forfun.leetcode;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class No1_20201026 {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0 ; i < nums.length;i++){
            for(int j = 0 ; j < nums.length && j!= i ; j++){
                if(nums[i] + nums[j] == target){
                    int result[] = {i,j};
                    return result;
                }
            }
        }
        throw new RuntimeException("error");
    }

    public static void main(String[] args) {
        No1_20201026 solution = new No1_20201026();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums,target);
        System.out.println(Arrays.toString(result));
    }
}
