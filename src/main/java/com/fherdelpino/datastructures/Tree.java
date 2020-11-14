package com.fherdelpino.datastructures;

public class Tree {

    Tree left;
    Tree right;
    int data;

    public Tree(int data) {
        this.data = data;
    }

    public void insert(int data) {
        if (data <= this.data) {
            if (this.left == null) {
               left = new Tree(data);
            } else {
                left.insert(data);
            }
        } else {
            if (this.right == null) {
                right = new Tree(data);
            } else {
                right.insert(data);
            }
        }
    }

    public boolean contains(int data) {
        if (this.data == data) {
            return true;
        }
        if (data <= this.data) {
            if (this.left == null) {
                return false;
            } else {
                return this.left.contains(data);
            }
        } else {
            if (this.right == null) {
                return false;
            } else {
                return this.right.contains(data);
            }
        }
    }

    public void printInOrder() {
        if (this.left != null) {
            left.printInOrder();
        }
        System.out.println(data);
        if (this.right != null) {
            right.printInOrder();
        }
    }
}
