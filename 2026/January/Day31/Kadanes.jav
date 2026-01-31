class Solution {
    int maxSubarraySum(int[] arr) {
        // Code here
        int currsum = arr[0];
        int maxSum = arr[0];
        int n = arr.length;
        for(int i=1;i<n;i++){
            currsum = Math.max(arr[i],currsum+arr[i]);
            maxSum =Math.max(currsum,maxSum);
            
        }
        return maxSum;
    }
}
