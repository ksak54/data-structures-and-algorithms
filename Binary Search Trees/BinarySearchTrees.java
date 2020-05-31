public class BinarySearchTrees {
    Node root = null;

    // Node class
    public static class Node {
        Node left;
        Node right;
        Node parent;
        int data;

        Node(int data) {
            this.left = null;
            this.right = null;
            this.parent = null;
            this.data = data;
        }
    }

    // search a node in a tree by key
    public static Node searchByKey(BinarySearchTrees tree, int key) throws NullPointerException {
        Node searchNode = tree.root;
        while (searchNode != null && searchNode.data != key) {
            if (searchNode.data > key) {
                searchNode = searchNode.left;
            } else
                searchNode = searchNode.right;
        }
        if (searchNode == null) {
            return null;
        } else
            return searchNode;
    }

    // Finding the minimum value Node from a given node
    public static Node treeMinimum(BinarySearchTrees tree, Node x) {

        Node traverse = x;
        Node maxNode = null;
        while (traverse != null) {
            maxNode = traverse;
            traverse = traverse.left;
        }
        return maxNode;
    }

    // Finding the maximum value Node from a give node
    public static Node treeMaximum(BinarySearchTrees tree, Node x) {

        Node traverse = x;
        Node minNode = null;
        while (traverse != null) {
            minNode = traverse;
            traverse = traverse.right;
        }
        return minNode;
    }

    // Finding the next least maximum value of a given node in tree
    public static Node successor(BinarySearchTrees tree, Node x) throws NullPointerException {
        Node m = x;
        if (x.right != null) {
            return treeMinimum(tree, x.right);
        }
        Node y = x.parent;
        while (y != null && x == y.right) {

            x = y;
            y = y.parent;
        }
        if (y == null) {
            System.out.println("\nNo successor found!! (Largest node)");
            return null;
        } else {
            System.out.print("Sucessor of " + m.data + ": ");
            return y;
        }
    }

    // Adding a Node to the tree
    public static void insert(BinarySearchTrees tree, int data) {
        Node traverse = tree.root;
        Node p = null;
        Node insert_node = new Node(data);
        while (traverse != null) {
            p = traverse;
            if (data > traverse.data) {
                traverse = traverse.right;
            } else
                traverse = traverse.left;
        }
        insert_node.parent = p;
        if (p == null) {
            tree.root = insert_node;
        } else if (data > p.data) {
            p.right = insert_node;
        } else {
            p.left = insert_node;
        }
    }

    // Changing child of parent of Node to be deleted
    public static void transplant(BinarySearchTrees tree, Node del, Node rep) {
        if (del.parent == null) {
            tree.root = rep;
        } else if (del == del.parent.left) {
            del.parent.left = rep;
        } else {
            del.parent.right = rep;
        }
        if (rep != null)
            rep.parent = del.parent;
    }

    // deletion of Node
    public static void deleteNode(BinarySearchTrees tree, int data) {
        Node del = searchByKey(tree, data);
        if (del.right == null) {
            transplant(tree, del, del.left);
        } else if (del.left == null) {
            transplant(tree, del, del.right);
        } else {
            Node y = treeMinimum(tree, del.right);
            if (y != del.right) {
                transplant(tree, y, y.right);
                y.right = del.right;
                y = y.right.parent;
            }
            transplant(tree, del, y);
            y.left = del.left;
            y = del.left.parent;
        }
    }

    // Invert tree
    public static void invert(Node x) {
        if (x != null) {
            swap(x);
            invert(x.left);
            invert(x.right);
        }
    }

    // swapping child nodes
    public static void swap(Node x) {
        Node temp = x.left;
        x.left = x.right;
        x.right = temp;
    }

    // printing tree in indorder
    public static void inorderTreeWalk(Node x) {

        if (x != null) {
            inorderTreeWalk(x.left);
            System.out.println(x.data + " ");
            inorderTreeWalk(x.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTrees tree = new BinarySearchTrees();
        insert(tree, 15);
        insert(tree, 6);
        insert(tree, 18);
        insert(tree, 3);
        insert(tree, 7);
        insert(tree, 17);
        insert(tree, 20);
        insert(tree, 2);
        insert(tree, 4);
        insert(tree, 13);
        insert(tree, 9);

        System.out.println("\nThe tree is (inorder): ");
        inorderTreeWalk(tree.root);
        System.out.println("Finding maximum of Node of tree");

        System.out.print(treeMaximum(tree, tree.root).data);
        System.out.println();

        try {
            System.out.print(successor(tree, searchByKey(tree, 13)).data);
        } catch (NullPointerException ex) {

        }
        System.out.println("\nDeleting Node with data = 6");
        deleteNode(tree, 6);
        System.out.println("\nAfter deletion of Node with data = 6 The tree is (inorder): ");
        inorderTreeWalk(tree.root);

        invert(tree.root);
        inorderTreeWalk(tree.root);
    }
}
