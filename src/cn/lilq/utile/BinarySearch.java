package cn.lilq.utile;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/15 15:23
 */
public class BinarySearch {
    public int binarySearch(int left,int right,int[] nums,int target){
        if (left > right){
            return -1;
        }
        int mid = left+(right-left)/2;
        if (nums[mid]==target)
            return mid;
        if (target > nums[mid]){
            return binarySearch(mid+1,right,nums,target);
        }else {
            return binarySearch(left,mid-1,nums,target);
        }
    }
}
