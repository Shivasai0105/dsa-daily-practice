/*
Problem: Maximum Level Sum of a Binary Tree

Problem Explanation:
Given a binary tree, find the level (1-indexed)
with the maximum sum of node values.

Approach:
1. Perform level-order traversal (BFS).
2. Use a queue to process nodes level by level.
3. Store values of each level in a list.
4. For each level:
   - Compute sum of node values.
   - Track the level with the maximum sum.

Why BFS:
- Level-order traversal naturally groups nodes by level.
- Makes level-wise sum calculation straightforward.

Important Detail:
- Levels are 1-indexed in the final answer.

Time Complexity:
- O(n) → each node is visited once

Space Complexity:
- O(n) → queue + list to store level values
*/

//   Definition for a binary tree node.
import java.util.*;
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
}
 
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return new  ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> ls = new ArrayList<>();
             for (int i = 0; i < len; i++) {
            TreeNode node = q.poll();
            
            // --- STEP 2: Add the value to the temporary list ---
            ls.add(node.val); 
            
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
            }
            res.add(ls);
        }
        return res;
    }
    public int maxLevelSum(TreeNode root) {
        int level=0;
        int maxSum =Integer.MIN_VALUE;
        List<List<Integer>> res = levelOrder(root);
        for(int i=0;i<res.size();i++){
            List<Integer> ls = new ArrayList<>(res.get(i));
            int sum =0;
            for(int a:ls){
                sum +=a;
            }
            if(maxSum<sum){
                maxSum = sum;
                level =i;
            }
        }
        return level+1;
    }
}