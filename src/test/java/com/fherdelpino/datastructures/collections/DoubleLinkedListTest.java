package com.fherdelpino.datastructures.collections;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DoubleLinkedListTest {

    DoubleLinkedList dll = new DoubleLinkedList();

    @Test
    public void testGetValues() {
        String testString = "ABCD";
        dll.insertWord(testString);
        assertThat(dll.getValues()).isEqualTo(testString);
    }

    @Test
    public void testGetValuesReversed() {
        StringBuilder testString = new StringBuilder("ABCD");
        dll.insertWord(testString.toString());
        assertThat(dll.getValuesReversed()).isEqualTo(testString.reverse().toString());
    }

    @Test
    public void testRemove() {
        dll.insertWord("AAWSWS");
        assertThat(dll.remove("AWS")).isEqualTo("");
    }

}
