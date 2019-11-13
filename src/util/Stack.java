/*
 * Fichier  : Stack.java
 * Auteurs  : Dessaules Loïc, Kayoumi Doran
 * But      : Permet de représenter une pile simple (Last In - First Out) qui peut contenir un nombre quelconque
 *            d'éléments de type Object. Les méthodes implémentées sont : push(), pop(), toArray(), toString(), iterator()
 * Date     : 09.11.2019
 */

package util;

public class Stack {

    private Node top;
    private int size;

    /**
     * Pushes an item onto the top of the stack
     * @param object the object we want to push
     */
    public void push(Object object) {
        Node node = new Node(object);
        node.next = this.top;
        this.top = node;
        ++size;
    }

    /**
     * Removes the object at the top of the stack and returns that object
     * @throws RuntimeException if the tack is empty
     * @return The object at the top of the stack
     */
    public Object pop() {
        if(this.top == null){
            throw new RuntimeException("Impossible to pop from an empty stack");
        }else {
            Object obj = this.top.element;
            this.top = this.top.next;
            --size;
            return obj;
        }
    }

    // todo : Est ce qu on autorise de renvoyer un tableau vide dans le cas d'une stack vide ? (CF stack java)

    /**
     * Returns an array containing all of the objects in the Stack in the correct order
     * (index 0 of the array will be the object at the top of the Stack)
     * @return An array containing all of the objects in the Stack
     */
    public Object[] toArray() {
        Object[] data = new Object[size];
        Node current = top;
        for(int i = 0; current != null; ++i){
            data[i] = current.element;
            current = current.next;
        }
        return data;
    }

    /**
     * Returns The String representation of the Stack, containing a String representation of each object.
     * All Object contains in the stack must be representative as a String
     * @return The String representation of the Stack
     */
    public String toString() {
        String res = "";
        res += "[";
        Node current = top;
        for (int i = 1; current != null; ++i) {
            res += " " + current.element;
            current = current.next;
        }
        res += "]";

        return res;
    }

    /**
     * Returns an iterator over the objects in the Stack in proper sequence
     * @return An iterator over the objects in the Stack in proper sequence
     */
    public StackIterator iterator() {
        Node nodeBefore = new Node(null);
        nodeBefore.next = this.top;
        return new StackIterator(nodeBefore);
    }
}
