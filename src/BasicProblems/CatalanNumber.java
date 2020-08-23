package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * C0 = 1
 * Cn+1 = Summation(i->0 to n)CiCn-i
 *
 * Catalan numbers are a sequence of natural numbers that occurs in many interesting counting problems like following.
 * 1) Count the number of expressions containing n pairs of parentheses which are correctly matched. For n = 3,
 *    possible expressions are ((())), ()(()), ()()(), (())(), (()()).
 *
 * 2) Count the number of possible Binary Search Trees with n keys (See this)
 *
 * 3) Count the number of full binary trees (A rooted binary tree is full if every vertex has either two children
 *    or no children) with n+1 leaves.
 *
 * 4) Given a number n, return the number of ways you can draw n chords in a circle with 2 x n points such
 *    that no 2 chords intersect.
 */

public class CatalanNumber {

    static int[] catalan;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        catalan = new int[n+1];
//        Arrays.fill(catalan, -1);
//        System.out.println(n+"th catalan number is: "+bottomUp(n));
        long time = System.nanoTime();
        bottomUp(n);
        time = System.nanoTime()-time;
        System.out.println("Catalan via bottomUp approach");
        for(int k: catalan){
            System.out.print(k+" ");
        }
        System.out.println("\nTime taken: "+time+" nanosec");

        Arrays.fill(catalan, 0);
        System.out.println("\n\nCatalan via topDown approach");
        time = System.nanoTime();
        topDownCatalan(n);
        time = System.nanoTime() - time;
        for(int k: catalan){
            System.out.print(k+" ");
        }
        System.out.println("\nTime taken: "+time+" nanosec");

        System.out.println("Catalan Number by using Binomial coefficient");
        /*
            C(n) = (2n n)*1/(n+1)
         */


    }

    public static  int catalanByBinomial(int n){
        return binomial(2*n, n)/ (n+1);
    }

    public static int binomial(int n, int k){
        int res = 1;
        if(k > n - k){
            k = n-k;
        }

        for(int i=0;i<k;i++){
            res *= (n-i);
            res /= (i+1);
        }

        return res;
    }

    public static int bottomUp(int n){
        catalan[0] = 1;
        catalan[1] = 1;
        for(int i=2;i<=n;i++){
            catalan[i] = 0;
            for(int j=0;j<i;j++){
                catalan[i] += catalan[j]*catalan[i-j-1];
            }
        }
        return catalan[n];
    }

    public static int topDownCatalan(int n){
        if(n <= 1)
            return 1;

        if(catalan[n] != 0)
            return catalan[n];

        for(int i=2; i<=n; i++){
            catalan[i] = 0;
            for(int j=0; j<i; j++){
                catalan[i] += topDownCatalan(j) * topDownCatalan(i-j-1);
            }
        }

        return catalan[n];
    }
}
