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
    int maxSum = Integer.MIN_VALUE;
    // Return left sum, right sum with cur element, or just current element or none
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxSum;
    }

    private int maxPathSumHelper(TreeNode root) {
        if(root==null) return 0;

        int l = Math.max(0, maxPathSumHelper(root.left));
        int r = Math.max(0, maxPathSumHelper(root.right));

        maxSum = Math.max(l+r+root.val, maxSum);
        return Math.max(Math.max(l, r) + root.val, 0);
    }
}
