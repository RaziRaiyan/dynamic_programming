package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  P(n, k) = n!/(n-k)!
 *  P(n, k) = P(n-1, k) + k* P(n-1, k-1)
 */

public class PermutationCoefficient {

    static long[][] P;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        P = new long[n+1][k+1];

        System.out.println("Permutation coefficient with general method");
        long time = System.nanoTime();
        long result = permutationGeneral(n, k);
        time = System.nanoTime() - time;
        System.out.println("Permutation coefficient for n="+n+", k="+k+" is:"+result);
        System.out.println("Time taken: "+time+" nanosec");

        System.out.println("Permutation coefficient with bottom up approach");
        time = System.nanoTime();
        permutationBottomUp(n, k);
        time = System.nanoTime() - time;
        for(long[] vals: P){
            for(long val: vals){
                System.out.print(val+" ");
            }
            System.out.println();
        }
        System.out.println("Time taken:"+time+"  nanosec");

        Arrays.stream(P).forEach(a -> Arrays.fill(a, -1));

        System.out.println("Permutation coefficient with top down approach");
        time = System.nanoTime();
        permutationTopDown(n, k);
        time = System.nanoTime() - time;
        for(long[] vals: P){
            for(long val: vals){
                System.out.print(val+" ");
            }
            System.out.println();
        }
        System.out.println("Time taken:"+time+"  nanosec");
    }

    public static long permutationGeneral(int n, int k){
        long res = 1;
        for(int i=0; i<k; i++){
            res *= (n-i);
        }

        return res;
    }

    public static long permutationBottomUp(int n, int k){
        // Base case
        P[0][0] = 1;

        for(int i=1; i<=n; i++){
            P[i][0] = 1;
            for(int j=1; j<=Math.min(i,k); j++){
//                System.out.println("Currently n:"+i+",k:"+j+" calculating P(n-1, k):"+P[i-1][j]+"  k*P(n-1, k-1):"+j+"*"+P[i-1][j-1]);
                P[i][j] = P[i-1][j] + j*P[i-1][j-1];
            }
        }

        return P[n][k];
    }

    public static long permutationTopDown(int n, int k){
        // Base case



        if(k == 0){
            P[n][k] = 1;
            return 1;
        }

        if(k > n){
            P[n][k] = 0;
            return 0;
        }

        if(P[n][k] != -1){
            return P[n][k];
        }

        P[n][k] = permutationTopDown(n-1, k) + k*permutationTopDown(n-1, k-1);

        return P[n][k];
    }
}
