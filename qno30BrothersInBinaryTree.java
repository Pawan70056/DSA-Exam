// Given the root of binary tree with unique values and the values of 2 different nodes of the tree X and Y, 
// return true if the nodes corresponding to the value X and Y in the tree are brothers or false otherwise.
// Note :- two nodes of binary tree are brothers if they have same depth with different parent. Binary tree 
// 1 ,2,3,4 y = 3, x-4 output = false.



// Answer:


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class qno30BrothersInBinaryTree {

    public boolean isBrothers(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        
        ParentDepth parentDepthX = findParentDepth(root, x, null, 0);
        ParentDepth parentDepthY = findParentDepth(root, y, null, 0);

        return parentDepthX != null && parentDepthY != null && parentDepthX.depth == parentDepthY.depth && parentDepthX.parent != parentDepthY.parent;
    }

    private ParentDepth findParentDepth(TreeNode node, int val, TreeNode parent, int depth) {
        if (node == null) {
            return null;
        }
        
        if (node.val == val) {
            return new ParentDepth(parent, depth);
        }
        
        ParentDepth left = findParentDepth(node.left, val, node, depth + 1);
        ParentDepth right = findParentDepth(node.right, val, node, depth + 1);
        
        return left != null ? left : right;
    }

    class ParentDepth {
        TreeNode parent;
        int depth;

        ParentDepth(TreeNode parent, int depth) {
            this.parent = parent;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        qno30BrothersInBinaryTree solution = new qno30BrothersInBinaryTree();

        // Test case 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        System.out.println(solution.isBrothers(root1, 3, 4)); // Output should be false

        // Test case 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.left = new TreeNode(5);
        System.out.println(solution.isBrothers(root2, 4, 5)); // Output should be true
    }
}
