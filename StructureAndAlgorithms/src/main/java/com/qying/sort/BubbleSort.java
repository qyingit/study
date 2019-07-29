package com.qying.sort;

public class BubbleSort {

    public static void main(String[] args) {
//        int arr[] = {3,9,-1,10,20};
//        System.out.println("排序前");
        int[] arr = new int[80000];
        for (int i =0;i<80000;i++){
            arr[i] = (int)(Math.random()*80000);
        }
        Long startTime = System.currentTimeMillis();

        bubbleSort(arr);
        Long endTime = System.currentTimeMillis();
        System.out.println("耗费时间："+(endTime-startTime));

        for (int i= 0 ;i< arr.length;i++){
            System.out.println(arr[i]);
        }
        
    }

    private static void bubbleSort(int[] arr) {

        int temp = 0;
        boolean flag = false;
        for (int i =0;i<arr.length - 1;i++){
            for (int j = 0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (!flag){
                break;
            }else {
                flag= false;
            }
        }
    }
}
