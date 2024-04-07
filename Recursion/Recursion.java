package Recursion;
import java.util.*;

public class Recursion {
    static Scanner scn = new Scanner(System.in);

    public static void printDecreasingHelper(int n) {
        if(n == 0) return;
        System.out.println(n);
        printDecreasingHelper(n - 1);
    }

    public static void printDecreasing(String[] args) {
        int n = scn.nextInt();
        printDecreasingHelper(n);
    }

    public static void printIncreasingHelper(int n) {
        if(n == 0) return;
        printIncreasingHelper(n - 1);
        System.out.println(n);

    }

    public static void printIncreasing(String[] args) {
        int n = scn.nextInt();
        printIncreasingHelper(n);
    }

    public static void printIncreasingDecreasingHelper(int n) {
        if(n == 0) return;
        System.out.println(n);
        printIncreasingDecreasingHelper(n-1);
        System.out.println(n);
    }

    public static void printIncreasingDecreasing(String[] args) {
        int n = scn.nextInt();
        printIncreasingDecreasingHelper(n);
    }

    public static int factorialRecursive(int n) {
        if(n == 1) return 1;
        int facN1 = factorialRecursive(n-1);
        return n * facN1;
    }

    public static int powerXN(int x, int n) {
        if(n == 0) return 1;
        int temp = powerXN(x, n-1);
        return x * temp;
    }

    public static int powerLog(int x, int n) {
        if(n == 1) return x;
        int temp = powerLog(x, n / 2);
        if(n % 2 == 0) {
            return temp * temp;
        } else return x * temp * temp;
    }

    public static void eulerPath(int n) {
        if(n == 0) return;

        System.out.println("Pre" + n);
        eulerPath(n-1);
        System.out.println("In" + n);
        eulerPath(n-1);
        System.out.println("Post" + n);
    }

    public static void towerOfHanoi(int n, int d1, int d2, int d3) {
        if(n == 0) return;
        towerOfHanoi(n-1, d1, d3, d2); // smaller problem
        System.out.println(n + "[" + d1 + "->" + d2 + "]");
        towerOfHanoi(n-1, d3, d2, d1);
    }

    public static void displayArrHelper(int[] arr, int sp) {
        if(sp == arr.length) return;
        System.out.println(arr[sp]);
        displayArrHelper(arr, sp + 1);
    }

    public static void displayArr(String[] args) {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = scn.nextInt();
        displayArrHelper(arr, 0);
    }

    public static void displayArrHelperRev(int[] arr, int sp) {
        if(sp == arr.length) return;
        displayArrHelperRev(arr, sp + 1);
        System.out.println(arr[sp]);
    }

    public static void displayArrReverse(String[] args) {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = scn.nextInt();
        displayArrHelperRev(arr, 0);
    }

    public static int maxOfArray(int[] arr, int sp) {
        if(sp == arr.length) return Integer.MIN_VALUE; // if(sp == arr.length - 1) return arr[sp];
        int tempMax = maxOfArray(arr, sp + 1);
        return Math.max(tempMax, arr[sp]);
    }

    public static int firstIdxOfArray(int[] arr, int sp, int ele) {
        if(sp == arr.length) return -1;
        if(arr[sp] == ele) return sp;
        int tempIdx = firstIdxOfArray(arr, sp + 1, ele);
        return tempIdx;
    }

    public static int lastIdxOfArray(int[] arr, int sp, int ele) {
        if(sp == arr.length) return -1;
        int tempIdx = lastIdxOfArray(arr, sp + 1, ele);
        if(tempIdx == -1 && arr[sp] == ele) return sp;
        else return tempIdx;
    }

    public static int[] allIndicesInArray(int[] arr, int sp, int ele, int fsf) {
        if(sp == arr.length) {
            return new int[fsf];
        }
        if(arr[sp] == ele) {
            int[] temp = allIndicesInArray(arr, sp + 1, ele, fsf + 1);
            temp[fsf] = sp;
            return temp;
        } else {
            return allIndicesInArray(arr, sp + 1, ele, fsf);
        }
    }

    // subsquence = 2 ^ n
    // substring = n * (n + 1) / 2
    static ArrayList<String> list = new ArrayList<>();
    public static void getSubsequenceHelper(String s, int sp, String res) {
        if(sp == s.length()) {
            list.add(res);
            return;
        }
        getSubsequenceHelper(s, sp + 1, res + s.charAt(sp));
        getSubsequenceHelper(s, sp + 1, res);
    }

    public static String[] getSubsequence(String s) {
        getSubsequenceHelper(s, 0, "");
        String[] ans = new String[list.size()];
        for(int i = 0; i < list.size(); i++) ans[i] = list.get(i);
        return ans;
    }

    static String[] keypad = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };
    static ArrayList<String> list2 = new ArrayList<>();
    public static void getKeypadCombHelper(String s, int sp, String res) {
        if(sp == s.length()) {
            list2.add(res);
            return;
        }
        char ch = s.charAt(sp);
        int chInt = ch - '0';
        String temp = keypad[chInt];
        for(int i = 0; i < temp.length(); i++) {
            getKeypadCombHelper(s, sp + 1, res + temp.charAt(i));
        }
    }
    
    public static String[] getKeypadComb(String s) {
        getKeypadCombHelper(s, 0, "");
        String[] ans = new String[list2.size()];
        for(int i = 0; i < list2.size(); i++) ans[i] = list2.get(i);
        return ans;
    }

    static ArrayList<String> list3 = new ArrayList<>();
    public static void getStairsPathHelper(int n, int[] paths, String res) {
        if(n == 0) {
            list3.add(res);
            return;
        }
        for(int i = 0; i < paths.length; i++) {
            int stp = paths[i];
            if(n - stp >= 0) getStairsPathHelper(n - stp, paths, res + stp);
        }
    }

    public static String[] getStairsPath(int n, int[] paths) {
        getStairsPathHelper(n, paths, "");
        String[] ans = new String[list3.size()];
        for(int i = 0; i < list3. size(); i++) ans[i] = list3.get(i);
        return ans;
    }

    static ArrayList<String> list4 = new ArrayList<>();
    public static void getMazePathHelper(int sh, int sv, int eh, int ev, String res) {
        if(sh == eh && sv == ev) {
            list4.add(res);
            return;
        }

        for(int stp = 1; stp <= (ev - sv); stp++) { // horizontal move
            getMazePathHelper(sh, sv + stp, eh, ev, res + "h" + stp); 
        }

        for(int stp = 1; stp <= (eh - sh); stp++) { // vertical move
            getMazePathHelper(sh + stp, sv, eh, ev, res + "v" + stp); 
        }

        for(int stp = 1; stp <= (ev - sv) && stp <= (eh - sh); stp++) { // diagonal move
            getMazePathHelper(sh + stp, sv + stp, eh, ev, res + "d" + stp);
        }
    }

    public static String[] getMazePath(int n, int m) {
        getMazePathHelper(0, 0, n-1, m-1, "");
        String[] ans = new String[list4.size()];
        for(int i = 0; i < list4. size(); i++) ans[i] = list4.get(i);
        return ans;
    }
}
