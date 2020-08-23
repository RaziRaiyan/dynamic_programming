# Dynamic Programming
Dynamic Programming is mainly an optimization over plain recursion. Wherever we see a recursive solution that has repeated calls for same inputs, we can optimize it using Dynamic Programming

## Basic Concepts
* **Tabulation Vs Memoization**

   There are following two different ways to store the values so that the values of a sub-problem can be reused. Here, will discuss two patterns of solving DP problem
    1. **Tabulation**: Bottom Up (starting from the bottom and cummulating answers to the top.)
    2. **Memoization**: Top Down (If we need to find the value for some state say dp[n] and instead of starting from the base state that i.e dp[0] we ask our answer from the states that can reach the destination state dp[n] following the state transition relation, then it is the top-down fashion of DP.)
    
    ``` C
    // Tabulated version to find factorial x.
    int dp[MAXN];
    
    // base case
    int dp[0] = 1;
    for (int i = 1; i< =n; i++)
    {
        dp[i] = dp[i-1] * i;
    }
   ```
  
  ``` C
    // Memoized version to find factorial x.
    // To speed up we store the values
    // of calculated states
    
    // initialized to -1
    int dp[MAXN]
    
    // return fact x!
    int solve(int x)
    {
        if (x==0)
            return 1;
        if (dp[x]!=-1)
            return dp[x];
        return (dp[x] = x * solve(x-1));
    }
  ```
  
* **Overlapping Subproblem**

    Like Divide and Conquer, Dynamic Programming combines solutions to sub-problems. Dynamic Programming is mainly used when solutions of same subproblems are needed again and again.
    
* **Optimal Substructure**

     A given problems has Optimal Substructure Property if optimal solution of the given problem can be obtained by using optimal solutions of its subproblems.
     
     For example, the Shortest Path problem has following optimal substructure property:
     If a node x lies in the shortest path from a source node u to destination node v then the shortest path from u to v is combination of shortest path from u to x and shortest path from x to v. The standard All Pair Shortest Path algorithms like Floyd–Warshall and Bellman–Ford are typical examples of Dynamic Programming.

* **Steps to solve DP**
    
    * Identify if it is a DP problem
    * Decide a state expression with least parameters
    * Formulate state relationship
    * Do tabulation (or do Memoization)

    https://www.geeksforgeeks.org/solve-dynamic-programming-problem/
    
    
