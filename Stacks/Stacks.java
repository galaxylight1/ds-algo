package Stacks;
import java.util.*;

public class Stacks {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
      MinStack s = new MinStack();
    }

    public static void stackIntro(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);

        System.out.println(st);
        System.out.println(st.size());
        System.out.println(st.peek());
    }

    public static void duplicateBrackets(String[] args) {
        String inp = scn.nextLine();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < inp.length(); i++) {
            char ch = inp.charAt(i);
            if(ch == ')') {
                if(st.peek() == '(') {
                    System.out.println(true);
                    return;
                } else {
                    while(st.peek() != '(') st.pop();
                    st.pop();
                }
            } else {
                st.push(ch);
            }
        }

        System.out.println(false);
    }

    public static void balancedBrackets(String[] args) {
        String inp = scn.nextLine();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < inp.length(); i++) {
            char ch = inp.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') st.push(ch);
            else if(ch == ')') {
                if(st.peek() != '(') {
                    System.out.println(false);
                    return;
                }
                st.pop();
            } else if(ch == ']') {
                if(st.peek() != '[') {
                    System.out.println(false);
                    return;
                }
                st.pop();
            } else if(ch == '}') {
                if(st.peek() != '{') {
                    System.out.println(false);
                    return;
                }
                st.pop();
            }
        }

        System.out.println(true);
    }

    public static void nextGreaterElement(String[] args) {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) arr[i] = scn.nextInt();
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < arr.length; i++) {
            while(st.size() > 0 && arr[i] > arr[st.peek()]) {
                int idx = st.pop();
                res[idx] = arr[i]; // nge
            }
            st.push(i);
        }

        while(st.size() > 0) {
            int idx = st.pop();
            res[idx] = -1;
        }

        System.out.println(Arrays.toString(res));
    }

    public static void stockSpan(String[] args) {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) arr[i] = scn.nextInt();
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < arr.length; i++) {
            while(st.size() > 0 && arr[i] > arr[st.peek()]) {
                st.pop(); // keep removing smaller element until the last bigger element is found in history
            }
            if(st.size() == 0) {
                res[i] = i + 1; // span = idx + 1
            } else {
                res[i] = i - st.peek();
            }
            st.push(i); // add to history
        }

        System.out.println(Arrays.toString(res));
    }

    // O(1) -> constant time
    public static class MinStack {
        Stack<Integer> main;
        Stack<Integer> min;

        public MinStack() {
            main = new Stack<>();
            min = new Stack<>();
        }

        int size() {
            return main.size();
        }

        void push(int val) {
            if(size() == 0) {
                main.push(val);
                min.push(val);
            } else {
                if(val < min.peek()) {
                    min.push(val);
                } else {
                    min.push(min.peek());
                }
                main.push(val);
            }
        }

        int pop() {
            min.pop();
            return main.pop();
        }

        int top() {
            if(size() == 0) return -1;
            else return main.peek();
        }

        int min() {
            if(size() == 0) return -1;
            return min.peek();
        }
    }

    // 8
    // 17
    // 47
    // 7 + (7-8) => val + (val - min)
    // 30
    // 2 + (2-7) => -3
}
