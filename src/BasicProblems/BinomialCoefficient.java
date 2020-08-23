package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The value of C(n, k) can be recursively calculated using following standard formula for Binomial Coefficients.
 * C(n, k) = C(n-1, k-1) + C(n-1, k)
 * C(n, 0) = C(n, n) = 1
 * Also C(n, k) = n!/(k! . (n-k)! )
 */

public class BinomialCoefficient {

    static long[][] binomial;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        binomial = new long[n+1][k+1];
//        System.out.println(binomialBottomUp(n, k));
        System.out.println("Binomial Coefficient bottom up approach");
        long time = System.nanoTime();
        binomialBottomUp(n, k);
        time = System.nanoTime() - time;
        for(long[] vals: binomial){
            for(long val: vals){
                System.out.print(val+" ");
            }
            System.out.println();
        }
        System.out.println("Time Taken in bottom up approach: "+ time);
        System.out.println("Binomial coefficient of ("+n+","+k+")"+" is: "+binomial[n][k]);

        System.out.println("\n\nBinomial Coefficient top down approach");
        Arrays.stream(binomial).forEach(a -> Arrays.fill(a, 0));
        time = System.nanoTime();
        binomialTopDown(n, k);
        time = System.nanoTime() - time;
        for(long[] vals: binomial){
            for(long val: vals){
                System.out.print(val+" ");
            }
            System.out.println();
        }
        System.out.println("Binomial coefficient of ("+n+","+k+")"+" is: "+binomial[n][k]);
        System.out.println("Time taken in top down approach: "+time);

        System.out.println("\n\nBinomial Coefficient by normal method");
        System.out.println(binomial(n, k));
    }

    public static long binomial(int n, int k){
        long res = 1;
        if(k > n - k){
            k = n-k;
        }

        for(int i=0;i<k;i++){
            res *= (n-i);
            res /= (i+1);
        }

        return res;
    }

    public static long binomialBottomUp(int n, int k){

        for(int i=0;i<=n;i++){
            for (int j=0;j<=Math.min(i, k);j++){
                if(j == 0 || j == i){
                    binomial[i][j] = 1;
                }else{
                    binomial[i][j] = binomial[i-1][j-1] + binomial[i-1][j];
                }
            }
        }

        return binomial[n][k];
    }

    public static long binomialTopDown(int n, int k){
        if( k ==0  || n==k){
            binomial[n][k] = 1;
            return 1;
        }

        if(binomial[n][k] != 0)
            return binomial[n][k];

        binomial[n][k] =  binomialTopDown(n-1, k-1) + binomialTopDown(n-1, k);
        return binomial[n][k];
    }
}
