package BasicProblems;

import java.util.Scanner;

/**
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 *
 * Insert
 * Remove
 * Replace
 * All of the above operations are of equal cost.
 *
 */

public class EditDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String X = scanner.nextLine();
        String Y = scanner.nextLine();

        System.out.println("Minimum Edit distance: "+findMinEditDistance(X, Y));
    }

    public static int findMinEditDistance(String X, String Y){
        int[][] dp = new int[X.length()+1][Y.length()+1];

        for(int i=0; i<=X.length(); i++){
            for(int j=0; j<=Y.length(); j++){
                if(i == 0)
                    dp[i][j] = j;
                else if(j == 0)
                    dp[i][j] = i;
                else if(X.charAt(i-1) == Y.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = 1+Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
        }

        return dp[X.length()][Y.length()];
    }
}
