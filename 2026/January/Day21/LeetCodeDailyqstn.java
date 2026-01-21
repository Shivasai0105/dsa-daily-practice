import java.util.*;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int arr[] = new int[nums.size()];
        int n = nums.size();
        for(int i=0;i<n;i++){
            if(nums.get(i)==2){
                arr[i] = -1;
            }else{
                int res = -1;
                int d = 1;
                int x = nums.get(i);
                while((x&d)!=0){
                    res = x-d;
                    d<<=1;
                }
                arr[i] = res;
            }
        }
        return arr;
    }
}

/*
Alright — this is a **future-you explanation**.
No fluff, no tricks, just the **core idea you’ll want to remember in 10 days**.

---

## What was the question really asking?

You are given a number `x` (a prime).

You must find the **smallest number `a`** such that:

```
a | (a + 1) = x
```

If it’s impossible, return `-1`.

---

## One thing you MUST remember

> **OR of two consecutive numbers always creates a block of 1s at the end.**

Why?

* `+1` flips the rightmost `0`
* OR turns everything to the right into `1`

So:

* If `x` **ends with 0** → impossible
  (`2 = 10`)
* If `x` **ends with 1s** → possible

That’s why **only 2 fails** (it’s the only even prime).

---

## The real goal (this is where people mess up)

Not just:

> “Find *a* solution”

But:

> **Find the *minimum* possible solution**

Multiple `a` values can work — you must pick the **smallest**.

---

## How to think about “minimum”

Look at `x` in binary.

Example:

```
x = 23 = 10111
```

The right side has **consecutive 1s**.

To build `x` using:

```
a | (a + 1)
```

You must:

* Keep the left part unchanged
* Remove **exactly one `1`** from the rightmost block
* Let OR regenerate the missing 1s

Removing:

* too little → bigger `a`
* too much → OR can’t rebuild

---

## The mental algorithm (no code)

1. Start from the **rightmost bit**
2. As long as the bit is `1`:

   * Try removing it
3. The **last valid removal** gives the smallest `a`

---

## What your code was doing (in human words)

* Walk through trailing `1`s using a moving bit (`d = 1, 2, 4, …`)
* Each time:

  * Subtract that bit
  * Store the result
* Stop when you hit a `0`
* Return the **smallest stored value**

---

## Why this works every time

Because:

* OR can only recreate **trailing 1s**
* The smallest valid number is obtained by:

  * removing **one bit**
  * from the **highest position inside the trailing-1 block**

---

## Final memory hook (THIS is what future-you should recall)

> **“OR of consecutive numbers fills trailing 1s.
> To minimize, remove exactly one 1 from the trailing block — not more, not less.”**

If you remember just that sentence, you can re-derive the entire solution.

---
*/