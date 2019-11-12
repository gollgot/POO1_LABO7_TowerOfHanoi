/*
 * Fichier  : StackIterator.java
 * Auteurs  : Dessaules Loïc, Kayoumi Doran
 * But      : Permet de représenter un iterateur afin de pouvoir itérer à travers chaque éléments de la pile associée
 * Date     : 09.11.2019
 */

package util;

public class StackIterator {
    private Node node;

    StackIterator (Node node) {
        this.node = node;
    }

    /**
     * Check if the iteration has more elements
     * @return True if the iteration has more elements, false otherwise
     */
    public boolean hasNext() {
        return node.next != null;
    }

    /**
     * Returns the next element in the iteration
     * @throws RuntimeException if the iteration has no more elements
     * @return The next element in the iteration
     */
    public Object next() {
        if(node.next == null){
            throw new RuntimeException("The iteration has no more elements");
        }
        node = node.next;
        return node.element;
    }
}
