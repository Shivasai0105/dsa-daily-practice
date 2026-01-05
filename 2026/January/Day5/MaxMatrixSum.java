class Solution {
    public long maxMatrixSum(int[][] mat) {
        int n = mat.length;
        int negcount = 0;
        int minAbs = Integer.MAX_VALUE;
        long sum =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int val = mat[i][j];
                sum += Math.abs(val);
                if(val<0){
                    negcount++;
                }
                minAbs = Math.min(minAbs,Math.abs(val));
            }
        }
            
        if(negcount%2==1){
            sum -= 2L*minAbs;
        }
        return sum;
    }
}

/*
1️⃣ LC 1975 – Maximum Matrix Sum

Pattern: Greedy + Mathematical Observation

What the problem is really about

You are allowed to flip the sign of any element any number of times, but each operation flips two elements at once (because flipping rows/columns effectively changes parity).

So the question becomes:

Given all numbers, what is the maximum possible sum after allowed sign changes?

Key Observations

Absolute values always help

Whether a number is positive or negative, taking its absolute value increases the sum.

The only restriction is:

If the number of negative elements is odd, one element must stay negative.

To minimize damage:

Keep the element with the smallest absolute value negative.

Strategy

Add up absolute values of all elements.

Count how many negative numbers exist.

Track the minimum absolute value.

If negatives are odd → subtract 2 × minAbs.

Why subtract 2 × minAbs?

Because:

You already added +minAbs

But it must actually be -minAbs

Difference = 2 × minAbs

Final Insight

Greedy works because the problem reduces to parity of negatives, not position or structure. */