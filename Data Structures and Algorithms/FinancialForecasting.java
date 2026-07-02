/*
1. Understanding Recursive Algorithms

Recursion is a programming technique in which a method calls itself to solve a problem by breaking it into smaller subproblems.

Every recursive function has:
- Base Case – Stops the recursion.
- Recursive Case – Calls itself with a smaller or simpler input.

Eg:
Factorial of 5:
5! = 5 × 4!
4! = 4 × 3!
3! = 3 × 2!
2! = 2 × 1!
1! = 1

The function keeps calling itself until it reaches the base case.

2. Setup

Create a recursive method that calculates the future value based on a fixed annual growth rate.

Future value formula: FV=PV(1+r)^n
where:
PV = Present Value
r = Growth rate
n = Number of years

*/

public class FinancialForecasting
{
    public static double futureValue(double presentValue, double growthRate, int years)
    {
        if (years==0)
            return presentValue;
        
        return futureValue(presentValue, growthRate, years-1)*(1+growthRate);
    }

    public static void main(String[]args)
    {
        double presentValue = 10000;
        double growthRate = 0.10;
        int years = 5;

        double result = futureValue(presentValue, growthRate, years);

        System.out.printf("Future Value after %d years = %.2f", years, result);
    }
}

/*

4. Analysis
Time Complexity
The recursive method makes one recursive call for each year.
If there are n years:

futureValue(...,5)
    ↓
futureValue(...,4)
    ↓
futureValue(...,3)
    ↓
futureValue(...,2)
    ↓
futureValue(...,1)
    ↓
futureValue(...,0)

Time Complexity: O(n)
Space Complexity: O(n)


How to Optimize the Recursive Solution

The above recursion is already efficient because it makes only one recursive call at each step.
However, in general, recursive algorithms can become inefficient if they repeatedly solve the same subproblems (for example, the recursive Fibonacci algorithm).

To optimize recursive algorithms, we can use:
- Memoization: Store previously computed results so they are not recalculated.
- Dynamic Programming: Build the solution iteratively using stored intermediate values.
- Iteration: Replace recursion with loops to eliminate recursion overhead and reduce space complexity to O(1).

For this financial forecasting problem, an iterative solution is often preferred in practice because it avoids the recursion stack while maintaining the same O(n) time complexity.


| Method    | Time Complexity | Space Complexity |
| --------- | --------------- | ---------------- |
| Recursive | O(n)            | O(n)             |
| Iterative | O(n)            | O(1)             |


*/