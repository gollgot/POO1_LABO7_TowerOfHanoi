/*
 * Fichier : HanoiDisplayer.java
 * Auteurs : Dessaules Loïc, Kayoumi Doran
 * But     : Permet d'afficher à la console le status en cours d'un objet de type Hanoi
 * Date    : 21.11.2019
 */

package hanoi;

public class HanoiDisplayer {

    private String[] needleNames = {"One  ", "Two  ", "Three"};

    /**
     * Display the Hanoi's status
     * @param hanoi The Hanoi object for which we want to display the status
     */
    public void display(Hanoi hanoi) {
        System.out.println("-- Turn: " + hanoi.turn());
        int[][] status = hanoi.status();

        for(int row = 0; row < status.length; ++row){
            System.out.print(needleNames[row] + " : [");
            for(int col = 0; col < status[row].length; ++col){
                System.out.print(" <" + status[row][col] +">");
            }
            System.out.println(" ]");
        }

    }

}
