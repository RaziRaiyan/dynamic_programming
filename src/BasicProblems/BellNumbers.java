package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Bell(n) = Summation(k-> 0 to n) S(n,k)
 * S(n+1, k) = k*S(n, k) + S(n, k-1)
 * S(n, k) is stirling numbers of second kind
 * It could be used to find Number of ways to Partition a Set
 *
 * Use Bell Triangle
 * 1
 * 1 2
 * 2 3 5
 * 5 7 10 15
 * 5 20 7 37 52
 */

public class BellNumbers {

    static long[][] Bell;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Bell = new long[n+1][n+1];

        System.out.println("Bell Number using Bottom Up approach");
        long time = System.nanoTime();
        BellBottomUp(n);
        time = System.nanoTime() - time;
        for(long[] vals : Bell){
            for(long val: vals){
                System.out.print(val+" ");
            }
            System.out.println();
        }
        System.out.println("Time taken: "+time+" nanosec\n\n");

        Arrays.stream(Bell).forEach(a -> Arrays.fill(a, -1));

        System.out.println("Bell Number using top down approach");
        time = System.nanoTime();
        BellTopDown(n);
        time = System.nanoTime() - time;
        for(long[] vals : Bell){
            for(long val: vals){
                System.out.print(val+" ");
            }
            System.out.println();
        }
        System.out.println("Time taken: "+time+" nanosec\n\n");
    }

    static long BellBottomUp(int n){
        Bell[0][0] = 1;
        for(int i=1; i<=n; i++) {
            // This is first column
            Bell[i][0] = Bell[i - 1][i - 1];
            // For others sum up previous element and element just above previous element
            for (int j = 1; j <= i; j++) {
                Bell[i][j] = Bell[i][j - 1] + Bell[i - 1][j - 1];
            }
        }
        return Bell[n][n];
    }


    static long BellTopDown(int n){
        // Base case
        return BellTopDownHelper(n, n);
    }

    static long BellTopDownHelper(int n, int k){
        // Base case
//        System.out.println("======================================");
//        System.out.println("New recursion  n:"+n+" "+" k:"+k+", ");


        if(n == 0 && k ==0 ){
//            System.out.println("Encountered Base case");
            Bell[0][0] = 1;
            return 1;
        }

//        System.out.println("_____");

        if(Bell[n][k] != -1){
            return Bell[n][k];
        }


        if(k == 0){
//            System.out.println("At start of column");
            Bell[n][k] = BellTopDownHelper(n-1, n-1);
            return Bell[n][k];
        }

//        System.out.println("Currently n:"+n+", k:"+k+"   Calling for: n:"+(n-1)+", k:"+(k-1)+"  and  "+"n:"+n+", k:"+(k-1));
        Bell[n][k] = BellTopDownHelper(n-1, k-1)+ BellTopDownHelper(n, k-1);

        return Bell[n][k];
    }

}
