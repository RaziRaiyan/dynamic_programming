package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which
 * is the amount of gold in tons. Initially the miner is at first column but can be at any row.
 * He can move only (right->,right up /,right down\) that is from a given cell, the miner can move
 * to the cell diagonally up towards the right or right or diagonally down towards the right.
 * Find out maximum amount of gold he can collect.
 */

public class GoldMineProblem {

    static int[][] golds;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        golds = new int[n][m];
        dp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m;j++){
                golds[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Gold Mining by bottoms up approach");
        long time = System.nanoTime();
        int globalMaxima = goldMineBottomUp();
        time = System.nanoTime() - time;
        Arrays.stream(dp).forEach(row -> {
            Arrays.stream(row).forEach(element -> System.out.print(element+" "));
            System.out.println();
        });
        System.out.println("Maximum golds that can be collected: "+globalMaxima);
        System.out.println("Time taken: "+time+" namosec");

        globalMaxima = Integer.MIN_VALUE;
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

        System.out.println("Gold Mining problem by top down approach");
        time = System.nanoTime();
        globalMaxima = goldMiningTopDown();
        time = System.nanoTime() - time;
        Arrays.stream(dp).forEach(row -> {
            Arrays.stream(row).forEach(element -> System.out.print(element+" "));
            System.out.println();
        });
        System.out.println("Maximum golds that can be collected: "+globalMaxima);
        System.out.println("Time taken: "+time+" namosec");
    }

    public static int goldMineBottomUp(){
        int globalMaxima = Integer.MIN_VALUE;

        // Handling first column of each row
        // This is also the base case
        for(int i=0; i<golds.length;i++){
            dp[i][0] = golds[i][0];
            globalMaxima = Math.max(globalMaxima, dp[i][0]);
        }

        for(int j=1; j<golds[0].length; j++){
            for(int i=0; i<golds.length; i++){
                // first row
                if(i == 0){
                    dp[i][j] = golds[i][j]+Math.max(dp[i][j-1], dp[i+1][j-1]);
                    globalMaxima = Math.max(globalMaxima, dp[i][j]);
                    continue;
                }

                // last row
                if(i == golds.length-1){
                    dp[i][j] = golds[i][j]+Math.max(dp[i-1][j-1], dp[i][j-1]);
                    globalMaxima = Math.max(globalMaxima, dp[i][j]);
                    continue;
                }

                // Elsewhere
                dp[i][j] = golds[i][j] + Math.max(dp[i-1][j-1], Math.max(dp[i][j-1], dp[i+1][j-1]));
                globalMaxima = Math.max(globalMaxima, dp[i][j]);
            }
        }

        return globalMaxima;
    }

    public static int goldMiningTopDown(){

        int globalMaxima = Integer.MIN_VALUE;

        for(int i=0; i<golds.length; i++){
            globalMaxima = Math.max(globalMaxima, goldMiningTopDownHelper(i, golds[0].length-1, Integer.MIN_VALUE));
        }

        return globalMaxima;
    }

    public static int goldMiningTopDownHelper(int i, int j, int max){
        // Base case: First column
        if(j == 0){
            dp[i][j] = golds[i][j];
            max = Math.max(dp[i][j], max);
            return dp[i][j];
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        // First row
        if(i == 0){
            dp[i][j] = golds[i][j]+Math.max(goldMiningTopDownHelper(i, j-1, max), goldMiningTopDownHelper(i+1, j-1, max));
            max = Math.max(dp[i][j], max);
            return dp[i][j];
        }

        // last row
        if(i == golds.length-1){
            dp[i][j] = golds[i][j]+Math.max(goldMiningTopDownHelper(i-1, j-1, max), goldMiningTopDownHelper(i, j-1, max));
            max = Math.max(dp[i][j], max);
            return dp[i][j];
        }


        dp[i][j] = golds[i][j] + Math.max(goldMiningTopDownHelper(i-1, j-1, max),
                Math.max(goldMiningTopDownHelper(i, j-1, max), goldMiningTopDownHelper(i+1, j-1, max)));

        max = Math.max(dp[i][j], max);
        return max;
    }
}
