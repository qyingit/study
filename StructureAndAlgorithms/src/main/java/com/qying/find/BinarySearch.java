package com.qying.find;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        int arr[]={1,8,10,89,1000,1000,1234};
        //int resIndex = binarySearch1(arr,0,arr.length,1000);

        List<Integer> resIndex = binarySearch2(arr,0,arr.length,1000);
        System.out.println("index="+resIndex);
    }

    private static List<Integer> binarySearch2(int[] arr,  int left, int right, int value) {
        if(left>right){
            return new ArrayList<Integer>();
        }

        int mid = (left + right)/2;
        int midVal = arr[mid];
        if (value > midVal){
            return binarySearch2(arr,mid+1,right,value);
        } else if (value<midVal) {
            return binarySearch2(arr,left,mid-1,value);
        }else {
            List<Integer> resIndexList = new ArrayList<Integer>();
            int temp = mid -1;
            while (true){
                if (temp<0||arr[temp]!= value){
                    break;
                }
                resIndexList.add(temp);
                temp-=1;
            }
            resIndexList.add(mid);
            temp= mid+1;
            while (true){
                if (temp>arr.length-1||arr[temp]!=value){
                    break;
                }
                resIndexList.add(temp);
                temp+=1;
            }
            return resIndexList;
        }
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
