package com.qying.sort;

public class RadixSort {

    public static void main(String[] args) {
       int arr[] = new int[80];
        for (int i = 0;i<80;i++){
            arr[i] = (int)(Math.random()*80);
        }
       //int arr[]={8,9,1,7,2,3,5,4,6,0};
        Long startTime = System.currentTimeMillis();

        radixSort(arr);
        Long endTime = System.currentTimeMillis();
        System.out.println("耗费时间："+(endTime-startTime));//耗费时间：14568
        for (int i= 0 ;i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    private static void radixSort(int[] arr) {
        int max  =arr[0];
        for (int i = 1;i<arr.length;i++){
            if (arr[i]>max){
                max = arr[i];
            }
        }
        int maxLength = (max+"").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        for (int i =0,n=1;i<maxLength;i++,n *=10){
            for (int j = 0;j<arr.length;j++){
                int digitOfElement = arr[j]/n%10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            int index = 0;
            for (int k = 0;k<bucketElementCounts.length;k++){
                if (bucketElementCounts[k]!= 0){
                    for (int l = 0;l<bucketElementCounts[k];l++){
                        arr[index++]= bucket[k][l];
                    }
                }
                bucketElementCounts[k]=0;
            }
        }
    }


}
