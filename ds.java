import java.util.*;

public class ds {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int[] inp = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = constructGenericTree(inp);
        traversalGenericTree(root);
    }

    public static void arrays2D(String[] args) {
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) System.out.println(arr[i][j]);
        }
    }

    public static void matrixMultiplication(String[] args) {
        int n1 = scn.nextInt();
        int m1 = scn.nextInt();
        int[][] one = new int[n1][m1];
        for(int i = 0; i < n1; i++) {
            for(int j = 0; j < one[i].length; j++) one[i][j] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int m2 = scn.nextInt();
        int[][] two = new int[n2][m2];
        for(int i = 0; i < n2; i++) {
            for(int j = 0; j < two[i].length; j++) two[i][j] = scn.nextInt();
        }

        if(m1 != n2) return;

        int[][] res = new int[n1][m2];
        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[i].length; j++) {
                for(int k = 0; k < m1; k++) {
                    res[i][j] += one[i][k] * two[k][j];
                }
            }
        }
        
        for(int i = 0; i < res.length; i++) {
            int[] temp = res[i];
            System.out.println(Arrays.toString(temp));
        }
    }

    public static void waveTraversal(int[][] arr) {
        boolean flag = false;
        for(int i = 0; i < arr.length; i++) {
            flag = !flag;
            if(flag) {
                for(int j = 0; j < arr[i].length; j++) {
                    System.out.println(arr[j][i]); // vertical
                }
            } else {
                for(int j = arr[i].length - 1; j >= 0; j--) {
                    System.out.println(arr[j][i]);
                }
            }
        }
    }

    public static void spiralTraversal(int[][] arr) {
        int minR = 0;
        int minC = 0;
        int maxR = arr.length - 1;
        int maxC = arr[0].length - 1;

        while(maxR >= minR && maxC >= minC) {
            for(int i = minR; i <= maxR; i++) {
                System.out.println(arr[i][minC]);
            }

            for(int i = minC + 1; i <= maxC; i++) {
                System.out.println(arr[maxR][i]);
            }

            for(int i = maxR - 1; i >= minR; i--) {
                System.out.println(arr[i][maxC]);
            }

            for(int i = maxC - 1; i > minC; i--) {
                System.out.println(arr[minR][i]);
            }
            minR++;
            minC++;
            maxR--;
            maxC--;
        }
    }

    public static void exitPointOfMatrix(int[][] arr) {
        int dir = 3; // initial moving direction, to east
        int i = 0;
        int j = 0;
        int count = 0;
        while(i >= 0 && i < arr.length && j >= 0 && j < arr[0].length) {
            int ele = arr[i][j];
            switch(dir) {
                case 1: // west
                    if(ele == 1) {
                        dir = 2;
                        i--;
                        count++;
                    }
                    else j--;
                    break;
                case 2: // north
                    if(ele == 1) {
                        dir = 3;
                        j++;
                        count++;
                    }
                    else i--;
                    break;
                case 3: // east
                    if(ele == 1) {
                        dir = 4;
                        i++;
                        count++;
                    }
                    else j++;
                    break;
                case 4: // south
                    if(ele == 1) {
                        dir = 1;
                        j--;
                        count++;
                    }
                    else i++;
                    break;
            }
        }

        // adjustment
        if(i < 0) i = 0;
        if(j < 0) j = 0;
        if(i > arr.length - 1) i--;
        if(j > arr[0].length - 1) j--;

        System.out.println("Turns -> " + count);
        System.out.println("Exit point -> " + i + ", " + j);
    }

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node constructGenericTree(int[] inp) {
        Node root = null; // pointer
        Stack<Node> st = new Stack<>();
        for(int i = 0; i < inp.length; i++) {
            if(inp[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = inp[i];
                if(st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }
                st.push(t);
            }
        }

        return root;
    }

    public static void displayGenericTree(Node root) {
        String s = root.data + " -> ";
        for(Node child : root.children) {
            s += child.data + ", ";
        }
        System.out.println(s);

        for(Node child : root.children) {
            displayGenericTree(child);
        }
    }

    public static int sizeOfGenericTree(Node root) {
        int size = 0;

        for(Node child : root.children) {
            size += sizeOfGenericTree(child);
        }

        return size + 1;
    }

    public static int maxOfGenericTree(Node root) {
        int max = root.data;
        for(Node child : root.children) {
            int tempMax = maxOfGenericTree(child);
            max = Integer.max(tempMax, max);
        }
        return max;
    }

    public static int heightOfGenericTree(Node root) {
        int maxHeight = -1;
        for(Node child: root.children) {
            int tempHeight = heightOfGenericTree(child);
            maxHeight = Integer.max(tempHeight, maxHeight);
        }

        return maxHeight + 1;
    }

    public static void traversalGenericTree(Node root) {
        System.out.println("Node Pre " + root.data);
        for(Node child : root.children) {
            System.out.println("Edge Pre " + root.data + " -- " + child.data);
            traversalGenericTree(child);
            System.out.println("Edge Post " + root.data + " -- " + child.data);
        }
        System.out.println("Node Post " + root.data);
    }

    public static void levelOrderTraversalGenericTree(Node root) {
        
    }
}