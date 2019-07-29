package com.qying.sort;

public class InsertSort {

    public static void main(String[] args) {

        int[] arr = new int[80000];
        for (int i = 0;i<80000;i++){
            arr[i] = (int)(Math.random()*80000);
        }
        Long startTime = System.currentTimeMillis();

        insertSort(arr);
        Long endTime = System.currentTimeMillis();
        System.out.println("耗费时间："+(endTime-startTime));
        for (int i= 0 ;i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    private static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int i =1;i< arr.length;i++){
            insertVal = arr[i];
            insertIndex = i-1;
            while (insertIndex >= 0&& insertVal<arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex --;
            }
            if (insertIndex +1 != i){
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
}
