package ch02linkedlist;

import lib.AssortedMethods;
import lib.LinkedListNode;

/**
 * 2.2 단방향 연결 리스트에서, 뒤에서 k번째 원소를 찾는 알고리즘을 구현하라.
 *
 * 2.2 Return Kth to Last:
 *      Implement an algorithm to find the nth to last element of a singly linked list.
 */
public class Question02 {

    public static LinkedListNode nthToLast01(LinkedListNode head, int n) {
        //TODO:
        return null;
    }

    public static LinkedListNode nthToLast02(LinkedListNode head, int n) {
        //TODO:
        return null;
    }

    public static LinkedListNode nthToLast03(LinkedListNode head, int n) {
        //TODO:
        return null;
    }

    public static LinkedListNode nthToLast04(LinkedListNode head, int n) {
        //TODO:
        return null;
    }

    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        System.out.println(head.printForward());

        int nth = 3;
//        IntWrapper wr = new IntWrapper();

        LinkedListNode  n = nthToLast04(head, nth);
        if (n != null) {
            System.out.println(nth + "th to last node is " + n.data);
        } else {
            System.out.println("Null. n is out of bounds");
        }

        nthToLast02(head, nth); //TODO:
    }
}
