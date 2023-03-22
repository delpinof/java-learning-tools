package com.fherdelpino.datastructures.collections;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DoubleLinkedListTest {

    @Test
    public void test() {
        StringBuilder testString = new StringBuilder("AAWSWS");

        DoubleLinkedList dll = new DoubleLinkedList();

        dll.insertWord(testString.toString());

        assertThat(dll.getValues()).isEqualTo(testString.toString());
        assertThat(dll.getValuesReversed()).isEqualTo(testString.reverse().toString());

        assertThat(dll.remove("AWS")).isEqualTo("");
    }
}
