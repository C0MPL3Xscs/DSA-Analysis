/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import utils.BooleanWrapper;

public class BinaryTree {

    private Node root;

    public BinaryTree() {
        root = null;
    }

    // Adds a new node to the binary tree
    public void add(Object data) {
        root = addRecursive(root, data);
    }

    // Recursive helper method for add() -> traverses the tree recursively to find the right place to insert the new node
    private Node addRecursive(Node current, Object data) {
        if (current == null) {
            return new Node(data);
        }

        if (((Comparable) data).compareTo(current.data) < 0) {
            current.left = addRecursive(current.left, data);
        } else if (((Comparable<Object>) data).compareTo(current.data) > 0) {
            current.right = addRecursive(current.right, data);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    // Searches the binary tree for the node that contains the value of "data" and returns true if found and false otherwise
    public boolean search(Object data) {
        return searchRecursive(root, data);
    }

    // Recursive helper method for search() -> traverses the tree recursively to find the node with the value of "data"
    private boolean searchRecursive(Node current, Object data) {
        if (current == null) {
            return false;
        }

        if (compare(data, current.data) == 0) {
            return true;
        }

        if (compare(data, current.data) < 0) {
            return searchRecursive(current.left, data);
        } else {
            return searchRecursive(current.right, data);
        }
    }

    // Removes the node from the tree that contains the value of "data" and returns true if found and removed, false otherwise
    public boolean remove(Object data) {
        BooleanWrapper isRemoved = new BooleanWrapper(false);
        root = removeRecursive(root, data, isRemoved);
        return isRemoved.get();
    }

    // Recursive helper method for remove() -> traverses the tree recursively to find the node with the value of "data" and remove it
    private Node removeRecursive(Node current, Object data, BooleanWrapper isRemoved) {
        if (current == null) {
            return null;
        }

        if (compare(data, current.data) == 0) {
            // found the node to remove
            isRemoved.set(true);

            // case 1: node has no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // case 2: node has one child
            if (current.left == null) {
                return current.right;
            }

            if (current.right == null) {
                return current.left;
            }

            // case 3: node has two children
            Object smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = removeRecursive(current.right, smallestValue, isRemoved);
            return current;
        }

        if (compare(data, current.data) < 0) {
            current.left = removeRecursive(current.left, data, isRemoved);
            return current;
        }

        current.right = removeRecursive(current.right, data, isRemoved);
        return current;
    }

    // Helper method that finds the smallest value of a subtree with the root as the given node
    private Object findSmallestValue(Node node) {
        return node.left == null ? node.data : findSmallestValue(node.left);
    }

    // Helper method that compares two objects using their natural order
    private int compare(Object a, Object b) {
        Comparable<Object> compA = (Comparable<Object>) a;
        return compA.compareTo(b);
    }

    // Helper method that prints the tree to the console
    public void print() {
        printTreeRecursive(root, "");
    }

    // Recursive helper method for print() -> prints the tree recursively until reaching the end
    private void printTreeRecursive(Node node, String prefix) {
        if (node == null) {
            return;
        }

        System.out.println(prefix + node.data);
        printTreeRecursive(node.left, prefix + "- ");
        printTreeRecursive(node.right, prefix + "- ");
    }

    // Balances the binary tree by storing all its nodes in a LinkedList using the storeBSTNodes helper method.
    public void balance() {
        LinkedList nodes = new LinkedList();
        storeBSTNodes(root, nodes);
        root = buildTreeUtil(nodes, 0, nodes.size() - 1);
    }

    // Helper method that traverses the tree and adds the nodes to the LinkedList passed as a parameter.
    private void storeBSTNodes(Node root, LinkedList nodes) {
        if (root == null) {
            return;
        }

        storeBSTNodes(root.left, nodes);
        nodes.addOrd(root);
        storeBSTNodes(root.right, nodes);
    }

    // Responsible for constructing a new balanced tree from the nodes stored in the LinkedList.
    private Node buildTreeUtil(LinkedList nodes, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = (Node) nodes.get(mid).data;
        node.left = buildTreeUtil(nodes, start, mid - 1);
        node.right = buildTreeUtil(nodes, mid + 1, end);
        return node;
    }

}
