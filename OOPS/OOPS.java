package OOPS;
import java.util.ArrayList;

public class OOPS {
    public static class CustomStack {
        ArrayList<Integer> data;
        int tos;

        public CustomStack(int cap) {
            data = new ArrayList<>();
            tos = -1;
        }

        int size() {
            return data.size();
        }

        void display() {
            for(int i = 0; i < data.size(); i++) {
                System.out.println(data.get(i));
            }
        }

        void push(int val) {
            data.add(val);
        }

        int pop() {
            int lastIdx = data.size() - 1;
            return data.remove(lastIdx);
        }
    }

    public static void main(String[] args) {
        CustomStack s = new CustomStack(3);
        s.push(3);
        s.push(2);
        s.display();
        s.pop();
        s.display();
    }
}
