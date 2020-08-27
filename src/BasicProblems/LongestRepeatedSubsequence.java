package BasicProblems;

import java.util.Scanner;

/**
 * Given a string, print the longest repeating subsequence such that the two subsequence don’t
 * have same string character at same position, i.e., any i’th character in the two subsequences shouldn’t
 * have the same index in the original string.
 *
 * This problem is just the modification of Longest Common Subsequence problem.
 * The idea is to find the LCS(str, str) where str is the input string with the restriction that
 * when both the characters are same, they shouldn’t be on the same index in the two strings.
 */

public class LongestRepeatedSubsequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String A = scanner.nextLine();

        System.out.println(findLongestRepeatedSubsequence(A, A));

    }

    public static int findLongestRepeatedSubsequence(String A, String B){
        int[][] dp = new int[A.length()+1][B.length()+1];

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(A.charAt(i-1) == B.charAt(j-1) && i!=j){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[A.length()][B.length()];
    }
}
