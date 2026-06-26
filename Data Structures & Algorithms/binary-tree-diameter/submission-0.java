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
    int maxDiameter = Integer.MIN_VALUE;
    private int calculateDiameter(TreeNode node) {
        if(node==null) return 0;

        int lh = calculateDiameter(node.left);
        int rh = calculateDiameter(node.right);
        maxDiameter = Math.max(lh+rh+1, maxDiameter);
        return Math.max(lh, rh)+1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        calculateDiameter(root);
        return maxDiameter-1;
    }
}
