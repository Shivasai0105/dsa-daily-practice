class Solution {
    public int[] twoSum(int[] nums, int target) {

        // left pointer starts at the beginning of the array
        // right pointer starts at the end of the array
        int left = 0, right = nums.length - 1;

        // continue while pointers do not cross
        while (left < right) {

            // calculate the sum of elements at both pointers
            int sum = nums[left] + nums[right];

            // if the sum matches the target, return 1-based indices
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            // if sum is smaller than target,
            // move left pointer to increase the sum
            else if (sum < target) {
                left++;
            }
            // if sum is greater than target,
            // move right pointer to decrease the sum
            else {
                right--;
            }
        }

        // if no valid pair is found (problem guarantees one solution,
        // so this is just a safety return)
        return new int[]{-1, -1};
    }
}

/*
==================== DRY RUN ====================

Example:
nums = [2, 7, 11, 15]
target = 9

Initial:
left = 0  → nums[left] = 2
right = 3 → nums[right] = 15

Iteration 1:
sum = 2 + 15 = 17
17 > 9 → sum too large
→ move right pointer left
right = 2

Iteration 2:
left = 0 → nums[left] = 2
right = 2 → nums[right] = 11
sum = 2 + 11 = 13
13 > 9 → sum too large
→ move right pointer left
right = 1

Iteration 3:
left = 0 → nums[left] = 2
right = 1 → nums[right] = 7
sum = 2 + 7 = 9
9 == target → found answer

Return:
[left + 1, right + 1] = [1, 2]

==================== WHY THIS WORKS ====================

- The array is sorted
- Moving left increases the sum
- Moving right decreases the sum
- Every step removes impossible pairs
- Time Complexity: O(n)
- Space Complexity: O(1)

=======================================================

BRUTE FORCE APPROACH

class Solution {

    // Binary search to find 'target' in the array starting from index 'start'
    // Searches only the right side to avoid using the same element twice
    public static int binarySearch(int[] arr, int target, int start) {

        // low starts from the given index, high goes till end of array
        int low = start;
        int high = arr.length - 1;

        // standard binary search loop
        while (low <= high) {

            // calculate mid safely to avoid overflow
            int mid = low + (high - low) / 2;

            // target found at mid
            if (arr[mid] == target) {
                return mid;
            }
            // if mid value is smaller, search right half
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            // if mid value is larger, search left half
            else {
                high = mid - 1;
            }
        }

        // target not found in the given range
        return -1;
    }

    // Two Sum for a sorted array using binary search
    public int[] twoSum(int[] arr, int target) {

        // iterate through each element as the first number
        for (int i = 0; i < arr.length; i++) {

            // calculate the remaining value needed
            int tar = target - arr[i];

            // search for the remaining value only on the right side
            // to ensure we don't reuse the same index
            int res = binarySearch(arr, tar, i + 1);

            // if a valid pair is found
            if (res != -1) {
                // return indices in 1-based indexing as required by LeetCode
                return new int[]{i + 1, res + 1};
            }
        }

        // safety return (problem guarantees exactly one solution)
        return new int[]{-1, -1};
    }
}

*/
