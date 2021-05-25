package cn.lilq.question66;

import java.util.Arrays;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/25 19:20
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length-1;
        boolean res = false;
        while (index>=0){
            if (digits[index]==9){
                digits[index] = 0;
                index--;
            }else {
                digits[index] += 1;
                res = true;
                break;
            }
        }
        if (res){
            return digits;
        }else {
            int[] ress = new int[digits.length+1];
            ress[0] = 1;
            System.arraycopy(digits, 0, ress, 1, digits.length);
            return ress;
        }
    }
}
