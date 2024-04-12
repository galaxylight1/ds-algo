package LinkedList;

public class LinkedList {
    public static class Node {
        int data;
        Node next;
    }

    Node head;
    Node tail;
    int size;

    LinkedList() {
        head = tail = null;
        size = 0;
    }

    int size() {
        return size;
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

    void display() {
        Node temp = new Node();
        temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    void removeFirst() {
        if(size == 1) {
            head = null;
            tail = null;
        } else {
            Node temp = head;
            head = head.next;
            temp.next = null;
        }
        size--;
    }

    int getAt(int idx) {
        if(size == 0) return -1;
        else {
            // assuming idx is a valid index
            Node temp = head;
            for(int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp.data;
        }
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.addLast(20);
        l.addLast(50);
        l.addLast(70);
        System.out.println(l.head.data);
        System.out.println(l.size());
        l.display();
        System.out.println(l.getAt(2));
    }
}