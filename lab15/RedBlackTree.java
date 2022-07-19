public class RedBlackTree<T extends Comparable<T>> {

    /* Root of the tree. */
    RBTreeNode<T> root;

    static class RBTreeNode<T> {

        final T item;
        boolean isBlack;
        RBTreeNode<T> left;
        RBTreeNode<T> right;

        /* Creates a RBTreeNode with item ITEM and color depending on ISBLACK
           value. */
        RBTreeNode(boolean isBlack, T item) {
            this(isBlack, item, null, null);
        }

        /* Creates a RBTreeNode with item ITEM, color depending on ISBLACK
           value, left child LEFT, and right child RIGHT. */
        RBTreeNode(boolean isBlack, T item, RBTreeNode<T> left,
                   RBTreeNode<T> right) {
            this.isBlack = isBlack;
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

    /* Creates an empty RedBlackTree. */
    public RedBlackTree() {
        root = null;
    }

    /* Creates a RedBlackTree from a given 2-3 TREE. */
    public RedBlackTree(TwoThreeTree<T> tree) {
        Node<T> ttTreeRoot = tree.root;
        root = buildRedBlackTree(ttTreeRoot);
    }

    /* Builds a RedBlackTree that has isometry with given 2-3 tree rooted at
       given node R, and returns the root node. */
    RBTreeNode<T> buildRedBlackTree(Node<T> r) {
        if (r == null) {
            return null;
        }
        if (r.getItemCount() == 1) {
            // TODO: Replace with code to create a 2-node equivalent
            RBTreeNode newRb = new RBTreeNode(true, r.getItemAt(0),
                    buildRedBlackTree(r.getChildAt(0)), buildRedBlackTree(r.getChildAt(1)));
            return newRb;
        } else {
            // TODO: Replace with code to create a 3-node equivalent
            // left node - red
            RBTreeNode newRb = new RBTreeNode(true, r.getItemAt(0),
                    buildRedBlackTree(r.getChildAt(0)), new RBTreeNode(false, r.getItemAt(1),
                    buildRedBlackTree(r.getChildAt(1)), buildRedBlackTree(r.getChildAt(2))));
            return newRb;
        }
    }

    /* Flips the color of NODE and its children. Assume that NODE has both left
       and right children. */
    void flipColors(RBTreeNode<T> node) {
        // TODO: YOUR CODE HERE
        // opposite
        node.isBlack = !node.isBlack;
        node.right.isBlack = !node.right.isBlack;
        node.left.isBlack = !node.left.isBlack;


    }

    /* Rotates the given node NODE to the right. Returns the new root node of
       this subtree. */
    RBTreeNode<T> rotateRight(RBTreeNode<T> node) {
        // TODO: YOUR CODE HERE
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        } else if ((node.left == null && node.right == null)) {
            return node;
        } else {
            RBTreeNode newRight = new RBTreeNode(node.left.isBlack, node.item, node.left.right, node.right);
            RBTreeNode newNode = new RBTreeNode(node.isBlack, node.left.item, node.left.left, newRight);
            return newNode;
        }

    }

    /* Rotates the given node NODE to the left. Returns the new root node of
       this subtree. */
    RBTreeNode<T> rotateLeft(RBTreeNode<T> node) {
        // TODO: YOUR CODE HERE
        if (node == null) {
            return null;
        } else if (node.right == null) {
            return node;
        } else if ((node.left == null && node.right == null)) {
            return node;
        } else {
            RBTreeNode newLeft = new RBTreeNode(node.right.isBlack, node.item, node.left, node.right.left);
            RBTreeNode newNode = new RBTreeNode(node.isBlack, node.right.item, newLeft, node.right.right);
            return newNode;
        }


    }

    public void insert(T item) {
        root = insert(root, item);
        root.isBlack = true;
    }

    /* Inserts the given node into this Red Black Tree*/
    private RBTreeNode<T> insert(RBTreeNode<T> node, T item) {
        // Insert (return) new red leaf node.
        if (node == null) {
            return new RBTreeNode<>(false, item);
        }

        // Handle normal binary search tree insertion.
        int comp = item.compareTo(node.item);
        if (comp == 0) {
            return node; // do nothing.
        } else if (comp < 0) {
            node.left = insert(node.left, item);
        } else {
            node.right = insert(node.right, item);
        }

        // handle "middle of three" and "right-leaning red" structures
        if (!isRed(node.left) && isRed(node.right)) {
            node = rotateLeft(node.left);
        }

        // handle "smallest of three" structure
        if (isRed(node.left.left) && isRed(node.left)) {
            node = rotateRight(node);
        }
        
        // handle "largest of three" structure
        if (isRed(node.right) && isRed(node.left)) {
            flipColors(node);
        }

        // TODO: YOUR CODE HERE
//        return null; //fix this return statement
        return node;
    }

    /* Returns whether the given node NODE is red. Null nodes (children of leaf
       nodes are automatically considered black. */
    private boolean isRed(RBTreeNode<T> node) {
        return node != null && !node.isBlack;
    }

}
