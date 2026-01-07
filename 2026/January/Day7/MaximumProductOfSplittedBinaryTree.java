/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long maxProduct =0;
    int mod = (int)1e9+7;
    long totalSum =0;
    public long sum(TreeNode root){
        if(root==null) return 0;
        return sum(root.left)+sum(root.right)+root.val;
    }
    public long dfs(TreeNode root){
        if(root==null) return 0;
        long left = dfs(root.left);
        long right = dfs(root.right);
        long subTreeSum = left+right+root.val;
        long product = subTreeSum*(totalSum-subTreeSum);
        maxProduct = Math.max(product,maxProduct);
        return subTreeSum;
    }
    public int maxProduct(TreeNode root) {
         totalSum = sum(root);
        dfs(root);
        return (int)(maxProduct%mod);
    }
}


/*
# 📌 LeetCode 1339 — Maximum Product of Splitted Binary Tree [daily problem]

### Intuition + Algorithm + Complexity (Future-Me Explanation)

---

## 1️⃣ Problem restated in simple words

You are given a **binary tree**.

You must:

* Remove **exactly one edge**
* This splits the tree into **two subtrees**
* Compute the **product of the sums** of these two subtrees
* Return the **maximum possible product**

---

## 2️⃣ Key observation (this unlocks the problem)

### Every valid split corresponds to **cutting one edge**

When you cut an edge:

* One part becomes a **subtree**
* The other part becomes **the rest of the tree**

So if:

* `totalSum` = sum of all nodes in the tree
* `subTreeSum` = sum of nodes in one subtree

Then the product is:

```
subTreeSum × (totalSum − subTreeSum)
```

💡 Therefore:

> **If we know the sum of every subtree, we can evaluate every possible split.**

---

## 3️⃣ Why subtree sums are the core idea

* Each node is the **root of a subtree**
* Cutting the edge **above that node** creates a valid split
* So iterating over **all subtree sums** covers **all possible splits**
* No split is missed
* No split is duplicated

---

## 4️⃣ Why postorder traversal is mandatory

To compute a subtree sum at a node:

* You must first know:

  * left subtree sum
  * right subtree sum

That means:

```
children → parent
```

This is exactly **postorder traversal**:

```
Left → Right → Node
```

---

## 5️⃣ Why we need TWO traversals

### 🔹 Traversal 1 — Compute total sum

We need `totalSum` **before** evaluating products.

So first traversal:

* Traverse entire tree
* Add all node values
* Store in a variable `totalSum`

---

### 🔹 Traversal 2 — Compute subtree sums + max product

Second traversal:

* At each node:

  1. Compute subtree sum
  2. Use formula:

     ```
     subTreeSum × (totalSum − subTreeSum)
     ```
  3. Update `maxProduct`
  4. Return `subTreeSum` to parent

This traversal does **everything else**.

---

## 6️⃣ How recursion “passes subtrees” (important mental model)

You **never pass subtrees explicitly**.

In trees:

* Passing a **node reference** = passing its subtree
* Returning a value from recursion = sending subtree information upward

So this line is the glue:

```
return subTreeSum;
```

It allows:

* Child → Parent communication
* Bottom-up aggregation

---

## 7️⃣ Role of each function (clear separation of responsibility)

### 🔹 `sum(root)`

* Purpose: compute **totalSum**
* Visits every node once
* Returns sum of entire tree
* No product calculation here

---

### 🔹 `dfs(root)`

* Purpose:

  * Compute **subtree sum**
  * Evaluate **product at each possible split**
* Returns subtree sum to parent
* Updates global `maxProduct`

---

### 🔹 `maxProduct(root)`

* Orchestrator
* Calls:

  1. `sum(root)` → get `totalSum`
  2. `dfs(root)` → compute max product
* Applies modulo **only at the end**

---

## 8️⃣ Why `long` is mandatory

* Node values can be large
* Tree can have many nodes
* Product can exceed `int` range

So:

* Use `long` for:

  * subtree sums
  * total sum
  * product
* Apply modulo **after** max comparison

---

## 9️⃣ Why modulo is applied only once

If you apply modulo early:

* You change relative order of products
* You may choose the wrong maximum

Correct approach:

* Compute max using real values
* Apply modulo only on final answer

---

## 🔁 Complete algorithm (step-by-step)

1. Traverse tree once → compute `totalSum`
2. Traverse tree again using postorder:

   * Compute subtree sum at each node
   * Evaluate:

     ```
     subTreeSum × (totalSum − subTreeSum)
     ```
   * Update `maxProduct`
3. Return:

   ```
   maxProduct % (10^9 + 7)
   ```

---

## ⏱️ Time Complexity

Let `n` = number of nodes

* First traversal: `O(n)`
* Second traversal: `O(n)`
* Total time:

  ```
  O(n)
  ```

---

## 💾 Space Complexity

* Recursion stack: `O(h)`

  * `h` = height of tree
* Worst case (skewed tree): `O(n)`
* No extra data structures

---

## 🧠 Final mental checklist (future you)

When you see:

* “split tree”
* “subtree”
* “maximize product/sum”
* “cut one edge”

Think immediately:

* Subtree sums
* Postorder traversal
* Bottom-up DP
* Return values are the glue
* Global variable collects answer

---

*/
