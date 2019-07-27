package com.qying.linkedList;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1,"宋江","及时雨");
        HeroNode heroNode2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode heroNode3 = new HeroNode(3,"吴用","智多星");
        HeroNode heroNode4 = new HeroNode(4,"林冲","豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode2);

        singleLinkedList.list();
        singleLinkedList.del(2);
        singleLinkedList.list();

    }
}


class HeroNode{
    public int no;
    public String name;
    public String  nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'';
    }
}

class SingleLinkedList{
    private HeroNode head = new HeroNode(0,"","");

    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no > heroNode.no){
                break;
            }else if (temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;

        }

        if (flag){
            System.out.println("英雄已经存在");
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void update(HeroNode heroNode){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        }else {
            System.out.println("没找到数据");
        }
    }

    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }

            if (temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("节点不存在");
        }
    }

    public void list(){
        if (head.next == null){
            System.out.println("没有元素");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}