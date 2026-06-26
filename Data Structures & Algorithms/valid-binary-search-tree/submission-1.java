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
    private boolean isValid(TreeNode root, int left, int right) {
        if(root==null) return true;
        if(root.val <= left || root.val >= right) return false;

        boolean ltree = isValid(root.left, left, root.val);
        boolean rtree = isValid(root.right, root.val, right);
        return ltree && rtree;
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
