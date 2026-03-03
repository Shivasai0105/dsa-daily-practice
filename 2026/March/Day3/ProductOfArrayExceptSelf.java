package Day3;

public class ProductOfArrayExceptSelf {


/*  answer[i] =
(product of elements before i)
*
(product of elements after i)



answer[i] = pref[i-1] * suff[i+1]
*/


    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int prod[] = new int[nums.length];
        int pref[] = new int[n];
        int suff[] = new int[n];
        pref[0] = nums[0];
        for(int i=1;i<n;i++){
            pref[i] = pref[i-1]*nums[i];
        }
        suff[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suff[i]= suff[i+1]*nums[i];
        }
        prod[0] = suff[1]; //store the starting index product
        prod[n-1] = pref[n-2]; //store the last index product
        for(int i=1;i<n-1;i++){
            prod[i] = pref[i-1]*suff[i+1];
        }
        return prod;
            
            }
}
