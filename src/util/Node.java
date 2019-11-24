/*
 * Fichier  : Node.java
 * Auteurs  : Dessaules Loïc, Kayoumi Doran
 * But      : Permet de représenter un noeud qui se compose d'un élément de type Objet et d'une référence vers
 *            le noeud suivant
 * Date     : 09.11.2019
 */

package util;

class Node {
    Object element;
    Node next;

    Node(Object element) {
        this.element = element;
    }
}
