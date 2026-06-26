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
    private int countGoodNode(TreeNode node, int max) {
        if(node==null) return 0;

        int count = 0;
        if(node.val >= max) {
            count=1;
            max = node.val;
        }

        count+=countGoodNode(node.left, max);
        count+=countGoodNode(node.right, max);

        return count;
    }

    public int goodNodes(TreeNode root) {
        return countGoodNode(root, root.val);
    }
}
