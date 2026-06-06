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
    private Map<Integer, Integer> map = new HashMap<>();
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0], null, null);
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(preorder, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int inStart, int inEnd) {
        if( inStart > inEnd){
            return null;
        }

        int rootval = preorder[preorderIndex];
        preorderIndex ++;

        TreeNode node = new TreeNode(rootval);

        int inorderIndex = map.get(rootval);

        node.left  = helper(preorder, inStart, inorderIndex - 1);
        node.right  = helper(preorder, inorderIndex + 1, inEnd);

        return node;





    }
}
