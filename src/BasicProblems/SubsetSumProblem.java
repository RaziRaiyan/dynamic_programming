package BasicProblems;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Given a set of non-negative integers, and a value sum,
 * determine if there is a subset of the given set with sum equal to given sum.
 *
 *
 */

public class SubsetSumProblem {

    static int arr[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        int total = scanner.nextInt();

        System.out.println(isSubsetSumExists(arr, total, n));

    }

    public static boolean isSubsetSumExists(int[] arr, int reqSum, int n){
        // Base case
        if(reqSum == 0)
            return true;
        if(n == 0)
            return false;

        return isSubsetSumExists(arr, reqSum-arr[n-1], n-1) || isSubsetSumExists(arr, reqSum, n-1);
    }

    public static boolean isSubsetSumExistsBottomUp(int arr[], int sum){
        boolean[][] dp = new boolean[arr.length+1][sum + 1];

        // Base case
        dp[0][0] = true;

        for(int i=1; i<=arr.length; i++){
            for(int j=1; j<=sum ; j++){
                if(arr[i-1] < j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }

        return dp[arr.length][sum];
    }

}
