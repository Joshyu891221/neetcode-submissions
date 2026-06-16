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
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        q.offerLast(root);

        while(!q.isEmpty()){
            int len = q.size();

            for(int i = 0; i < len; i++){
                TreeNode node = q.pollFirst();

                if(i == len - 1){
                    res.add(node.val);
                }
                if(node.left != null){
                    q.offerLast(node.left);
                }
                if(node.right != null){
                    q.offerLast(node.right);
                }
                
            }
        }
        return res;
    }
}
