package LinkedList;

public class LinkedList {
    public static class Node {
        int data;
        Node next;

        Node() {
            data = Integer.MAX_VALUE;
            next = null;
        }
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

    void removeLast() { // O(n)
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

    void reversePI() {
        Node prev = null;
        Node curr = head;
        while(curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        Node temp = head;
        head = tail;
        tail = temp;
    }

    int kthFromLast(int k) {
        Node slow = head;
        Node fast = head;
        
        for(int i = 0; i < k; i++) fast = fast.next;

        while(fast != tail) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }

    int midOfLL() {
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
        Node one = l1.head;
        Node two = l2.head;
        Node end1 = l1.tail.next;
        Node end2 = l2.tail.next;

        LinkedList res = new LinkedList();

        while (one != end1 && two != end2) {
            if(one.data < two.data) {
                res.addLast(one.data);
                one = one.next;
            } else {
                res.addLast(two.data);
                two = two.next;
            }
        }

        while(one != end1) {
            res.addLast(one.data);
            one = one.next;
        }
        while(two != end2) {
            res.addLast(two.data);
            two = two.next;
        }

        return res;
    }

    static Node midNode(Node head, Node tail) {
        Node slow = head;
        Node fast = head;

        while(fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static LinkedList mergeSort(Node head, Node tail) {
        if(head == tail) {
            LinkedList temp = new LinkedList();
            temp.head = head;
            temp.tail = tail;
            temp.size = 1;
            return temp;
        }

        Node mid = midNode(head, tail);

        LinkedList l1 = mergeSort(head, mid);
        LinkedList l2 = mergeSort(mid.next, tail);

        return mergeTwoSortedLists(l1, l2);
    }

    void removeDuplicates() {
        LinkedList res = new LinkedList();

        while(this.size() > 0) {
            int temp = head.data;
            this.removeFirst();
            if(res.size() == 0 || res.tail.data != temp) {
                res.addLast(temp);
            }
        }

        this.head = res.head;
        this.tail = res.tail;
        this.size = res.size;
    }

    void oddEven() {
        LinkedList odd = new LinkedList();
        LinkedList even = new LinkedList();

        while(this.size() > 0) {
            int temp = head.data;
            this.removeFirst();
            if(temp % 2 == 0) {
                even.addLast(temp);
            } else {
                odd.addLast(temp);
            }
        }

        
        if(odd.size > 0 && even.size > 0) {
            odd.tail.next = even.head;
            this.head = odd.head;
            this.tail = even.tail;
            this.size = odd.size + even.size;
        } else if(odd.size == 0) {
            this.head = even.head;
            this.tail = even.tail;
            this.size = even.size;
        } else if(even.size == 0) {
            this.head = odd.head;
            this.tail = odd.tail;
            this.size = odd.size;
        }
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        // l.addLast(2);
        l.addLast(2);
        l.addLast(4);
        l.addLast(6);

        l.oddEven();
        l.display();
    }
}