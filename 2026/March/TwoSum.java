import java.util.*;
class TwoSum {
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