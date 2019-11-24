/*
 * Fichier  : Hanoi.java
 * Auteurs  : Dessaules Loïc, Kayoumi Doran
 * But      : Permet de représenter une tour de Hanoi et résoudre le problème du déplacement de disque
 * Date     : 21.11.2019
 */

package hanoi;

import util.Stack;

public class Hanoi {
    private int moves;
    private int nbDisks;
    private Stack[] needles;
    private HanoiDisplayer displayer;

    /**
     * @param disks number of disks for the Hanoi tower
     */
    public Hanoi(int disks) {
        // For the console display, we use our HanoiDisplayer
        this(disks, new HanoiDisplayer());
    }

    /**
     * @param disks     number of disks for the hanoi tower
     * @param displayer used to display the tower
     */
    public Hanoi(int disks, HanoiDisplayer displayer) {
        this.displayer = displayer;

        // create the three needles i.e. the towers
        this.needles = new Stack[]{new Stack(), new Stack(), new Stack()};

        // add all the disks to the first needle
        for (int i = disks; i > 0; --i) {
            this.needles[0].push(i);
        }
        this.nbDisks = disks;
    }

    /**
     * Solve the Hanoi problem
     */
    public void solve() {
        // display the initial state of the tower
        this.displayer.display(this);
        // run the solver \o/
        this.solver(this.nbDisks, this.needles[0], this.needles[1], this.needles[2]);
    }

    /**
     * Solve the Hanoi towers problem using recursion.
     * NOTE: The disks will be move from a `source` needle to a `destination` needle using
     * an auxiliary one.
     *
     * @param nbDisks The nb of disk to move
     * @param src  source needle
     * @param aux  auxiliary needle
     * @param dest destination needle
     */
    private void solver(int nbDisks, Stack src, Stack aux, Stack dest) {
        if (nbDisks == 1) {
            this.move(src, dest);
        } else {
            this.solver(nbDisks - 1, src, dest, aux);
            this.move(src, dest);
            this.solver(nbDisks - 1, aux, src, dest);
        }
    }

    /**
     * Move a disk from a source needle to a destination needle and display the current state of the tower
     *
     * @param src  source needle
     * @param dest destination needle
     */
    private void move(Stack src, Stack dest) {
        dest.push(src.pop());
        ++this.moves;
        this.displayer.display(this);
    }

    /**
     * Return the current number of move
     *
     * @return current number of move
     */
    public int turn() {
        return this.moves;
    }

    /**
     * Check if the problem was solved
     * NOTE: if the current nb of moves is equal to 2^nbDisk - 1 then the problem if finished \o/
     *
     * @return True if it's solved, otherwise false
     */
    public boolean finished() {
        return this.moves == Math.pow(2, this.nbDisks - 1);
    }

    /**
     * The current state of the Hanoi towers
     *
     * @return Bidimensional Array representing the current state of the Hanoi tower
     */
    public int[][] status() {
        int[][] status = new int[3][];

        // Loop through all needles
        for (int i = 0; i < needles.length; ++i) {
            Object[] needle = this.needles[i].toArray();
            status[i] = new int[needle.length];
            // Loop through all disks in the needle
            for (int j = 0; j < needle.length; ++j) {
                status[i][j] = (int) needle[j];
            }
        }

        return status;
    }
}
