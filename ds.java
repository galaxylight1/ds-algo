import java.util.*;

public class ds {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        benjaminBulbs(args);
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
}