package Queues;
import java.util.*;

public class Queues { // FIFO
    public static void main(String[] args) {
        CustomQueue q = new CustomQueue(4);
        q.add(3);
    }

    public static class CustomQueue { 
        int[] data;
        int front;
        int rear;
        int size;

        public CustomQueue(int size) {
            data = new int[size];
            front = -1;
            rear = -1;
            this.size = size;
        }

        void add(int val) {
            if(size == data.length) {
                int[] newData = new int[2 * data.length];
                for(int i = 0; i < size; i++) {
                    int idx = (front + i) % data.length;
                    newData[i] = data[idx];
                }
                data = newData;
                front = 0;
                rear = (front + size) % data.length; // to get the index where element can be inserted
                data[rear] = val;
                size++;
            }
            else {
                rear = (front + size) % data.length; // to get the index where element can be inserted
                data[rear] = val;
                size++;
            }
        }

        int remove() {
            if(size == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                int val = data[front];
                front = (front + 1) % data.length;
                size--;
                return val;
            }
        }

        void display() {
            for(int i = 0; i < size; i++) {
                int idx = (front + i) % data.length;
                System.out.println(data[idx]);
            }
            System.out.println();
        }

        int peek() {
            if(size == 0) {
                System.out.println("Queue underflow");
                return -1;
            }
            else return data[front];
        }
    }
}
