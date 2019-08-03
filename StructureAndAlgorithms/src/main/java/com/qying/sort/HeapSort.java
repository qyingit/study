package com.qying.sort;

public class HeapSort {

    public static void main(String[] args) {
        int arr[] = new int[80000000];
        for (int i = 0;i<80000000;i++){
            arr[i] = (int)(Math.random()*80000000);
        }
        //int arr[]={8,9,1,7,2,3,5,4,6,0};
        Long startTime = System.currentTimeMillis();

        heapSort(arr);
        Long endTime = System.currentTimeMillis();
        System.out.println("耗费时间："+(endTime-startTime));
        for (int i= 0 ;i< 10;i++){
            System.out.println(arr[i]);
        }
    }

    private static void heapSort(int[] arr) {
        int temp = 0;
        System.out.println("堆排序");
        for (int i = arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }

        for (int j = arr.length -1;j>0;j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
    }

    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];

        for (int k = i*2+1;k<length;k=k*2+1){
            if (k+1 <length && arr[k]<arr[k+1]){
                k++;
            }
            if (arr[k]>temp){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
            arr[i] = temp;
        }
    }
}
