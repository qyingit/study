package com.qying.hashTable;


public class HashTableDemo {

    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        Emp emp1 = new Emp(1,"qying1");
        Emp emp2 = new Emp(2,"qying2");
        Emp emp3 = new Emp(3,"qying3");
        Emp emp4 = new Emp(8,"qying8");
        Emp emp5 = new Emp(9,"qying9");
        Emp emp6 = new Emp(10,"qying10");
        Emp emp7 = new Emp(15,"qying15");

        hashTab.add(emp1);
        hashTab.add(emp2);
        hashTab.add(emp3);
        hashTab.add(emp4);
        hashTab.list();
        hashTab.add(emp5);
        hashTab.add(emp6);
        hashTab.add(emp7);
        hashTab.findEmpById(2);
    }
}


class HashTab{
    private EmpLinkedList[] empLinkedLists;
    private int size;
    public HashTab(int size){
        this.size =size;
        empLinkedLists = new EmpLinkedList[size];
        for (int i =0;i<size;i++){
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp){
        int hashNo = hasFun(emp.id);
        empLinkedLists[hashNo].add(emp);

    }

    public void list(){
        for (int i = 0;i<size;i++){
            empLinkedLists[i].list(i);
        }
    }

    public void findEmpById(int id){
        int hashNo = hasFun(id);
        Emp emp = empLinkedLists[hashNo].findEmpById(id);
        if (emp != null){
            System.out.println(emp.id+"empName:"+emp.name );
        }
    }

    //散列hash函数
    public int hasFun(int id){
        return id % size;
    }
}

class EmpLinkedList{
    private Emp head;
    public void add(Emp emp){
        if (head == null){
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    public void list(int no){
        if (head == null){
            System.out.println("链表为空");
            return;
        }
        System.out.print("NO:"+no+"信息位:");
        Emp  curEmp= head;
        while (true){
            System.out.println(curEmp.id+","+curEmp.name+"\t");
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    public Emp findEmpById(int id){
        if (head == null){
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        boolean flag = false;
        while (true){
            if (curEmp.id == id){
                flag = true;
                break;
            }
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        if (flag == true){
            return curEmp;
        }else {
            System.out.println("未找到数据");
            return null;
        }
    }
}

class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}