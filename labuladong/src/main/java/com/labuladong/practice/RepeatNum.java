package com.labuladong.practice;

/**
 * 地址：<a href="https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/">...</a>
 */
public class RepeatNum {

    public static int findRepeatNumber(int[] nums) {
        int[] array = new int[100000];
        for (int num : nums) {
            array[num]++;
            if (array[num] > 1) {
                return num;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }
}
