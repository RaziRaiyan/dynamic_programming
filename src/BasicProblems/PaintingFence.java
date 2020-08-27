package BasicProblems;

import java.util.Scanner;

/**
 * Given a fence with n posts and k colors, find out the number of ways of painting the fence
 * such that at most 2 adjacent posts have the same color. Since answer can be large return it modulo 10^9 + 7.
 *
 * Input : n = 2 k = 4
 * Output : 16
 * We have 4 colors and 2 posts.
 * Ways when both posts have same color : 4
 * Ways when both posts have diff color :
 * 4*(choices for 1st post) * 3(choices for
 * 2nd post) = 12
 *
 * Input : n = 3 k = 2
 * Output : 6
 */


public class PaintingFence {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
    }

    public static int countWays(int n, int k){
        int[] total = new int[n+1];
        int diff = k;
        int same = 0;

        total[1] = k;

        for(int i=1; i<=n; i++){
            same = diff;
            diff = (total[i-1])*k-1;
            total[i] = same+diff;
        }

        return total[n];
    }
}
