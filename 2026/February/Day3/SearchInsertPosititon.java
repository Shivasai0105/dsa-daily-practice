class Solution {
    public int searchInsert(int[] nums, int target) {
        int ans = -1;
        int low = 0,high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                high = mid-1;
            }else{
                ans = mid+1;
                low = mid+1;
            }
        }
        if(ans==-1){
            return 0;
        }
        return ans;
    }
}