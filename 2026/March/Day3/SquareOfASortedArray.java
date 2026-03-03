package Day3;


//here i'll keep two pointers at the first idx and at the end idx and position pointer for the new array at the end
//so every time i square a array element and compare the starting squared element and ending squared element
//if jsqr > isqr then we will place the jsqr at the postion of new array and decrement 'j'  at the idx of the "pos" and decrement the pos also
//if isqr > jsqr then will plce the isqr at the pos idx and increment i, then decrement pos pointer 
//if i<=j this becomes false then the loop stops

//T.C :O(N)
//S.C :O(N) if we consider answer as extra space else O[1]
public class SquareOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int i=0;
        int j=n-1;
        int pos = n-1;
        while (i<=j) {
            int isqr = nums[i]*nums[i];
            int jsqr = nums[j]*nums[j];
            if(isqr>jsqr){
                ans[pos] = isqr;
                i++;
            }else{
                ans[pos] = jsqr;
                j--;
            }
            pos--;
        }



        return ans;
    }
}
