package com.java_concepts.datastructures;

public class DoublyLinkedList {

    Node head;

    private class Node {

        int data;
        Node prev = null;
        Node next = null;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dList = new DoublyLinkedList();

        dList.push(10);
        dList.push(20);
        dList.push(30);
        dList.printList();

        dList.append(80);
        dList.append(100);
        dList.printList();
        
        dList.insertAfter(80,90);
        dList.printList();
        
        dList.delete(80);
        dList.delete(100);
        dList.printList();
    }

    private void push(int data) {

        Node node = new Node(data);

        if (head == null) {
            head = node;
            return;
        }

        node.next = head;
        head.prev = node;
        head = node;
    }

    private void insertAfter(int prev_data, int data) {
        Node node = new Node(data);

        Node i = head;
        while (i != null && i.data != prev_data) {
            i = i.next;
        }

        if (i == null) {
            System.out.println("\n Prev_data not found for insertAfter");
            return;
        }
        
        node.next = i.next;
        (i.next).prev = node;
        
        node.prev = i;
        i.next = node;
    }
    
    private void delete(int data){
    
        if(head.data == data){
            head = head.next;
            head.prev = null;
            return;
        }
        
        Node i = head;
        while(i != null && i.data != data){
            i = i.next;
        }
        
        if (i == null) {
            System.out.println("\n Data not found for deletion");
            return;
        }
        
        if(i.next != null){
            (i.prev).next = i.next;
            (i.next).prev = i.prev;
        } else {
            (i.prev).next = null;
        }
    }

    private void append(int data) {
        Node node = new Node(data);

        Node i = head;
        while (i.next != null) {
            i = i.next;
        }

        i.next = node;
        node.prev = i;
    }

    private void printList() {
        Node i = head;
        System.out.println("\nHead is " + head.data + " ,Data is - ");

        while (i != null) {
            System.out.print(i.data + " ");
            i = i.next;
        }
    }
}
