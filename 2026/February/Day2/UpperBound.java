// Approach: Binary Search to find Upper Bound
// Upper Bound: Find the rightmost position where the target element can be inserted
// or the first element strictly greater than the target
// 1. Initialize low = 0, high = arr.length-1, ans = arr.length
// 2. While low <= high:
//    - Calculate mid = low + (high-low)/2
//    - If arr[mid] > target:
//      * Update ans = mid (store the position)
//      * Continue searching in left half by setting high = mid-1 (to find rightmost)
//    - If arr[mid] <= target:
//      * Search in right half by setting low = mid+1
// 3. Return ans (the rightmost position or arr.length if not found)
// Time Complexity: O(log n)
// Space Complexity: O(1)

public class UpperBound {
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 4, 5, 7};
        int x = 4;
        System.out.println(upperBound(arr,x));
    }

    static int upperBound(int[] arr, int target) {
        // code here
        int low = 0,high = arr.length-1;
        int ans =arr.length;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>target){
                ans = mid;
                high = mid-1;
            }
            else{
               low = mid+1;
            }
        }
        return ans;
    }
}
