package OOPS;
import java.util.*;

public class OOPS {
    public static class CustomStack {
        int[] data;
        int tos;

        public CustomStack(int cap) {
            data = new int[cap];
            tos = -1;
        }

        int size() {
            return tos + 1;
        }

        void display() {
            String res = Arrays.toString(data);
            System.out.println(res);
        }

        void push(int val) {
            if(tos == data.length - 1) {
                System.out.println("stack is full");
            } else {
                tos++;
                data[tos] = val;
            }
        }
    }

    public static void main(String[] args) {
        CustomStack s = new CustomStack(3);
        s.push(3);
        s.push(2);
        s.display();
    }
}
