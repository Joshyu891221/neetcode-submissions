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
    private int count = 0;
    private int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null || count >= k){
            return;
        }
        dfs(root.left, k);
        count += 1;
        if ( count == k){res = root.val;}
        dfs(root.right, k);
        return;
    }
}
