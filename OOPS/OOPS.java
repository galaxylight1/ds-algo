package OOPS;

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
            for(int i = 0; i <= tos; i++) {
                System.out.println(data[i]);
            }
        }

        void push(int val) {
            if(tos == data.length - 1) {
                System.out.println("stack is full");
            } else {
                tos++;
                data[tos] = val;
            }
        }

        int pop() {
            if(tos == -1) {
                System.out.println("underflow");
                return -1;
            } else {
                int temp = data[tos];
                data[tos] = -1;
                tos--;
                return temp;
            }
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
