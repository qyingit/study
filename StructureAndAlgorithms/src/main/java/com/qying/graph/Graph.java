package com.qying.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;
    private boolean[] isVisited;

    public static void main(String[] args) {

    }

    public void dfs(){
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i< vertexList.size() ; i++){
            if (!isVisited[i]){
                dfs(isVisited , i);
            }
        }
    }

    public void dfs(boolean[] isVisited, int i){
        System.out.println(getValueByIndex(i)+"->");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1){
            if (!isVisited[w]){
                dfs(isVisited, w);
            }
            w = getNexighbor(i, w);
        }
    }

    public void bfs(){
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i< getNumOfVertex();i++){
            if (!isVisited[i]){
                bfs(isVisited, i);
            }
        }
    }

    public void bfs(boolean[] isVisited, int i){

        int u;
        int w;

        LinkedList queue = new LinkedList();
        System.out.println(getValueByIndex(i)+"->");
        isVisited[i] = true;
        queue.addLast(i);
        while (! queue.isEmpty()){
            u = (Integer)queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1){
                if (!isVisited[w]){
                    System.out.println(getValueByIndex(w)+"->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNexighbor(u,w);
            }
        }

    }



    public Graph(int n){
        vertexList = new ArrayList<String>(n);
        edges = new int[n][n];
        numOfEdges = 0;
    }

    public int getFirstNeighbor(int index){
        for (int j = 0 ; j < vertexList.size(); j++ ){
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public int getNexighbor(int v1, int v2){
        for (int j = v2+1; j < vertexList.size();j++){
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public int getNumOfVertex(){
        return vertexList.size();
    }

    public void showGraph(){
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    public int getNumOfEdges(){
        return numOfEdges;
    }

    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    public void insertEdges(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }


}
