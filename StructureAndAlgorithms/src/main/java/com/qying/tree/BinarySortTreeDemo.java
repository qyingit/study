package com.qying.tree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int arr[] = {7,3,10,12,5,1,9,2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0 ;i<arr.length;i++){
            binarySortTree.add(new Node(arr[i]));
        }

        binarySortTree.infixOrder();
        System.out.println();
        //binarySortTree.delNode(12);
        //binarySortTree.delNode(5);
        //binarySortTree.delNode(10);
        binarySortTree.delNode(2);
        binarySortTree.delNode(3);
        binarySortTree.infixOrder();
    }
}

class BinarySortTree{
    private Node root;

    private Node getRoot(){
        return root;
    }

    public Node search(int value){
        if (root == null){
            return null;
        }else {
            return root.search(value);
        }
    }

    public Node searchParent(int value){
        if (root == null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    public int delRightTreeMin(Node node){
        Node target = node;
        while (target.left != null){
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    public void delNode(int value){
        if (root == null){
            return;
        }else{
            Node targetNode = search(value);
            if (targetNode == null){
                return;
            }

            if (root.left == null && root.right == null){
                root = null;
                return;
            }

            Node parent = searchParent(value);
            if (targetNode.left == null && targetNode.right == null){
                if (parent.left != null && parent.left.value == value){
                    parent.left = null;
                }else if(parent.right != null && parent.right.value == value){
                    parent.right = null;
                }
            }else if (targetNode.left != null && targetNode.right != null){
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            }else {
                if (targetNode.left != null){
                    if (parent != null){
                        if (parent.left.value == value){
                            parent.left= targetNode.left;
                        }else{
                            parent.right = targetNode.right;
                        }
                    }else {
                        root = targetNode.left;
                    }
                }else {
                    if (parent != null){
                        if (parent.left.value == value){
                            parent.left = targetNode.right;
                        }else {
                            parent.right = targetNode.right;
                        }
                    }else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }

    public void add(Node node){
        if (root == null){
            root = node;
        }else{
            root.add(node);
        }
    }

    public void infixOrder(){
        if (root != null){
            root.infixOrder();
        }else {
            System.out.println("空树");
        }
    }
}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node search(int value){
        if (value == this.value){
            return this;
        }else if(value < this.value){
            if (this.left == null){
                return null;
            }
            return this.left.search(value);
        }else {
            if (this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }

    public Node searchParent(int value){
        if (this.left != null && this.left.value == value||
                (this.right != null && this.right.value == value)){
            return this;
        }else {
            if (value < this.value && this.left != null){
                return this.left.searchParent(value);
            }else if (value>= this.value && this.right != null){
                return this.right.searchParent(value);
            }else {
                return null;
            }
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void add(Node node){
        if (node == null){
            return;
        }

        if (node.value < this.value){
            if (this.left == null){
                this.left = node;
            }else{
                this.left.add(node);
            }
        }else {
            if (this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }

    public void  infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.print(this+",");
        if (this.right != null){
            this.right.infixOrder();
        }
    }
}