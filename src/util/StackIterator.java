/*
 * Fichier  : StackIterator.java
 * Auteurs  : Dessaules Loïc, Kayoumi Doran
 * But      : Permet de représenter un iterateur afin de pouvoir itérer à travers chaque éléments
 *            de la pile associée
 * Date     : 09.11.2019
 */

package util;

public class StackIterator {
    private Node node;

    StackIterator(Node node) {
        this.node = node;
    }

    /**
     * Check if there is a next Element
     *
     * @return True if the iteration has more elements, false otherwise
     */
    public boolean hasNext() {
        return node.next != null;
    }

    /**
     * Get the next Element in the Stack
     *
     * @return next Element of the Stack
     * @throws RuntimeException if there isn't any next Element
     */
    public Object next() {
        if (node.next == null) {
            throw new RuntimeException("The Stack has no more elements");
        }
        node = node.next;
        return node.element;
    }
}
