package com.fherdelpino.datastructures.collections;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

@Slf4j
public class SequencedCollectionTest {

    @Test
    void testTreeSet() {
        SortedSet<Integer> ss = new TreeSet<>();
        ss.add(8);
        ss.add(1);
        ss.add(5);
        ss.add(3);
        ss.add(4);
        log.info("{}", ss.first());
        log.info("{}", ss.getFirst());
    }

    @Test
    void testLinkedHashSet() {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();


    }

    @Test
    void testSequencedCollectionsMethods() {
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6));
        list.removeLast();
        log.info("{}", list);
    }
}
