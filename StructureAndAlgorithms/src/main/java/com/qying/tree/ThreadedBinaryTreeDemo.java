package com.qying.tree;

public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        HeroNode root  = new HeroNode(1,"tom");
        HeroNode node2  = new HeroNode(3,"jack");
        HeroNode node3  = new HeroNode(6,"smith");
        HeroNode node4  = new HeroNode(8,"mary");
        HeroNode node5  = new HeroNode(10,"king");
        HeroNode node6  = new HeroNode(14,"dim");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);


        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        System.out.println("中序线索化");

        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("前驱节点"+leftNode);
        System.out.println("后驱节点"+rightNode);

        threadedBinaryTree.threadedList();
    }
}

class ThreadedBinaryTree{
    private HeroNode root;
    private HeroNode pre;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void threadedNodes(){
        this.threadedNodes(root);
    }

    public void threadedList(){
        HeroNode node = root;
        while (node != null){
            while (node.getLeftType()== 0){
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType() == 1){
                node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    public void threadedNodes(HeroNode heroNode){
        if (heroNode == null){
            return;
        }

        threadedNodes(heroNode.getLeft());
        if (heroNode.getLeft() == null){
            heroNode.setLeft(pre);
            heroNode.setLeftType(1);
        }

        if (pre != null && pre.getRight() == null){
            pre.setRight(heroNode);
            pre.setRightType(1);
        }
        pre= heroNode;
        threadedNodes(heroNode.getRight());
    }

    public void delNode(int no){
        if(root != null){
            if (root.getNo() == no){
                root =null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("空树,不能删除");
        }
    }

    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树空,无法遍历");
        }
    }

    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树空,无法遍历");
        }
    }

    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树空,无法遍历");
        }
    }

    public void preOrderSearch(int no){
        if (this.root != null){
            this.root.preOrderSearch(no);
        }else {
            System.out.println("二叉树空,无法遍历");
        }
    }

    public void infixOrderSearch(int no){
        if (this.root != null){
            this.root.infixOrderSearch(no);
        }else {
            System.out.println("二叉树空,无法遍历");
        }
    }

    public void postOrderSearch(int no){
        if (this.root != null){
            this.root.postOrderSezrch(no);
        }else {
            System.out.println("二叉树空,无法遍历");
        }
    }


}