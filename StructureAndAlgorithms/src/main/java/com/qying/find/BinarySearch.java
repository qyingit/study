package com.qying.find;

public class BinarySearch {

    public static void main(String[] args) {
        int arr[]={1,8,10,89,1000,1000,1234};
        int resIndex = binarySearch1(arr,0,arr.length,1000);
        System.out.println("index="+resIndex);
    }

    private static int binarySearch1(int[] arr, int right, int left, int value) {
        if (arr[(right+left)/2] == value){
            return (right+left)/2;
        }else if (arr[(right+left)/2] < value){
           return binarySearch1(arr,(right+left)/2,left,value);
        }else {
           return binarySearch1(arr,right,(right+left)/2,value);
        }
    }


}
