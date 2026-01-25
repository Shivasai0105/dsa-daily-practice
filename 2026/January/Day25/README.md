revision of sliding window problems 
Maximum average subarray 1 lc 643  FIXED SIZE WINDOW

LC 1343 – Number of Subarrays of Size K and Average ≥ Threshold
FIXED SIZE WINDOW
> count distinct elements in the window
Core Principle

Add one element, remove one element, update the answer.

Only two elements change when the window moves:

One element enters the window

One element leaves the window

Generic Template // Step 1: build first window for (int i = 0; i < k; i++) { updateState(arr[i]); }

// Step 2: slide the window for (int i = k; i < n; i++) { add(arr[i]); // incoming element remove(arr[i - k]); // outgoing element updateAnswer(); }

This guarantees:

Time Complexity → O(n)

Space Complexity → O(1)


VARIABLE SIZE SLIDING WINDOW 
LC 3 LEN OF LONGEST SUBSTRING WITH UNIQUE CHARACTERS 
Problem Idea:
Find the length of the longest substring with all unique characters.

Window Strategy:
- Use two pointers: left and right
- Expand right pointer to include new characters
- Shrink left pointer only when a duplicate is found

State Maintained:
- Map<Character, Integer> stores the LAST index of each character
- left pointer always represents the start of a valid window

