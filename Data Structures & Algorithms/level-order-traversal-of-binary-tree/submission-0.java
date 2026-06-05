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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        
        if (root == null) {
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int qlen = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < qlen; i++){
                TreeNode node = queue.poll();
                if(node != null){
                    level.add(node.val);
                    if( node.left != null){
                        queue.add(node.left);
                    }
                    if( node.right != null){
                        queue.add(node.right);
                    }
                }
            }
            res.add(level);
        }
        return res;
    }
}
