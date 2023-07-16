package com.fherdelpino.challenge;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class SinglyLinkedListMergeTest {

    @Test
    public void testSinglyLinkedListMerge() {

        SinglyLinkedListMerge.ListNode list1 = null;
        SinglyLinkedListMerge.ListNode list2Head = new SinglyLinkedListMerge.ListNode();
        SinglyLinkedListMerge.ListNode list2 = list2Head;
        for (int i = 0; i < 10; i += 2) {
            //fill right to left
            list1 = new SinglyLinkedListMerge.ListNode(i, list1);
            //fill left to right
            list2.next = new SinglyLinkedListMerge.ListNode(i + 1);
            list2 = list2.next;
        }

        log.info("list1");
        printFromEnd(list1);
        log.info("list2");
        printFromBeginning(list2Head.next);

        SinglyLinkedListMerge.ListNode result = SinglyLinkedListMerge.mergeTwoLists(list1, list2Head.next);

        log.info("result");
        printFromBeginning(result);
    }

    public void printFromBeginning(SinglyLinkedListMerge.ListNode listNode) {
        while (listNode != null) {
            log.info("{}", listNode.val);
            listNode = listNode.next;
        }
    }

    public void printFromEnd(SinglyLinkedListMerge.ListNode listNode) {
        if (listNode != null) {
            printFromEnd(listNode.next);
            log.info("{}", listNode.val);
        }

    }
}
