package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
 */

public class LongestCommonSubstring {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String X = scanner.nextLine();
        String Y = scanner.nextLine();

        dp = new int[X.length()+1][Y.length()+1];



        System.out.println("Length of longest common substring: "+findMaxlenSubstring(X, Y));

        Arrays.stream(dp).forEach(row -> {
            Arrays.stream(row).forEach(element -> System.out.print(element+" "));
            System.out.println();
        });

    }

    public static int findMaxlenSubstring(String X, String Y){

        int max = 0;

        for(int i=1; i<=X.length(); i++){
            for(int j=1; j<=Y.length(); j++){
                if(X.charAt(i-1) == Y.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }


}
