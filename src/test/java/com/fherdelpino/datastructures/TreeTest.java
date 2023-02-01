package com.fherdelpino.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TreeTest {

    @Test
    public void tree_insert_Test() {
        Tree tree = new Tree(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(2);
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(10);
    }

    @Test
    public void tree_printInOrder_Test() {
        Tree tree = new Tree(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(2);
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(10);
        tree.printInOrder();
    }

    @Test
    public void tree_contains_false() {
        Tree tree = new Tree(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(2);
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(10);
        assertFalse(tree.contains(11));
    }

    @Test
    public void tree_contains_true() {
        Tree tree = new Tree(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(2);
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(10);
        assertTrue(tree.contains(1));
    }

    @Test
    public void tree_printBFS() {
        Tree tree = new Tree(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(2);
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(10);
        tree.printBFS();
    }

    @Test
    public void tree_printDFS() {
        Tree tree = new Tree(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(2);
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(10);
        tree.printDFS();
    }
}
