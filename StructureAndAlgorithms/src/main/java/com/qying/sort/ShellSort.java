package com.qying.sort;

public class ShellSort {

    public static void main(String[] args) {
//        耗费时间：7953
        int[] arr = new int[80000];
        for (int i = 0;i<80000;i++){
            arr[i] = (int)(Math.random()*80000);
        }
        Long startTime = System.currentTimeMillis();

        shellSort(arr);
        Long endTime = System.currentTimeMillis();
        System.out.println("耗费时间："+(endTime-startTime));
        for (int i= 0 ;i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    private static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        for (int gap = arr.length/2;gap>0;gap/=2){
            for (int i = gap;i<arr.length ;i++){
                for (int j = i-gap;j>=0;j-=gap){
                    if (arr[j]>arr[j+gap]){
                        temp = arr[j];
                        arr[j] =arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
        }
    }


}
