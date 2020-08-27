package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an array of n integers. The problem is to find maximum length of the subsequence with difference between
 * adjacent elements as either 0 or 1.
 */

public class MaxLenSebsequenceAdjacent01 {
    static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr = new int[n];

        for(int i=0; i<n;i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println(findMaxLenWithAdjacent01());
    }

    public static int findMaxLenWithAdjacent01(){
        int[] dp = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            int currMax = 0;
            for(int j=0; j<i; j++){
                int diff = Math.abs(arr[i]-arr[j]);
                if(diff == 1 || diff == 0){
                    currMax = Math.max(currMax, dp[j]);
                }
            }

            dp[i] = currMax +1;

            Arrays.stream(dp).forEach(element -> System.out.print(element+" "));

            System.out.println();
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
