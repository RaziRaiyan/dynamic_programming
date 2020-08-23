package BasicProblems;

import java.util.Scanner;

/**
 Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
 The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers.
 By convention, 1 is included.

 Given a number n, the task is to find n’th Ugly number.
 */

public class UglyNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ugly = new int[n];
        ugly[0] = 1;
        int next_multiple_2 = ugly[0] * 2;
        int next_multiple_3 = ugly[0] * 3;
        int next_multiple_5 = ugly[0] * 5;
        int i1 = 0, i2=0, i3=0;

        for(int i=1;i<n;i++){
            int next_ugly_no = Math.min(next_multiple_2, Math.min(next_multiple_3, next_multiple_5));
            ugly[i] = next_ugly_no;
            if(next_ugly_no == next_multiple_2){
                i1++;
                next_multiple_2 = ugly[i1]*2;
            }
            if(next_ugly_no == next_multiple_3){
                i2++;
                next_multiple_3 = ugly[i2]*3;
            }
            if(next_ugly_no == next_multiple_5){
                i3++;
                next_multiple_5= ugly[i3]*5;
            }
        }

        System.out.println(n+"th ugly number is: "+ugly[n-1]);
    }
}
