package com.qying.tree;

public class BinaryTreeDemo {


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1,"宋江");
        HeroNode node2 = new HeroNode(2,"吴用");
        HeroNode node3 = new HeroNode(3,"卢俊义");
        HeroNode node4 = new HeroNode(4,"林冲");
        HeroNode node5 = new HeroNode(5,"关胜");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        //   宋江
        //吴用   卢俊义
        //    林冲     关胜
        binaryTree.setRoot(root);
        System.out.println("前序遍历");
        binaryTree.preOrder();
        binaryTree.delNode(3);
        System.out.println("中序遍历");
        binaryTree.infixOrder();
        System.out.println("后序遍历");
        binaryTree.postOrder();
    }
}

class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空无法遍历");
        }
    }

    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空无法遍历");
        }
    }
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空无法遍历");
        }
    }

    public void delNode(int no){
        if (root !=null){
            if (root.getNo() == no){
                root = null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("树为空,不能删除");
        }
    }
}

class HeroNode{
    private int no ;
    private String name;
    private HeroNode left;
    private HeroNode right;
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        //向左遍历
        if (this.left != null){
            this.left.preOrder();
        }

        //向右遍历
        if (this.right != null){
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public HeroNode preOrderSearch(int no){
        if (this.no == no){
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }

        if (this.right != null){
            resNode = this.preOrderSearch(no);
        }

        return resNode;
    }

    public HeroNode infixOrderSearch(int no){
        HeroNode heroNode = null;
        if (this.left != null){
            heroNode = this.infixOrderSearch(no);
        }
        if (heroNode != null){
            return heroNode;
        }
        if (this.no == no){
            return this;
        }

        if (this.right != null){
            heroNode = this.infixOrderSearch(no);
        }

        return heroNode;
    }

    public HeroNode postOrderSezrch(int no){
        HeroNode heroNode = null;
        if (this.right != null){
            heroNode = this.left.postOrderSezrch(no);
        }
        if (heroNode != null){
            return heroNode;
        }
        if (this.left != null){
            heroNode = this.postOrderSezrch(no);
        }
        if (heroNode!= null){
            return heroNode;
        }
        if (this.no == no){
            return this;
        }
        return heroNode;
    }

    public void delNode(int no){
        if (this.left != null && this.left.no == no){
            this.left =null;
            return;
        }

        if (this.left != null && this.right.no == no){
            this.right = null;
            return;
        }
        if (this.left != null){
            this.left.delNode(no);
        }

        if (this.right!=null){
            this.right.delNode(no);
        }
    }
}
