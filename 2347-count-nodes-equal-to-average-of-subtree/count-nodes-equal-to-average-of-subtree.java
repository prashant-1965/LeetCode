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
    public static int cnt;
    public int averageOfSubtree(TreeNode root) {
        this.cnt=0;
        dfs(root);
        return cnt;
    }
    public static int[] dfs(TreeNode root){
        if(root==null) return new int[]{0,0};
        int temp;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        
        temp = left[0]+right[0]+root.val;
        int dis = left[1]+right[1]+1;
        if(temp/dis==root.val)cnt++;
        return new int[]{temp,dis};
    }
}