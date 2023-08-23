package com.fherdelpino.datastructures;

import java.util.LinkedList;
import java.util.Queue;

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

    public void printBFSMultiLevel() {
        Queue<Tree> queue = new LinkedList<>();
        queue.add(this);
        queue.add(null); //to identify each level
        while (!queue.isEmpty()) {
            Tree actual = queue.remove();
            if (actual != null) {
                System.out.print(actual.data + " ");
                if (actual.left != null)
                    queue.add(actual.left);
                if (actual.right != null)
                    queue.add(actual.right);
            } else {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    System.out.println();
                }
            }
        }
    }

    public void printBFS() {
        Queue<Tree> queue = new LinkedList<>();
        queue.add(this);
        while(!queue.isEmpty()) {
            Tree actual = queue.remove();
            System.out.println(actual.data + " ");
            if (actual.left != null) {
                queue.add(actual.left);
            }
            if (actual.right != null) {
                queue.add(actual.right);
            }
        }
    }

    public void printDFS() {
        System.out.println(data);
        if (this.left != null)
            this.left.printDFS();
        if (this.right != null)
            this.right.printDFS();
    }
}
