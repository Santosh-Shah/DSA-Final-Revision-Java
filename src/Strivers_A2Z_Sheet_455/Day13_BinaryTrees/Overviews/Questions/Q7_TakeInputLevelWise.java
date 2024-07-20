package Strivers_A2Z_Sheet_455.Day13_BinaryTrees.Overviews.Questions;

import Strivers_A2Z_Sheet_455.Day13_BinaryTrees.Overviews.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7_TakeInputLevelWise {
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


    // TODO: height of tree
    public static int treeHeight(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;

        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    //TODO: check tree is balanced or not
    public static BinaryTreeNode<Integer> takeInputLevelWise() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root data: ");
        int rootData = sc.nextInt();
        if (rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<>();
        pendingChildren.add(root);

        while (!pendingChildren.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingChildren.poll();
            System.out.println("Enter left child of " + front.data);
            int leftData = sc.nextInt();

            if (leftData != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftData);
                front.left = leftChild;
                pendingChildren.add(leftChild);
            }

            System.out.println("Enter right child of " + front.data);
            int rightData = sc.nextInt();
            if (rightData != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightData);
                front.right = rightChild;
                pendingChildren.add(rightChild);
            }
        }
        return root;
    }


    public static void main(String[] args) {
//        BinaryTreeNode<Integer> head = takeTreeInputBetter(true, 0, false);
        BinaryTreeNode<Integer> head = takeInputLevelWise();
        printTreeDetailed(head);
        System.out.println("\n-----------Output------------");
//        System.out.println("Is Balanced? " + isBalancedBetter(head).isBalanced);
    }
}

