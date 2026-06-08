class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;

        // Clean children first (post-order)
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        // If current node is now a leaf and equals target, remove it
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        return root;
    }
}
