package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciNumbers {
    static int[] fib;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        fib = new int[n];
        System.out.println(n+"th fibonacci number is: "+bottomUp(n));
        Arrays.fill(fib, -1);
        System.out.println(n+"th fibonacci number is: "+topDown(n-1));
    }

    public static int bottomUp(int n){
        fib[0] = 0;
        fib[1] = 1;
        for(int i=2; i<n;i++){
            fib[i] = fib[i-1]+fib[i-2];
        }
        return fib[n-1];
    }

    public static int topDown(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(fib[n] != -1){
            return fib[n];
        }

        fib[n] = topDown(n-1) + topDown(n-2);
        return fib[n];
    }
}
