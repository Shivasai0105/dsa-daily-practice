// Approach: Binary Search to find Lower Bound
// Lower Bound: Find the leftmost (first) position where the target element can be inserted
// or the first occurrence of the target element if it exists
// 1. Initialize low = 0, high = arr.length-1, and ans = -1
// 2. While low <= high:
//    - Calculate mid = low + (high-low)/2
//    - If arr[mid] == target:
//      * Update ans = mid (store the position)
//      * Continue searching in left half by setting high = mid-1 (to find leftmost)
//    - If arr[mid] < target:
//      * Search in right half by setting high = mid-1
//    - If arr[mid] > target:
//      * Search in left half by setting low = mid+1
// 3. Return ans (the leftmost position or -1 if not found)
// Time Complexity: O(log n)
// Space Complexity: O(1)

public class LowerBound {
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 4, 5, 7};
        int x = 4;
        System.out.println(lowerBound(arr, x));

    }

    public static int lowerBound(int arr[],int tar){
        int ans =-1;
        int low =0,high = arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==tar){
                ans = mid;
                high = mid-1;

            }else if(arr[mid]<tar){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}
