class Solution {

    // Function to find the maximum element in the array
    // This represents the highest possible eating speed
    public int maxEle(int arr[]){
        int max = 0;
        for(int i : arr){
            max = Math.max(i, max);
        }
        return max;
    }

    // Function to calculate total hours needed if Koko eats at given speed
    // Formula used: ceil(arr[i] / speed)
    // We use (arr[i] + speed - 1) / speed to avoid floating point operations
    public int findMinSpeed(int arr[], int speed){
        int totalHrs = 0;
        for(int i = 0; i < arr.length; i++){
            totalHrs += (arr[i] + speed - 1) / speed;
        }
        return totalHrs;
    }

    // Main function: find minimum speed to finish within k hours
    public int kokoEat(int[] arr, int k) {

        int low = 1;
        int high = maxEle(arr);
        int ans = high;

        // Binary Search on answer (speed)
        while(low <= high){
            int mid = low + (high - low) / 2;

            int totalHrs = findMinSpeed(arr, mid);

            // If possible to finish within k hours, try smaller speed
            if(totalHrs <= k){
                ans = mid;
                high = mid - 1;
            }
            // Otherwise speed is too slow, increase it
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}


/*
======================== NOTES & INTUITION ========================

Problem Idea:
-------------
Koko has piles of bananas. She eats at a constant speed (bananas/hour).
We must find the MINIMUM speed such that she finishes all piles within K hours.

Key Observation:
----------------
- If speed is small → hours needed increase.
- If speed is large → hours needed decrease.
- This is a monotonic relationship.

So we can use:
→ Binary Search on the answer (speed)


Search Space:
-------------
Minimum speed = 1
Maximum speed = max pile size

Why max pile?
If speed >= largest pile, she finishes each pile in 1 hour.


Binary Search Logic:
--------------------
mid = candidate speed

If total hours at speed mid <= k:
    → mid is possible
    → try smaller speed (search left)
Else:
    → mid too slow
    → increase speed (search right)


Ceil Formula:
-------------
We need ceil(arr[i] / speed)

Instead of:
    Math.ceil((double)arr[i] / speed)

We use:
    (arr[i] + speed - 1) / speed

Example:
arr[i] = 7, speed = 3
(7 + 3 - 1) / 3 = 9 / 3 = 3


======================== DRY RUN ========================

Input:
arr = [3, 6, 7, 11]
k = 8

Step 1:
low = 1
high = 11

Iteration 1:
mid = 6
Hours = ceil(3/6)+ceil(6/6)+ceil(7/6)+ceil(11/6)
      = 1 + 1 + 2 + 2 = 6

6 <= 8 → possible
ans = 6
high = 5


Iteration 2:
low = 1, high = 5
mid = 3

Hours = 1 + 2 + 3 + 4 = 10
10 > 8 → too slow
low = 4


Iteration 3:
low = 4, high = 5
mid = 4

Hours = 1 + 2 + 2 + 3 = 8
8 <= 8 → possible
ans = 4
high = 3


Loop ends.
Final answer = 4


======================== TIME COMPLEXITY ========================

maxEle()        → O(n)
findMinSpeed()  → O(n)
Binary Search   → O(log(maxElement))

Overall:
O(n * log(maxElement))


======================== SPACE COMPLEXITY ========================

O(1)  (No extra space used)


======================== WHY THIS WORKS ========================

Because:
Speed ↑  → Hours ↓

This monotonic behavior makes the problem suitable for Binary Search on Answer.
*/
