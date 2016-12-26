package ch02linkedlist;

import lib.LinkedListNode;

/**
 * 2.4 x값을 갖는 노드를 기준으로 연결 리스트를 나누는 코드를 작성하라.
 *     x보다 작은 값을 갖는 노드가 x와 같거나 더 큰 값을 갖는 노드보다 앞쪽에 오도록 하면 된다.
 *
 * 2.4 Partition:
 *      Write code to partition a linked list around a value x,
 *      such that all nodes less than x come before all nodes greater than or equal to x.
 *      If x is contained within the list, the values of x only need to be after the elements less than x (see below).
 *      The partition element x can appear anywhere in the "right partition";
 *      it does not need to appear between the left and right partitions.
 *
 *      EXAMPLE
 *          Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
 *          Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
public class Question04 {
    //--------------------------------------------------------------------------------
    // Solution #1. 4-References: beforeStart/beforeEnd & afterStart/afterEnd
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    //--------------------------------------------------------------------------------
    public static LinkedListNode partition01(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        LinkedListNode current = node;

        while (current != null) {
            LinkedListNode next = current.getNext();
            current.setNext(null);

            if (current.getData() < x) {
                if (beforeStart == null) {
                    beforeStart = current;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.setNext(current);
                    beforeEnd = current;
                }
            } else {
                if (afterStart == null) {
                    afterStart = current;
                    afterEnd = afterStart;
                } else {
                    afterEnd.setNext(current);
                    afterEnd = current;
                }
            }

            current = next;
        }

        if (beforeStart == null)
            return afterStart;

        beforeEnd.setNext(afterStart);

        return beforeStart;
    }

    //--------------------------------------------------------------------------------
    // Solution #2. 2-References: beforeStart & afterStart
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    //--------------------------------------------------------------------------------
    public static LinkedListNode partition02(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode afterStart = null;

        LinkedListNode current = node;

        while (current != null) {
            LinkedListNode next = current.getNext();
            current.setNext(null);

            if (current.getData() < x) {
                current.setNext(beforeStart);
                beforeStart = current;
            } else {
                current.setNext(afterStart);
                afterStart = current;
            }

            current = next;
        }

        if (beforeStart == null)
            return afterStart;

        LinkedListNode head = beforeStart;
        while (beforeStart.getNext() != null) {
            beforeStart = beforeStart.getNext();
        }

        beforeStart.setNext(afterStart);

        return head;
    }

    //--------------------------------------------------------------------------------
    // Solution #3. 2-References: head & tail
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    //--------------------------------------------------------------------------------
    public static LinkedListNode partition03(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        LinkedListNode current = head;

        while (current != null) {
            LinkedListNode next = current.getNext();
            current.setNext(null);

            if (current.getData() < x) {
                current.setNext(head);
                head = current;
            } else {
                tail.setNext(current);
                tail = current;
            }

            current = next;
        }

        tail.setNext(null);

        return head;
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    private static void runPartition(LinkedListNode head, int x) {
        LinkedListNode clone01 = head.clone();
        LinkedListNode p01 = partition01(clone01, x);
        System.out.println("\tPartition: " + p01.printForward());

        LinkedListNode clone02 = head.clone();
        LinkedListNode p02 = partition02(clone02, x);
        System.out.println("\tPartition: " + p02.printForward());

        LinkedListNode clone03 = head.clone();
        LinkedListNode p03 = partition03(clone03, x);
        System.out.println("\tPartition: " + p03.printForward());
    }

    public static void main(String[] args) {
        // Sample 01
        int[] vals = {1, 3, 7, 5, 2, 9, 4};
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;

        for (int i = 1; i < vals.length; i++) {
            current = new LinkedListNode(vals[i], null, current);
        }
        System.out.println("Sample01: " + head.printForward());
        
        // Partition
        runPartition(head, 5);


        // Sample 02
        int length = 20;
        LinkedListNode[] nodes = new LinkedListNode[length];
        for (int i = 0; i < length; i++) {
            int data = i >= length / 2 ? length - i - 1 : i;
            nodes[i] = new LinkedListNode(data, null, null);
        }

        for (int i = 0; i < length; i++) {
            if (i < length - 1)
                nodes[i].setNext(nodes[i + 1]);

            if (i > 0)
                nodes[i].setPrevious(nodes[i - 1]);
        }

        LinkedListNode head2 = nodes[0];
        System.out.println("Sample02: " + head2.printForward());

        // Partition
        runPartition(head2, 5);
    }
}
