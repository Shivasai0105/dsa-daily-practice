class FirstandLastOccurances {
    public int upperBound(int [] nums,int tar){
        int low =0,high = nums.length-1,ans = -1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==tar){
                ans = mid;
                // high = mid-1;
                low = mid+1;
            }else if(nums[mid]>tar){
               high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    } 
    public int lowerBound(int [] nums,int tar){
        int low = 0,high = nums.length-1,ans =-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==tar){
                ans = mid;
            //   low=mid+1;
            high = mid-1;
            }else if(nums[mid]>tar){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    } 
    public int[] searchRange(int[] nums, int target) {
        int frst = lowerBound(nums,target);
        int last = upperBound(nums,target);
        return new int[]{frst,last};
    }
}