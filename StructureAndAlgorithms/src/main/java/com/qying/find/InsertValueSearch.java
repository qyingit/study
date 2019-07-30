package com.qying.find;

public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1000,1234};
        int index = insertValueSearch(arr,0,arr.length-1,1234);
        System.out.println("索引:"+index);
    }

    private static int insertValueSearch(int[] arr, int left, int right, int value) {
        if (left>right||value<arr[0]||value>arr[arr.length-1]){
            return -1;
        }

        int mid = left+(right-left)*(value -arr[left])/(arr[right]-arr[left]);
        int midVal = arr[mid];
        if (value>midVal){
            return insertValueSearch(arr,mid+1,right,value);
        }else if(value <midVal){
            return insertValueSearch(arr,left,mid-1,value);
        }else {
            return mid;
        }
    }
}
