package Queues;
import java.util.*;

public class Queues {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(10);
        System.out.println(q);
        q.add(20);
        System.out.println(q);
        q.add(30);
        q.remove();
        System.out.println(q);
    }
}
