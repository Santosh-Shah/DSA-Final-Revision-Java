package Strivers_A2Z_Sheet_455.Day13_BinaryTrees.Overviews;

import java.util.Scanner;

public class BinaryTreeUse {

    public static void printBinaryTree(BinaryTreeNode<Integer> root) {
        //Base case
        if(root==null) return;

        // following PreOrder Traversal
        System.out.println(root.data);
        printBinaryTree(root.left);
        printBinaryTree(root.right);
    }

    public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
        //Base case
        if(root==null) return;

        // following PreOrder Traversal
        System.out.print(root.data + ": ");
        if (root.left != null) {
            System.out.print("L" +root.left.data + ",");
        }

        if (root.right != null) {
            System.out.print("R" +root.right.data);
        }
        System.out.println();
        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
    }


    public static BinaryTreeNode<Integer> takeTreeInput() {
        System.out.println("Enter root node: ");
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        if(data == -1) return null;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        BinaryTreeNode<Integer> leftChild = takeTreeInput();
        BinaryTreeNode<Integer> rightChild = takeTreeInput();
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }


    public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot, int parentData, boolean isLeft) {
        if(isRoot) {
            System.out.println("Enter root data: ");
        } else {
            if (isLeft) {
                System.out.println("Enter left child of " + parentData);
            } else {
                System.out.println("Enter right child of " + parentData);
            }
        }

            Scanner sc = new Scanner(System.in);
            int rootData = sc.nextInt();

            if (rootData == -1) {
                return null;
            }

            BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
            BinaryTreeNode<Integer> leftChild = takeTreeInputBetter(false, rootData, true);
            BinaryTreeNode<Integer> rightChild = takeTreeInputBetter(false, rootData, false);
            root.left = leftChild;
            root.right = rightChild;
            return root;
    }


    public static int numsNodes(BinaryTreeNode<Integer> head) {
        if (head == null) return 0;

        int leftNode = numsNodes(head.left);
        int rightNode = numsNodes(head.right);
        return 1 + leftNode + rightNode;
    }

    public static int sumOfNodes(BinaryTreeNode<Integer> head) {
        if (head == null) return 0;

        int leftNode = sumOfNodes(head.left);
        int rightNode = sumOfNodes(head.right);
        return head.data + leftNode + rightNode;
    }

    public static void printPreOrder(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void printInOrder(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void printPostOrder(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static int largestNode(BinaryTreeNode<Integer> root) {
        if (root == null) return -1;

//        int largestNode = largestDate;
//        if (root.data > largestNode) {
//            largestNode = root.data;
//        }
        int leftNode = largestNode(root.left);
        int rightNode = largestNode(root.right);
        return Math.max(root.data, Math.max(leftNode, rightNode));
    }

    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
        //Your code goes here
        if (root == null) {
            return 0;
        }

        int count = 0;
        if (root.data > x) {
            count++;
        }

        count = count + countNodesGreaterThanX(root.left, x);
        count = count + countNodesGreaterThanX(root.right, x);
        return count;
    }


    public static int heightOfTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static int countLeafNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftCount = countLeafNodes(root.left);
        int rightCount = countLeafNodes(root.right);
        return leftCount + rightCount;
    }

    public static void printNodeAtDepthK(BinaryTreeNode<Integer> root, int k) {
        if (root == null) {
            return;
        }

        if (k == 0) {
            System.out.print(root.data + " ");
            return;
        }

        printNodeAtDepthK(root.left, k - 1);
        printNodeAtDepthK(root.right, k - 1);
    }

    public static void replaceWithDepthK(BinaryTreeNode<Integer> root, int depth) {
        if (root == null) {
            return;
        }

        replaceWithDepthKHelper(root, depth, 0);
    }

    public static void replaceWithDepthKHelper(BinaryTreeNode<Integer> root, int depth, int k) {
        if (depth == k) {
            root.data = k;
            return;
        }

        replaceWithDepthKHelper(root.left, depth, k + 1);
        replaceWithDepthKHelper(root.right, depth, k + 1);
    }

    public static void main(String[] args) {
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//        BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<>(20);
//        BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<>(30);
//        BinaryTreeNode<Integer> leftTwenty = new BinaryTreeNode<>(50);
//        BinaryTreeNode<Integer> rightTwenty= new BinaryTreeNode<>(60);
//        BinaryTreeNode<Integer> thirtyLeft = new BinaryTreeNode<>(70);
//        root.left = rootLeft;
//        root.right = rootRight;
//        rootLeft.left = leftTwenty;
//        rootLeft.right = rightTwenty;
//        rootRight.left = thirtyLeft;

//        printBinaryTree(root);

//        printTreeDetailed(root);

//        BinaryTreeNode<Integer> head = takeTreeInput();
//        printTreeDetailed(head);

        BinaryTreeNode<Integer> head = takeTreeInputBetter(true, 0, false);
        printTreeDetailed(head);
        System.out.println("Number of nodes: " + numsNodes(head));
        System.out.println("Sum of nodes: " + sumOfNodes(head));

//        System.out.println("*******PreOrder Traversal******");
//        printPreOrder(head);
//
//        System.out.println();
//        System.out.println("*******InOrder Traversal******");
//        printInOrder(head);
//
//        System.out.println();
//        System.out.println("*******PostOrder Traversal******");
//        printPostOrder(head);

//        System.out.println("Largest Node: " + largestNode(head));


//        int target = 2;
//        int output = countNodesGreaterThanX(head, target);
//        System.out.println("Number of nodes greater than " + target + ": " + output);

//        System.out.println("Height of Binary Tree: " + heightOfTree(head));

//        System.out.println("Number of leafNode: " + countLeafNodes(head));

//        printNodeAtDepthK(head, 1);
        replaceWithDepthK(head, 1);
        printTreeDetailed(head);
    }
}
