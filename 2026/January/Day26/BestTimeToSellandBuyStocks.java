/*
========================================================
PROBLEM: Best Time to Buy and Sell Stock (LeetCode 121)
========================================================

You are given an array prices[] where:
- prices[i] = price of the stock on day i

You want to:
- Buy on ONE day
- Sell on a FUTURE day
- Maximize profit

Return the maximum profit.
If no profit is possible, return 0.

--------------------------------------------------------
IMPORTANT CONSTRAINT
--------------------------------------------------------

Buy must happen BEFORE sell.
You cannot sell first.

--------------------------------------------------------
KEY IDEA
--------------------------------------------------------

At each day:
- Assume we sell today
- Best profit = today’s price - minimum price seen so far

So we need to track:
1) Minimum buying price so far
2) Maximum profit so far

--------------------------------------------------------
VARIABLE MEANING
--------------------------------------------------------

minPrice → lowest stock price seen till now
maxProfit → maximum profit possible till now

--------------------------------------------------------
ALGORITHM STEPS
--------------------------------------------------------

1) Initialize:
   - minPrice = prices[0]
   - maxProfit = 0

2) Traverse from day 1 onward:
   - Update minPrice if current price is lower
   - Else, calculate profit = price - minPrice
   - Update maxProfit if profit is higher

3) Return maxProfit

--------------------------------------------------------
CODE
--------------------------------------------------------
*/

class Solution {

    public int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            // Update minimum buying price
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // Calculate profit if selling today
            else {
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}

/*
========================================================
DRY RUN (STEP-BY-STEP EXAMPLE)
========================================================

Input:
    prices = [7, 1, 5, 3, 6, 4]

Initial:
    minPrice = 7
    maxProfit = 0

--------------------------------------------------------
Day 1 → price = 1
1 < minPrice → update minPrice

minPrice = 1
maxProfit = 0

--------------------------------------------------------
Day 2 → price = 5
profit = 5 - 1 = 4
maxProfit = max(0, 4) = 4

minPrice = 1
maxProfit = 4

--------------------------------------------------------
Day 3 → price = 3
profit = 3 - 1 = 2
maxProfit remains 4

--------------------------------------------------------
Day 4 → price = 6
profit = 6 - 1 = 5
maxProfit = max(4, 5) = 5

--------------------------------------------------------
Day 5 → price = 4
profit = 4 - 1 = 3
maxProfit remains 5

--------------------------------------------------------
END OF LOOP

Final Answer:
    Maximum Profit = 5
(Buy at price 1, sell at price 6)

========================================================
EDGE CASE EXAMPLE
========================================================

prices = [7, 6, 4, 3, 1]

Prices keep decreasing → no profitable transaction

Result:
    maxProfit = 0

========================================================
WHY THIS WORKS
========================================================

- We always buy at the lowest price seen so far
- We always sell in the future
- Every day is treated as a potential selling day
- One pass guarantees optimal profit

========================================================
TIME & SPACE COMPLEXITY
========================================================

Time Complexity:  O(n)
Space Complexity: O(1)

========================================================
COMMON MISTAKES
========================================================

❌ Trying all buy-sell pairs (O(n²))
❌ Selling before buying
❌ Resetting profit when price decreases
❌ Confusing this with multiple transactions problem

========================================================
END OF NOTES
========================================================
*/
