package com.qying.sort;

public class MergetSort {

    public static void main(String[] args) {
        int arr[] = new int[80000000];
        for (int i = 0;i<80000000;i++){
            arr[i] = (int)(Math.random()*80000000);
        }
        //int arr[]={8,9,1,7,2,3,5,4,6,0};
        Long startTime = System.currentTimeMillis();
        int temp[] = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        Long endTime = System.currentTimeMillis();
        System.out.println("耗费时间："+(endTime-startTime));//耗费时间：22274
        /*for (int i= 0 ;i< arr.length;i++){
            System.out.println(arr[i]);
        }*/
    }

    private static void mergeSort(int[] arr, int left, int right,int[] temp) {
        if (left<right){
            int mid  = (left + right)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid +1;
        int t = 0;
        while (i<=mid && j<=right){
            if (arr[i]<=arr[j]){
                temp[t] = arr[i];
                t+=1;
                i+=1;
            }else {
                temp[t] = arr[j];
                t+=1;
                j+=1;
            }
        }

        while (i<mid){
            temp[t]=arr[i];
            t+=1;
            i+=1;
        }
        while (j<=right){
            temp[t]= arr[j];
            t+=1;
            j+=1;
        }
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t+=1;
            tempLeft+=1;
        }
    }
}
