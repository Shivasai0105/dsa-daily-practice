package Day4;

import java.util.*;
public class ThreeSum {

        /*
        * PROBLEM: 3Sum
        *
        * GOAL:
        * Find all unique triplets in the array which gives the sum of zero.
        *
        * CORE DIFFICULTY:
        * 1) Avoiding duplicates.
        * 2) Efficiently finding pairs that sum to a target.
        *
        * KEY OBSERVATION:
        * Sorting the array allows us to use two-pointer technique to find pairs.
        * We can fix one element and then find pairs that sum to the negative of that element.
        *
        * DUPLICATE HANDLING:
        * After sorting, duplicate elements will be adjacent.
        * We can skip over duplicates to ensure unique triplets.
        */
        // Step 1: Sort the array to facilitate two-pointer technique and duplicate handling.
        // Step 2: Iterate through the array, fixing one element at a time. 
        // Step 3: For each fixed element, use two pointers to find pairs that sum to the negative of the fixed element.
        // Step 4: Move pointers based on the sum and skip duplicates to ensure unique triplets.
        // Step 5: Collect valid triplets in the result list and return it at the end.
        // Time Complexity: O(n^2) due to the nested loop and two-pointer search.
        // Space Complexity: O(1) for the two-pointer approach, plus O(k) for the output list where k is the number of unique triplets found.


        //optimal approach TC: O(n^2) SC: O(1) + O(k) for answer list
    public List<List<Integer>> threeSum(int[] nums) {

        // Step 1: Result list to store all unique triplets
        List<List<Integer>> ans = new ArrayList<>();

        // Step 2: Sort the array so we can use two-pointer technique
        Arrays.sort(nums);

        int n = nums.length;

        // Step 3: Fix the first element of the triplet
        for(int i = 0; i < n; i++){

            // Step 4: Skip duplicate values for i
            // This prevents duplicate triplets
            if(i > 0 && nums[i] == nums[i-1]) continue;

            // Step 5: Two pointers for remaining part of array
            int j = i + 1;
            int k = n - 1;

            // Step 6: Search pairs using two pointers
            while(j < k){

                int sum = nums[i] + nums[j] + nums[k];

                // Step 7: If sum is smaller than 0 → increase sum
                if(sum < 0){
                    j++;
                }

                // Step 8: If sum is larger than 0 → decrease sum
                else if(sum > 0){
                    k--;
                }

                // Step 9: If sum == 0 → triplet found
                else{
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[j]);
                    ls.add(nums[k]);
                    ans.add(ls);

                    // Step 10: Move both pointers
                    j++;
                    k--;

                    // Step 11: Skip duplicate values for j
                    while(j < k && nums[j] == nums[j-1]) j++;

                    // Step 12: Skip duplicate values for k
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }

        // Step 13: Return all unique triplets
        return ans;
    }
}


//better approach 
// TC: O(n^2) SC: O(n) for hashset + O(k) for answer list
// This approach uses a hash set to find pairs that sum to a target, but it may have more overhead due to sorting and handling duplicates.
// It is less efficient than the two-pointer approach, especially for larger input sizes, due to the additional space complexity and the need to sort the triplets before adding them to the result set.
// Note: The two-pointer approach is generally preferred for this problem due to its efficiency and simplicity in handling duplicates.
// step 1: Use a hash set to store seen numbers while iterating through pairs.
// step 2: For each pair (nums[i], nums[j]), calculate the required third
// number to make the sum zero, which is -(nums[i] + nums[j]).
// step 3: Check if this third number exists in the hash set. If it does, we have found a valid triplet.
// step 4: To avoid duplicates, sort the triplet before adding it to the result
// set. This ensures that the same triplet in different orders is not added multiple times.

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;

        for(int i = 0; i < n; i++){

            HashSet<Integer> set = new HashSet<>();

            for(int j = i + 1; j < n; j++){

                int third = -(nums[i] + nums[j]);

                if(set.contains(third)){

                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(temp);
                    result.add(temp);
                }

                set.add(nums[j]);
            }
        }

        return new ArrayList<>(result);
    }
}