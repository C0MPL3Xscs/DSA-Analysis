/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;


public class Node implements Comparable<Node> {
    
    Object data;
    Node left;
    Node right;

    public Node(Object data) {
        this.data = data;
        left = null;
        right = null;
    }

    @Override
    public int compareTo(Node other) {
        return ((Comparable) this.data).compareTo(other.data);
    }
}

