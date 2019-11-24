/*
 * Fichier  : Stack.java
 * Auteurs  : Dessaules Loïc, Kayoumi Doran
 * But      : Permet de représenter une pile (Last In - First Out) qui peut contenir un nombre quelconque  d'éléments
 *            de type Object. Les méthodes implémentées sont : push(), pop(), toArray(), toString(), iterator()
 * Date     : 09.11.2019
 */

package util;

public class Stack {

    private Node top;
    private int size;

    /**
     * Push an item onto the top of the Stack
     *
     * @param object to push
     */
    public void push(Object object) {
        Node node = new Node(object);
        node.next = this.top;
        this.top = node;
        ++size;
    }

    /**
     * Remove and return the top element of the Stack
     *
     * @return top element of the Stack
     * @throws RuntimeException when used on an empty Stack
     */
    public Object pop() {
        if (this.top == null) {
            throw new RuntimeException("Impossible to pop from an empty Stack");
        } else {
            Object obj = this.top.element;
            this.top = this.top.next;
            --size;
            return obj;
        }
    }

    /**
     * Create an Array representation of the Stack
     * NOTE: index 0 of the array will be the top element of the Stack
     *
     * @return Array representation of the Stack
     */
    public Object[] toArray() {
        Object[] data = new Object[size];
        Node current = top;
        for (int i = 0; current != null; ++i) {
            data[i] = current.element;
            current = current.next;
        }
        return data;
    }

    /**
     * Create a String representation of the Stack
     * NOTE: All Elements contained in the stack NEED to be displayable
     *
     * @return String representation of the Stack
     */
    public String toString() {
        String res = "";
        res += "[";
        Node current = top;
        while (current != null) {
            res += " " + current.element;
            current = current.next;
        }
        res += " ]";

        return res;
    }

    /**
     * Create a StackIterator pointing before the first element of the Stack
     *
     * @return StackIterator
     */
    public StackIterator iterator() {
        Node nodeBefore = new Node(null);
        nodeBefore.next = this.top;
        return new StackIterator(nodeBefore);
    }
}
