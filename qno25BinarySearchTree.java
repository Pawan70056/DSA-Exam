// What is binary search tree? What is the maximum number of node possible in binary tree of depth d. 
// Make BST of a given sequence and traverse tree in all time of traversal.


// Answer::

// A binary search tree (BST) is a binary tree data structure in which each node has at most two child nodes, 
// referred to as the left child and the right child.

// In a BST, for each node:

// 1. All nodes in the left subtree have values less than the node's value.
// 2. All nodes in the right subtree have values greater than the node's value.
// 3. Both the left and right subtrees are also binary search trees.

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    // Insert a new key into the BST
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Perform pre-order traversal
    public void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    // Perform in-order traversal
    public void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.key + " ");
            inOrderTraversal(root.right);
        }
    }

    // Perform post-order traversal
    public void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.key + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] sequence = {50, 30, 20, 40, 70, 60, 80};

        for (int key : sequence) {
            tree.insert(key);
        }

        System.out.println("Pre-order traversal:");
        tree.preOrderTraversal(tree.root);

        System.out.println("\nIn-order traversal:");
        tree.inOrderTraversal(tree.root);

        System.out.println("\nPost-order traversal:");
        tree.postOrderTraversal(tree.root);
    }
}
