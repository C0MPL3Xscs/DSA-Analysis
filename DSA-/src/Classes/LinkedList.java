/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

public class LinkedList {

    private Item head;
    private Item tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Method that adds an element to the end of the list
    public void addLast(Object o) {
        Item item = new Item();
        item.data = o;
        if (head == null) {
            head = item;
            tail = item;
        } else {
            tail.next = item;
            tail = item;
        }
    }

    // Method that removes an element given its value "data"
    public boolean remove(Object data) {
        if (head == null) {
            return false;
        }

        if (head.data.equals(data)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return true;
        }

        Item current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                if (current.next == null) {
                    tail = current;
                }
                return true;
            }
            current = current.next;
        }

        return false;
    }

    // Method that checks if an element is in the list, returns "true" if found and "false" otherwise
    public boolean contains(Object data) {
        Item aux = head;
        while (aux != null) {
            if (aux.data.equals(data)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    // Method that inserts a new element in the correct position (maintaining the ordered list)
    public void addOrd(Object data) {
        Item item = new Item();
        item.data = data;
        if (head == null) {
            head = item;
            tail = item;
        } else {
            Item current = head;
            Item previous = null;
            while (current != null && ((Comparable) current.data).compareTo(data) < 0) {
                previous = current;
                current = current.next;
            }
            if (previous == null) {
                head = item;
            } else {
                previous.next = item;
            }
            item.next = current;
            if (current == null) {
                tail = item;
            }
        }
    }

    // Helper method that prints the List to the console
    public void print() {
        Item aux = head;
        while (aux.next != null) {
            System.out.println(aux.data.toString());
            aux = aux.next;
        }
    }

    // Helper method that returns an Item object based on its index in the list
    public Item get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        Item current = head;
        int i = 0;
        while (current != null && i < index) {
            current = current.next;
            i++;
        }

        return current;
    }

    // Helper method that returns the current size of the linked list
    public int size() {
        int size = 0;
        Item aux = head;
        while (aux.next != null) {
            size++;
            aux = aux.next;
        }
        return size;
    }

}
