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
    private int check(TreeNode node) {
        // if balanced send height else send -1
        if(node==null) return 0;

        int lh = check(node.left);
        int rh = check(node.right);

        if(Math.abs(lh-rh)>1 || lh==-1 || rh==-1) return -1;
        return Math.max(lh, rh)+1;
    }

    public boolean isBalanced(TreeNode root) {
        if(check(root)==-1) return false;
        return true;
    }
}
