import java.util.*;

public class ds {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        String[] output = getKeypadComb("573");
        System.out.println(Arrays.toString(output));
    }

    public static void primeOrNonPrime(String[] args) {
        int t = scn.nextInt();
        String[] res = new String[t];

        for(int i = 0; i < t; i++) {
            int n = scn.nextInt();

            int count = 0;
            for(int div = 1; div <= n; div++) { // computing
                if(n % div == 0) count++;
            }

            if(count == 2) {
                res[i] = "prime";
            } else {
                res[i] = "not prime";
            }
        }

        System.out.println("## -> " + (Arrays.toString(res)).getClass());
        scn.close();
    }

    public static void printAllNumbersTillN(String[] args) {
        int low = scn.nextInt();
        int high = scn.nextInt();

        for(int n = low; n <= high; n++) {
            boolean flag = false;
            for(int div = 2; div * div <= n; div++) {
                if(n % div == 0) {
                    flag = true;
                    break;
                }
            }

            if(!flag) System.out.println("## -> " + n);
        }
    }

    public static void fibonnaciNumbers(String[] args) {
        int n = scn.nextInt();

        int a = 0;
        int b = 1;

        int fib = 0;
        System.out.println(a + "\n" + b);
        while(fib < n) {
            fib = a + b;
            System.out.println(fib);           
            a = b;
            b = fib; 
        }
    }

    public static void countDigits(String[] args) {
        int n = scn.nextInt();

        int count = 0;
        int tempNo = n;
        while(tempNo != 0) {
            tempNo = tempNo / 10;
            count++;
        }

        System.out.println("## -> " + count);
    }


    public static void printDigits(String[] args) {
        int n = scn.nextInt();

        int tempNo = n;
        while(tempNo != 0) {
            int rem = tempNo % 10;
            System.out.println("## -> " + rem);
            tempNo = tempNo / 10;
        }
    }

    public static void reverseNumber(String[] args) {
        int n = scn.nextInt();
        int res = 0;
        int placeValue = 0;

        int tempNo1 = n;
        while(tempNo1 != 0) {
            placeValue++;
            tempNo1 = tempNo1 / 10;
        }

        int tempNo2 = n;
        while(tempNo2 != 0) {
            int lastDig = tempNo2 % 10;
            res = res + lastDig * (int) Math.pow(10, placeValue - 1);
            placeValue--;
            tempNo2 = tempNo2 / 10;
        } 

        System.out.println("## -> " + res);
    }

    public static void inverseNumber(String[] args) {
        int n = scn.nextInt();
        int res = 0;

        int placeValue = 1;
        int tempNo = n;
        while(tempNo != 0) {
            int lastDig = tempNo % 10;
            res += placeValue * (int) Math.pow(10, lastDig - 1);
            placeValue++;
            tempNo = tempNo / 10;
        }

        System.out.println("## res -> " + res);
    }

    public static void rotateNumber(String[] args) {
        int n = scn.nextInt();
        int r = scn.nextInt();

        int totalLen = 0;
        int tempNo = n;
        while(tempNo != 0) {
            totalLen++;
            tempNo = tempNo / 10;
        }

        r = r % totalLen;
        if(r < 0) {
            r += totalLen;
        }
        
        int fac = (int) Math.pow(10, r);
        int rem = n % fac;
        int quo = n / fac;
        int res = rem * (int) Math.pow(10, totalLen - r) + quo;
        System.out.println("## res -> " + res);
    }

    public static void gcdAndLcm(String[] args) {
        int a = scn.nextInt();
        int b = scn.nextInt();
        int tempA = a;
        int tempB = b;

        while(a % b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }

        System.out.println("## gcd -> " + b);

        int lcm = (tempA * tempB) / b;
        System.out.println("## lcm -> " + lcm);
    }

    public static void primeFactors(String[] args) {
        int n = scn.nextInt();

        int pf = 2;
        int tempN = n;
        while(n != 1 && pf * pf <= tempN) {
            boolean flag = false;
            while(n % pf == 0) {
                flag = true;
                n = n / pf;
            }
            
            if(flag) System.out.println(pf);
            pf++;
        }
        
        if(n != 1) {
            System.out.println(n);
        }
    }

    public static void pythagoreanTriplets(String[] args) {
        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();
        
        boolean flag = false;

        // find greatest of 3 no's
        int max = a;
        if(b >= max) max = b;
        if(c >= max) max = c;

        if(max == a) {
            flag = ((b * b + c * c) == (a * a));
        }
        else if(max == b) {
            flag = ((a * a + c * c) == (b * b));
        }
        else if(max == c) {
            flag = ((b * b + a * a) == (c * c));
        }

        System.out.println(flag);
    }

    public static void benjaminBulbs(String[] args) {
        int n = scn.nextInt();

        int count = 0;
        for(int i = 1; i <= n; i++) {
            double sqrt = Math.sqrt(i);
            if(sqrt % 1 == 0) count++;
        }

        System.out.println("### bulbs -> " + count);
    }

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
        // TODO
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

    public static boolean isPrime(int n) {
        for(int div = 2; div * div <= n; div++) {
            if(n % div == 0) return false;
        }

        return true;
    }

    public static void removePrimeFromArrayList(String[] args) {
        int n = scn.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) arr.add(scn.nextInt());

        for(int i = arr.size() - 1; i >= 0; i--) {
            if(isPrime(arr.get(i))) arr.remove(i);
        }

        System.out.println(arr);
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
}