package Day2;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int k = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[k] = nums[i];
                k++;
            }
        }
        for(int i=k;i<nums.length;i++){
            nums[i] = 0;
        }
    }
}
// “I use a two-pointer approach. One pointer scans the array, and another keeps track of where the next non-zero should go. First, I shift all non-zero elements forward, then fill the remaining positions with zeros. This gives O(n) time and O(1) space while preserving order.”