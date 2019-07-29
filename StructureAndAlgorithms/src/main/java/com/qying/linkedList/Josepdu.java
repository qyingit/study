package com.qying.linkedList;


public class Josepdu {

    public static void main(String[] args) {
        CircleSingleLinkedList  linkedList = new CircleSingleLinkedList();
        linkedList.addBoy(5);
        linkedList.showBoy();
        linkedList.countBoy(3,2,5);
//        小孩出圈，NO:5
//        小孩出圈，NO:2
//        小孩出圈，NO:4
//        小孩出圈，NO:3
//        最后出圈的小孩,NO:1
    }
}

class Boy{
    public int no;
    public Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}

class CircleSingleLinkedList{

    private Boy first = null;

    public void addBoy(int nums){
        if (nums < 1){
            System.out.println("nums 的值不正确");
            return;
        }
        Boy curBoy = null;
        for (int i = 1 ;i<= nums; i++){
            Boy boy = new Boy(i);
            if (i == 1){
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy(){
        if (first == null){
            System.out.println("链表为空");
            return;
        }
        Boy curBoy = first;
        while (true){
            System.out.println("NO:"+curBoy.getNo());
            if (curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     * 计算小孩出参顺寻
     * @param startNo
     * @param countNum
     * @param nums
     */

    public void countBoy(int startNo, int countNum,int nums){
        if (first == null || startNo <1|| startNo>nums){
            System.out.println("输入与吴");
        }
        Boy helper = first;
        while (true){
            if (helper.next == first){
                break;
            }
            helper = helper.next;
        }
        for (int i = 1; i<= startNo ;i++){
            first = first.next;
            helper = helper.next;
        }

        while (true){
            if (helper == first){
                break;
            }

            for (int j =0 ;j<= countNum-1 ;j++){
               first = first.next;
               helper = helper.next;
            }
            System.out.println("小孩NO:"+first.getNo());
            first = first.next;
            helper.next = first;
        }

        System.out.println("最后的小孩no:"+first.getNo());
    }

    /*public void countBoy(int startNo, int countNum, int nums){
        if (first == null || startNo<1 || startNo>nums){
            System.out.println("输出参数有误");
            return;
        }
        Boy help = first;
        while (true){
            if (help.getNext() == first){
                break;
            }
            help = help.getNext();
        }
        for (int j = 1; j<= startNo ; j++){
            first = first.getNext();
            help = help.getNext();
        }

        while (true){
            if (help == first){
                break;
            }
            for (int j =0;j< countNum-1 ; j++){
                first = first.getNext();
                help = help.getNext();
            }
            System.out.println("小孩出圈，NO:"+first.getNo());
            first = first.getNext();
            help.setNext(first);
        }
        System.out.println("最后出圈的小孩,NO:"+first.getNo());
    }*/
}
