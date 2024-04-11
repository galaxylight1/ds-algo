package LinkedList;
import java.util.*;

public class LinkedList {
    public static class Node {
        int data;
        Node next;
    }

    Node head;
    Node tail;
    int size;

    public LinkedList() {
        head = tail = null;
        size = 0;
    }

    void addLast(int val) {
        Node temp = new Node();
        temp.data = val;
        temp.next = null;
        if(size == 0) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.addLast(20);
        l.addLast(50);
        System.out.println(l.head.data);
    }
}