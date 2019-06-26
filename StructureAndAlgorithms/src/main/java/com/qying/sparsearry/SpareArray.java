package com.qying.sparsearry;

public class SpareArray {
    public static void main(String[] args) {
        //创建原始的二维数组
        //1黑子 2篮子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将稀疏数组压缩
        int count = 0;
        for (int[] row : chessArr1) {
            for (int data : row) {
                if (data != 0) count++;

            }
        }
        int array[][] = new int[count+1][3];
        array[0][0] = 11;
        array[0][1] = 11;
        array[0][2] = count;
        count = 0;
        for (int i =0 ; i<11;i++){
            for (int j =0 ; j<11;j++){
                if (chessArr1[i][j] != 0){
                    count ++;
                    array[count][0] = i;
                    array[count][1] = j;
                    array[count][2] = chessArr1[i][j];
                }
            }
        }
        for (int[] row : array) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }


        //数组解码
        int row1 = array[0][0];
        int col = array[0][1];
        int newArray[][] = new int[row1][col];
        for (int i =1 ;i <array[0][2];i++){
            newArray[array[i][0]][array[i][1]] = array[i][2];
        }
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }


    }
}
