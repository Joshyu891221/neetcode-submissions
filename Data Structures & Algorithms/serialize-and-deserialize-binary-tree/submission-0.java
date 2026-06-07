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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> arr = new ArrayList<>();
        dfs1(root, arr);
        // System.out.print(arr);
        return String.join(",", arr);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        int[] i = new int[]{0};
        return dfs2(arr, i);
        // return new TreeNode();
    }

    public void dfs1 (TreeNode node, ArrayList arr){
        if(node == null){
            arr.add("n");
            return;
        }
        arr.add(String.valueOf(node.val));
        
        dfs1(node.left, arr);
        dfs1(node.right, arr);
        
    }
}   
    public TreeNode dfs2 (String[] arr, int[] i){
        if(arr[i[0]].equals("n")){
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[i[0]]));
        i[0]++;
        node.left = dfs2(arr, i);
        node.right = dfs2(arr, i);
        return node;
    }
