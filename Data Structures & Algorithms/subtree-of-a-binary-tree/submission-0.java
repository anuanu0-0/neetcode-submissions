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
    private boolean compare(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if((p!=null && q==null) || (p==null && q!=null)) return false;

        return compare(p.left, q.left) && compare(p.right, q.right) && p.val==q.val;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        if(compare(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
