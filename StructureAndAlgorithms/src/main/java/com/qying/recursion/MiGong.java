package com.qying.recursion;

public class MiGong {

    public static void main(String[] args) {
        //创建迷宫
        int[][] map = new int[8][7];
        //上下为1
        for (int i =0;i<7;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //左右为1
        for (int i =0;i< 8;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //设置挡板
        map[3][1]=1;
        map[3][2]=1;
        System.out.println("地图");
        for (int i =0;i<8;i++){
            for (int j =0;j<7;j++){
                System.out.print(map[i][j]+"    ");
            }
            System.out.println();
        }

        setWay2(map,1,1);


        System.out.println("相关路径");

        for (int i =0;i<8;i++){
            for (int j =0;j<7;j++){
                System.out.print(map[i][j]+"    ");
            }
            System.out.println();
        }
    }

    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5]==2){
            return true;
        }else {
            if (map[i][j] == 0){
                map[i][j]=2;
                if (setWay(map,i+1,j)){
                    return true;
                }else if(setWay(map,i,j+1)){
                    return true;
                }else if(setWay(map,i-1,j)){
                    return true;
                }else if (setWay(map,i,j-1)){
                    return true;
                }else {
                    map[i][j]=3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }

    public static boolean setWay2(int[][] map,int i,int j){
        if(map[6][5]==2){
            return true;
        }else {
            if (map[i][j] == 0){
                map[i][j]=2;
                if (setWay(map,i-1,j)){
                    return true;
                }else if(setWay(map,i,j+1)){
                    return true;
                }else if(setWay(map,i+1,j)){
                    return true;
                }else if (setWay(map,i,j-1)){
                    return true;
                }else {
                    map[i][j]=3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
