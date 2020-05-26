public class BinarySearchTrees {
    Node root = null;

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

    public static Node searchByKey(BinarySearchTrees tree, int key) {
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

    public static Node treeMaximum(BinarySearchTrees tree) {
        System.out.print("\nThe minimum value is: ");
        Node traverse = tree.root;
        Node maxNode = null;
        while (traverse != null) {
            maxNode = traverse;
            traverse = traverse.right;
        }
        return maxNode;
    }

    public static Node treeMinimum(BinarySearchTrees tree, Node x) {
        System.out.print("\nThe minimum value is: ");
        Node traverse = tree.root;
        Node minNode = null;
        while (traverse != null) {
            minNode = traverse;
            traverse = traverse.right;
        }
        return minNode;
    }

    public static Node successor(BinarySearchTrees tree, Node x) {
        if (x.right != null) {
            return treeMinimum(tree, x);
        }
        Node y = x.parent;
        while (y != null && x == y.right) {
            y = x.parent;
            x = y;
        }
        return y;
    }

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
        System.out.println("\nThe tree is (inorder): ");
        inorderTreeWalk(tree.root);
        System.out.print(treeMaximum(tree).data);
    }
}