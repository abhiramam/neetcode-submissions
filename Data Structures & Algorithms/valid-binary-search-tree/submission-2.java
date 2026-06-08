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
    public boolean isValidBST(TreeNode root) {
        return dfsHelper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean dfsHelper(TreeNode root,int minValue,int maxValue){
        if(root == null){
            return true;
        }
        if(root.val <= minValue || root.val>= maxValue){
            return false;
        }
        if(!dfsHelper(root.left,minValue,root.val)){
            return false;
        }
        if(!dfsHelper(root.right,root.val,maxValue)){
            return false;
        }
        return true;
    }
}
