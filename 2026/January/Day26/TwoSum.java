import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int need = target-nums[i];
            if(mp.containsKey(need)){
                int ans = mp.get(need);
                return new int[]{i,ans};
            }
            mp.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}


/* 
here is approach

i will create a map where it stores the nums[i] and index 'i' in key value pair key is the nums[i] and val is index

when i start traversing from the 0 to n-1 i will try to needed value 

need = tar - num[i] in the map if i find it then i will return the index of num and need index which we stored in the map

tc: O(n) in the worst we travel till the end of the array 
or if we dont find the answer also 
we will return array with [-1,-1]
sc:O(n) cause we are adding elements to the map
*/