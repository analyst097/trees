public class BinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
            left = null;
            ;
            right = null;
        }
    }

    static class BTree {
        static int index = -1;

        public static Node buildTree(int nodes[]) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preorderTraversal(Node node) {
            if (node == null) {
                return;
            }

            System.out.print(node.data + ", ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);

        }

        public static void inorderTraversal(Node node) {
            if (node == null) {
                return;
            }

            inorderTraversal(node.left);
            System.out.print(node.data + ", ");
            inorderTraversal(node.right);
        }

        public static void postorderTraversal(Node node) {
            if (node == null) {
                return;
            }

            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + ", ");
        }

    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = BTree.buildTree(nodes);
        System.out.println(root.data);
        System.out.println("pre order traversal");
        BTree.preorderTraversal(root);
        System.out.println("\nInorder traversal");
        BTree.inorderTraversal(root);
        System.out.println("\nPostorder traversal");
        BTree.postorderTraversal(root);
    }
}
