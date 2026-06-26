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

public class Codec1 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsSerialize(root, res);
        return String.join(",", res);
    }

    private void dfsSerialize(TreeNode node, List<String> res) {
        if(node==null) {
            res.add("N");
            return;
        }

        res.add(String.valueOf(node.val));
        dfsSerialize(node.left, res);
        dfsSerialize(node.right, res);
    }

    // Decodes your encoded data to tree.
    int index = 0;
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        index = 0;
        return dfsDeserialize(vals);
    }

    private TreeNode dfsDeserialize(String[] vals) {
        if(vals[index].equals("N")) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(vals[index]));
        index++;

        node.left = dfsDeserialize(vals);
        node.right = dfsDeserialize(vals);
        return node;
    }
}

public class Codec {
    public String serialize(TreeNode root) {
        if(root==null) return "N";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node==null){
                res.append("N,");
            } else {
                res.append(node.val).append(",");
                q.add(node.left);
                q.add(node.right);
            }
        }
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int index = 0;
        if(vals[index].equals("N")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(vals[index]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        index++;
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(!vals[index].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(vals[index]));
                q.add(node.left);
            }

            index++;
            if(!vals[index].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(vals[index]));
                q.add(node.right);
            }
            index++;

        }

        return root;
    }
}

