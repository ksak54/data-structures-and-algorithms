public class RedBlackTrees {
    Node root = null;
    static Node nill = null;

    public static class Node {
        Node left, parent, right;
        int data;
        String color;

        Node(int data) {
            this.left = nill;
            this.right = nill;
            this.parent = nill;
            this.data = data;
            this.color = "RED";
        }

        public static void leftRotate(RedBlackTrees tree, Node x) {
            Node y = x.right;
            x.right = y.left;
            if (y.left != nill) {
                y.left.parent = x;
            }
            y.left = x;
            y.parent = x.parent;
            if (x == x.parent.left) {
                x.parent.left = y;
            } else
                x.parent.right = y;
            y.left = x;
            x.parent = y;
        }

        public static void rightRotate(RedBlackTrees tree, Node x) {
            Node y = x.left;
            x.left = y.right;
            if (y.right != nill) {
                y.right.parent = x;
            }
            y.parent = x.parent;
            if (x.parent.left == x) {
                x.parent.left = y;
            } else
                x.parent.right = y;
            y.left = x;
            x.parent = y;
        }

        public static void RBinsert(RedBlackTrees tree, Node new_node) {
            Node y = nill;
            Node traverse = tree.root;
            while (traverse != nill) {
                y = traverse;
                if (new_node.data > traverse.data)
                    traverse = traverse.right;
                else
                    traverse = traverse.left;
            }
            new_node.parent = y;
            if (y == nill) {
                tree.root = new_node;
            } else if (y.data > new_node.data) {
                y.right = new_node.parent;
            } else
                y.left = new_node.parent;
            RBinsertFixup(tree, new_node);
        }

        public static void RBinsertFixup(RedBlackTrees tree, Node node) {

        }

    }

    public static void main(String[] args) {

    }
}