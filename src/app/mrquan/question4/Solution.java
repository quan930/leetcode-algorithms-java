package app.mrquan.question4;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 *  4. 寻找两个有序数组的中位数
 *  Median of Two Sorted Arrays
 *  归并排序
 */
public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length+nums2.length];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (true){
            if (index1==nums1.length||index2==nums2.length)
                break;
            if (nums1[index1]<nums2[index2]){
                array[index] = nums1[index1];
                index1++;
            }else {
                array[index] = nums2[index2];
                index2++;
            }
            index++;
        }
        while (true){
            if (index==nums1.length+nums2.length)
                break;
            if (index1<nums1.length) {
                array[index] = nums1[index1];
                index1++;
            }else {
                array[index] = nums2[index2];
                index2++;
            }
            index++;
        }
        for (int i : array) {
            System.out.print(i+"\t");
        }
        System.out.println(index);
        return index%2==1?array[index/2]:((double) array[index/2]+array[index/2-1])/2;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2},new int[]{3,4}));
    }
}
