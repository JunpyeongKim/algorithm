package ch02linkedlist;

import lib.AssortedMethods;
import lib.LinkedListNode;

/**
 * 2.3 단방향 연결리스트 중간에 있는 노드 하나를 삭제하는 알고리즘을 구현하라.
 *     삭제할 노드에 대한 접근만 가능하다는 것에 유의하자.
 *
 *     - 예
 *          입력: 연결 리스트 a->b->c->d->e 의 노드 c
 *          출력: 아무것도 반환할 필요없고, 결과로 연결리스트 a->b->d->e 가 되어 있으면 OK
 *
 * 2.3 (5E)
 *      Implement an algorithm to delete a node in the middle (Le., any node but the first and last node,
 *      not necessarily the exact middle) of a singly linked list, given only access to that node.
 *
 *      EXAMPLE:
 *          Input: the node ‘c’ from the linked list a->b->c->d->e
 *          Result: nothing is returned, but the new linked list looks like a->b->d->e
 *
 * 2.3 (6E) Delete Middle Node:
 *      Implement an algorithm to delete a node in the middle (Le., any node but the first and last node,
 *      not necessarily the exact middle) of a singly linked list, given only access to that node.
 *
 *      EXAMPLE:
 *          Input: the node ‘c’ from the linked list a->b->c->d->e->f
 *          Result: nothing is returned, but the new linked list looks like a->b->d->e->f
 */
public class Question03 {
    public static boolean deleteNode(LinkedListNode node) {
        // NOTE:
        //  if the node to be deleted is the last node in the linked list,
        //  you could consider marking it as dummy in that case.
        if (node == null || node.next == null)
            return false;

        LinkedListNode next = node.next;
        node.data = next.data;
        node.next = next.next;

        return true;
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        System.out.println(head.printForward());

        deleteNode(head.next.next.next);   // the 4th node
        System.out.println(head.printForward());
    }
}
