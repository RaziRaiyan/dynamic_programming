package BasicProblems;

import java.util.Scanner;

/**
 * We need to write N same characters on a screen and each time we can insert a character,
 * delete the last character and copy and paste all written characters i.e. after copy operation
 * count of total written character will become twice. Now we are given time for insertion, deletion and copying.
 * We need to output minimum time to write N characters on the screen using these operations.
 *
 * Input : N = 9
 *         insert time = 1
 *         removal time = 2
 *         copy time = 1
 * Output : 5
 * N character can be written on screen in 5 time units as shown below,
 * insert a character
 * characters = 1  total time = 1
 * again insert character
 * characters = 2  total time = 2
 * copy characters
 * characters = 4  total time = 3
 * copy characters
 * characters = 8  total time = 4
 * insert character
 * characters = 9  total time = 5
 *
 *
 * If i is even then,
 *    dp[i] = min((dp[i-1] + insert_time),
 *                (dp[i/2] + copy_time))
 * Else (If i is odd)
 *    dp[i] = min(dp[i-1] + insert_time),
 *               (dp[(i+1)/2] + copy_time + removal_time)
 */

public class InsertDeleteCopy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int insertTime = scanner.nextInt();
        int deleteTime = scanner.nextInt();
        int copyTime = scanner.nextInt();

        System.out.println("Minimum time: "+findMinCost(n, insertTime, deleteTime, copyTime));
    }

    public static int findMinCost(int n, int insertTime, int deleteTime, int copyTime){
        int[] dp = new int[n+1];

        dp[1]  = insertTime;

        for(int i=2; i<=n; i++){
            if(i%2 == 0){
                dp[i] = Math.min(dp[i-1]+insertTime, dp[i/2]+copyTime);
            }else {
                dp[i] = Math.min(dp[i-1]+insertTime, dp[(i+1)/2]+copyTime+deleteTime);
            }
        }

        return dp[n];
    }
}
