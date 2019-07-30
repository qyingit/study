package com.qying.sort;

public class QuickSort {

    public static void main(String[] args) {
       int arr[] = new int[80000000];
        for (int i = 0;i<80000000;i++){
            arr[i] = (int)(Math.random()*80000000);
        }
       //int arr[]={8,9,1,7,2,3,5,4,6,0};
        Long startTime = System.currentTimeMillis();

        quickSort(arr,0,arr.length-1);
        Long endTime = System.currentTimeMillis();
        System.out.println("耗费时间："+(endTime-startTime));
        for (int i= 0 ;i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    //3 5 4 2 3   l 0  r 4
    private static int partition(int[]  arr,int left ,int right){
        int temp = arr[left];
        while (right>left){
            while (temp<=arr[right]&& left<right){
                --right;
            }
            if (left <right){
                arr[left] = arr[right];
                ++left;
            }
            while (temp>=arr[left] && left<right){
                ++left;
            }
            if (left<right){
                arr[right] = arr[left];
                --right;
            }
        }
        arr[left] = temp;
        return left;
    }

    private static void quickSort(int[] arr,int left, int right){
        if (arr == null || left>=right||arr.length<=1){
            return;
        }
        int mid = partition(arr,left,right);
        quickSort(arr,left,mid);
        quickSort(arr,mid+1,right);
    }


}
