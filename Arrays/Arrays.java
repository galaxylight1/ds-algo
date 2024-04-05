package Arrays;

import java.util.*;

public class Arrays {
    static Scanner scn = new Scanner(System.in);

    public static void arrayIntro(String[] args) {
        int[] arr;
        arr = new int[3];
        arr[0] = 1;
        arr[1] = 23;
        arr[2] = 15;

        // memory management, deep copy, shallow copy, performance
        int[] one = new int[3];
        one[0] = 10;
        one[1] = 20;
        one[2] = 30;
    }

    public static void spanOfArray(String[] args) {
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int max = arr[0];
        int min = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
            if(arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println(max - min);
    }

    public static void barChart(String[] args) {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) arr[i] = scn.nextInt();

        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        for(int i = max; i >= 1; i--) {
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] >= i) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void sumOfTwoArrays(String[] args) {
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        for(int i = 0; i < arr1.length; i++) arr1[i] = scn.nextInt();
        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        for(int j = 0; j < arr2.length; j++) arr2[j] = scn.nextInt();

        int[] res = new int[Math.max(n1, n2) + 1];

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = res.length - 1;
        int carry = 0;
        while(i >= 0 && j >= 0) {
            res[k] = carry + (arr1[i] + arr2[j]);

            if(res[k] > 9) { // split it
                carry = res[k] / 10;
                res[k] = res[k] % 10;
            } else carry = 0;

            i--;
            j--;
            k--;
        }

        while(i >= 0) {
            res[k] = carry + arr1[i];
            if(res[k] > 9) {
                carry = res[k] / 10;
                res[k] = res[k] % 10;
            } else carry = 0;
            i--;
            k--;
        }
        while(j >= 0) {
            res[k] = carry + arr2[j];
            if(res[k] > 9) {
                carry = res[k] / 10;
                res[k] = res[k] % 10;
            } else carry = 0;
            j--;
            k--;
        }
        if(carry > 0) res[k] = carry;

        System.out.println("## res -> " + Arrays.toString(res));
    }

    public static void diffOfArrays(String[] args) {
}
