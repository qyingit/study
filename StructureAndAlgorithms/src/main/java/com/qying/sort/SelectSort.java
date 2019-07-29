package com.qying.sort;

public class SelectSort {

    public static void main(String[] args) {
//        耗费时间：3112
        int[] arr = new int[80000];
        for (int i = 0;i<80000;i++){
            arr[i] = (int)(Math.random()*80000);
        }
        Long startTime = System.currentTimeMillis();

        selectSort(arr);
        Long endTime = System.currentTimeMillis();
        System.out.println("耗费时间："+(endTime-startTime));
        for (int i= 0 ;i< arr.length;i++){
            System.out.println(arr[i]);
        }

    }

    private static void selectSort(int[] arr) {
        for (int i = 0 ;i< arr.length-1;i++){
            int minIndex = i;
            int min = arr[i];
            for (int j = i+1;j<arr.length;j++){
                if (min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
