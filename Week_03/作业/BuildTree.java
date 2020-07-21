import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
class BuildTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归
     */
    private Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder,
                               int preOrderLeft, int preOrderRight, int inOrderLeft, int inOrderRight) {
        if (preOrderLeft > preOrderRight) {
            return null;
        }

        int preOrderRootIndex = preOrderLeft;
        int inOrderRootIndex = indexMap.get(preorder[preOrderRootIndex]);

        TreeNode root = new TreeNode(preorder[preOrderLeft]);
        int leftSize = inOrderRootIndex - inOrderLeft;
        root.left = buildTree(preorder, inorder,
                preOrderRootIndex + 1, preOrderRootIndex + leftSize, inOrderLeft, inOrderRootIndex - 1);
        root.right = buildTree(preorder, inorder,
                preOrderRootIndex + leftSize + 1, preOrderRight, inOrderRootIndex + 1, inOrderRight);
        return root;
    }
}