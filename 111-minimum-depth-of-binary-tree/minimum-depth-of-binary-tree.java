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
    public int minDepth(TreeNode root) {
        int val = dfs(root);
        return val==100001?0:val;
    }
    public int dfs(TreeNode root){
        if(root==null) return 100001;
        if(root.left==null && root.right==null) return 1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        return 1+Math.min(left,right);
    }
}