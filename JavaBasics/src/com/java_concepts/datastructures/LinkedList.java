package com.java_concepts.datastructures;

public class LinkedList {

    Node head, tail;
    int size = 0;

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        LinkedList llist = new LinkedList();

        llist.push(10);
        llist.append(20);
        llist.append(30);
        llist.append(40);
        llist.append(50);
        llist.push(30);
        llist.push(50);
        llist.printList();

        llist.insertAfter(10, 13);
        llist.printList();

        llist.deleteNode(10);
        llist.printList();

        llist.displaySize();

        /*LinkedList llist2 = new LinkedList();
        llist2.push(5);
        llist2.append(15);
        llist2.append(25);
        llist2.printList();
        
        
        Node node = iterativeSortedMerge(llist.head, llist2.head);
        System.out.print("\n");
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }*/
        //llist.reverse();
    }

    private void reverse() {
        Node node = reverseIteravtively(head);
        Node i = node;
        System.out.println("\nReverse List Is - ");
        while (i != null) {
            System.out.print(i.data + " ");
            i = i.next;
        }
    }

    private Node reverseIteravtively(Node head) {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    private static Node iterativeSortedMerge(Node node1, Node node2) {
        Node result = null;

        if (node1 == null) {
            return node2;
        } else if (node2 == null) {
            return node1;
        }

        if (node1.data < node2.data) {
            result = node1;
            result.next = iterativeSortedMerge(node1.next, node2);
        } else if (node2.data < node1.data) {
            result = node2;
            result.next = iterativeSortedMerge(node2.next, node1);
        }

        return result;
    }

    private void displaySize() {
        System.out.println("\nSize of Linked List is " + getSize(head));
    }

    private void deleteNode(int node_data) {

        Node current = null, next = head;

        if (head != null && head.data == node_data) {
            head = head.next;
            return;
        }

        while (next != null && next.data != node_data) {
            current = next;
            next = next.next;
        }

        if (next == null) {
            return;
        }

        current.next = next.next;
    }

    private void insertAfter(int prev_data, int data) {

        if (prev_data == 0) {
            return;
        }

        Node new_node = new Node(data);
        Node i = head;

        while (i.data != prev_data) {
            i = i.next;
        }

        if (i == null) {
            return;
        }

        new_node.next = i.next;
        i.next = new_node;

    }

    private int getSize(Node node) {

        if (node == null) {
            return 0;
        }

        return 1 + getSize(node.next);
    }

    private void push(int data) {
        Node new_node = new Node(data);
        new_node.next = head;

        if (tail == null) {
            tail = new_node;
        }

        head = new_node;
    }

    private void append(int data) {
        Node new_node = new Node(data);

        tail.next = new_node;
        tail = new_node;
    }

    private void printList() {
        Node i = head;
        System.out.println("\nHead is " + head.data + " ,Tail is " + tail.data + " ,Data is - ");
        while (i != null) {
            System.out.print(i.data + " ");
            i = i.next;
        }
    }

}
