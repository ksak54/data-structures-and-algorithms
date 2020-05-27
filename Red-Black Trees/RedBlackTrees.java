public class RedBlackTrees {
    Node root = null;
    Node nill = null;

    public static class Node {
        Node left, parent, right;
        int data;
        String color;

        Node(int data, String color) {
            this.left = null;
            this.right = null;
            this.parent = null;
            this.data = data;
            this.color = color;
        }

        public static void leftRotate(RedBlackTrees tree, Node x) {
            Node y = x.right;
            x.right = y.left;
            if (y.left != tree.nill) {
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
            if (y.right != tree.nill) {
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
    }

    public static void main(String[] args) {

    }
}