package com.qying.other;

/**
 * 二分查找非递归
 */
public class TwoFindNum {
    public static void main(String[] args) {
        int arr[] = {1,3,8,10,11,67,100};
        int index = binarySearch(arr,100);
        System.out.println("index="+index);
    }

    public static int binarySearch(int[] arr, int num){
        int min = 0;
        int max =  arr.length;
        int index = arr.length/2;
        while (min <= max){
            if (arr[(min + max)/2] > num){
                max = (min + max)/2-1;
            }else if(arr[(min + max)/2] < num){
                min = (min + max)/2+1;
            }else {
                return (min + max)/2;
            }
        }
        return -1;
    }
}
