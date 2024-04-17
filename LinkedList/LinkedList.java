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

    void addAtIndex(int val, int idx) {
        // assuming idx is valid index
        if(idx == 0) {
            addFirst(val);
        } else if(idx == size) {
            addLast(val);
        } else {
            Node n = new Node();
            n.data = val;
            Node temp = new Node();
            temp = head;
            for(int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }
            n.next = temp.next;
            temp.next = n;
            size++;
        }
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

    void addFirst(int val) {
        if(size == 0) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            head = tail = temp;
        } else {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;
        }
        size++;
    }

    void removeLast() {
        if(size == 1) {
            head = tail = null;
            size = 0;
        } else {
            Node temp = head;
            for(int i = 0; i < size - 2; i++) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            size--;
        }
    }

    void removeAtIndex(int idx) {
        // assuming idx is valid
        if(size == 0) { // edge case
            head = tail = null;
            return;
        }
        if(idx == 0) {
            head = head.next;
            size--;
        } else {
            Node temp = head;
            for(int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }
            Node nextNode = temp.next;
            temp.next = nextNode.next;
            size--;
        }
    }

    private Node getNodeAt(int idx) {
        Node temp = head;
        for(int i = 0; i < idx; i++) {
            temp = temp.next;
        }

        return temp;
    }

    void reverseDI() {
        int li = 0;
        int ri = size - 1;

        while(li < ri) {
            Node left = getNodeAt(li);
            Node right = getNodeAt(ri);

            int temp = left.data;
            left.data = right.data;
            right.data = temp;

            li++;
            ri--;
        }
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.addLast(10);
        l.addLast(20);
        l.addLast(30);
        l.display();
        System.out.println();
        l.reverseDI();
        l.display();
    }
}