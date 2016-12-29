package ch02linkedlist;

import lib.LinkedListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2.1 다음의 비정렬(unsorted) 연결 리스트에서 중복 문자를 제거하는 코드를 작성하라.
 *
 *     연관 문제:
 *      임시 버퍼가 허용되지 않는 상황에서 이 문제를 어떻게 해결할수 있겠는가?
 *
 * 2.1 (5E)
 *      Write code to remove duplicates from an unsorted linked list.
 *
 *      FOLLOW UP:
 *          How would you solve this problem if a temporary buffer is not allowed?
 *
 * 2.1 (6E) Remove Dups:
 *      Write code to remove duplicates from an unsorted linked list.
 *
 *      FOLLOW UP:
 *          How would you solve this problem if a temporary buffer is not allowed?
 */
public class Question01 {
    //--------------------------------------------------------------------------------
    // Solution #1. Buffer: HashSet, HashMap, Hashtable
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    //--------------------------------------------------------------------------------
    public static void deleteDupsA(LinkedListNode head) {
        Set<Integer> set = new HashSet<Integer>();
        LinkedListNode current = head;
        LinkedListNode previous = null;

        while (current != null) {
            if (set.contains(current.getData())) {
                previous.setNext(current.getNext());
            } else {
                set.add(current.getData());
                previous = current;
            }

            current = current.getNext();
        }
    }


    //--------------------------------------------------------------------------------
    // Solution #2. Runner 1
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    //--------------------------------------------------------------------------------
    public static void deleteDupsB(LinkedListNode head) {
        LinkedListNode current = head;
        LinkedListNode runner = null;

        while (current != null) {
            runner = current;

            while (runner.getNext() != null) {
                if (runner.getNext().getData() == current.getData()) {
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }

            current = current.getNext();
        }
    }

    //--------------------------------------------------------------------------------
    // Solution #3. Runner 2
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    //--------------------------------------------------------------------------------
    public static void deleteDupsC(LinkedListNode head) {
        LinkedListNode previous = head;
        LinkedListNode current = previous.getNext();
        LinkedListNode runner = null;

        while (current != null) {
            runner = head;

            while (runner != current) {
                if (runner.getData() == current.getData()) {
                    LinkedListNode next = current.getNext();
                    previous.setNext(next);
                    current = next;
                    break;
                }

                runner = runner.getNext();
            }

            if (runner == current) {
                previous = current;
                current = current.getNext();
            }
        }
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        // Sample 01
//        LinkedListNode first = AssortedMethods.randomLinkedList(1000, 0, 2);

        // Sample 02
        LinkedListNode first = new LinkedListNode(0, null, null);
        LinkedListNode head = first;
        LinkedListNode second = first;

        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }

        System.out.println("Original: " + head.printForward());

        // Buffer
        LinkedListNode cloneA = head.clone();
        System.out.println("CloneA: " + cloneA.printForward());

        deleteDupsA(cloneA);
        System.out.println("\tCloneA: " + cloneA.printForward());


        // Runner 1
        LinkedListNode cloneB = head.clone();
        System.out.println("CloneB: " + cloneB.printForward());

        deleteDupsB(cloneB);
        System.out.println("\tCloneB: " + cloneB.printForward());


        // Runner 2
        LinkedListNode cloneC = head.clone();
        System.out.println("CloneC: " + cloneC.printForward());

        deleteDupsC(cloneC);
        System.out.println("\tCloneC: " + cloneC.printForward());
    }
}