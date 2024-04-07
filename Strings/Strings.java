package Strings;
import java.util.*;

public class Strings {
    static Scanner scn = new Scanner(System.in);

    public static void stringsIntro(String[] args) {
        String s = scn.nextLine();
        System.out.println(s);
        System.out.println(s.length());

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            System.out.println(ch);
        }

        // s.setCharAt(0) = 'z'; // won't work
        System.out.println(s.substring(0, 2));
        System.out.println(s.substring(4));

        // start point, end point
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j <= s.length(); j++) {
                System.out.println(s.substring(i, j));
            }
        }

        String s1 = "hello";
        String s2 = "world";
        String s3 = s1 + s2;
        System.out.println(s3);
        
        String s4 = "abc def ghi";
        String[] parts = s4.split(" ");
        for(int i = 0; i < parts.length; i++) {
            System.out.println(parts[i]);
        }

        /*
        * Memory
        * Interning
        * New
        * Immutability
        * Performance
        * Equal & ==
        */

        String s5 = "hello";
        String s6 = "hello";
        String s7 = new String("hello"); // no interning

        // .equals, not ==
        
        StringBuilder sb = new StringBuilder("hello");
        System.out.println(sb);
        char ch = sb.charAt(0);
        sb.setCharAt(0, 'd');
        System.out.println(ch + " " + sb);

        sb.insert(2, 'y');
        sb.deleteCharAt(2);
        sb.append('g');
        System.out.println(sb.length());
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i <= j) { // two pointer
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);

            if(ch1 != ch2) return false;
            else {
                i++;
                j--;
            }
        }

        return true;
    }

    public static void palindromeSubstrings(String[] args) {
        String s = scn.nextLine();

        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j <= s.length(); j++) {
                String ss = s.substring(i, j);
                if(isPalindrome(ss)) {
                    System.out.println(ss);
                }
            }
        }
    }

    public static void stringCompression1(String[] args) {
        String s = scn.nextLine();
        StringBuilder sb = new StringBuilder(s.charAt(0) + "");
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(i-1)) {
                sb.append(s.charAt(i));
            }
        }

        System.out.println(sb);
    }
    
    public static void stringCompression2(String[] args) {
        String s = scn.nextLine();
        StringBuilder sb = new StringBuilder(s.charAt(0) + "");
        int count = 1;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(i-1)) {
                if(count == 1) sb.append(s.charAt(i));
                else sb.append(count + "" + s.charAt(i));
                count = 1; // reset
            } else {
                count++;
            }
        }

        System.out.println(sb);
    }

    public static void toggleCaseOfCharacters(String[] args) {
        String s = scn.nextLine();
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z') { // ascii
                char upperChar = (char)(ch - 'a' + 'A');
                sb.append(upperChar + "");
            } else {
                char lowerChar = (char)(ch + 'a' - 'A');
                sb.append(lowerChar + "");
            }
        }

        System.out.println(sb);
    }

    public static void stringWithASCIIDifference(String[] args) {
        String s = scn.nextLine();
        StringBuilder sb = new StringBuilder(s.charAt(0) + "");
        for(int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            char prev_ch = s.charAt(i-1);
            sb.append(ch - prev_ch);
            sb.append(ch);
        }

        System.out.println(sb);
    }

    public static int factorial(int n) {
        int val = 1;
        for(int i = 2; i <= n; i++) val *= i;
        return val;
    }

    public static void permutationsOfString(String[] args) { // iterative
        String s = scn.nextLine();
        int f = factorial(s.length());

        for(int i = 0; i < f; i++) {
            StringBuilder sb = new StringBuilder(s);
            int temp = i;
            for(int j = s.length(); j >= 1; j--) {
                int q = temp / j;
                int r = temp % j;

                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);

                temp = q;
            }
            System.out.println();
        }
    }
}
