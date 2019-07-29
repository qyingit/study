package com.qying.linkedList;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1,"宋江","及时雨");
        HeroNode heroNode2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode heroNode3 = new HeroNode(3,"吴用","智多星");
        HeroNode heroNode4 = new HeroNode(4,"林冲","豹子头");

        DoubleLinkedList list = new DoubleLinkedList();
        list.add(heroNode1);
        list.add(heroNode4);
        list.add(heroNode2);
        list.add(heroNode3);
//        list.add(heroNode1);
        list.list();
        HeroNode heroNode5 = new HeroNode(2,"卢俊义111","玉麒麟");
        list.update(heroNode5);
        list.list();
        list.del(3);
        list.list();
    }
}



class DoubleLinkedList{
    private HeroNode head = new HeroNode(0,"","");
    public HeroNode getHead(){
        return head;
    }

    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            if (temp == null || temp.next == head){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        heroNode.pre = temp;
        temp.next = heroNode;
    }

    public void update(HeroNode heroNode){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;
        boolean falg = false;
        while (true){
            if (temp == head){
                break;
            }
            if (temp.no == heroNode.no){
                falg = true;
                break;
            }
            temp = temp.next;
        }

        if (falg){
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        }else {
            System.out.println("没有找到节点");
        }
    }

    public void  del(int no){
        if (head == null){
            System.out.println("链表为空,不能删除");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == head){
                break;
            }
            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            temp.pre.next = temp.next;
            if (temp.next!=null){
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.println("节点不存在");
        }

    }
}

