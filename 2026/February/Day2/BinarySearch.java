// Approach: Classic Binary Search
// 1. Initialize two pointers: low at start (0) and high at end (length-1)
// 2. While low <= high:
//    - Calculate mid point using low + (high-low)/2 to avoid overflow
//    - If nums[mid] equals target, return the index mid
//    - If nums[mid] > target, search in left half by setting high = mid-1
//    - If nums[mid] < target, search in right half by setting low = mid+1
// 3. If target not found, return -1
// Time Complexity: O(log n)
// Space Complexity: O(1)

public class BinarySearch {
    public static int binarySearch(int nums[],int tar){
        int low = 0,high = nums.length-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]== tar){
                return mid;
            }else if(nums[mid]>tar){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {1,3,5,7,11,13,17,19};
        System.out.println(binarySearch(nums,0));
    }
}

