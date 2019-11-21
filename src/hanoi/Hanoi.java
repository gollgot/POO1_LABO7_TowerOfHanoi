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
     * Constructor for console displaying
     * @param disks The number of disks for the hanoi tower
     */
    public Hanoi(int disks) {
        // For the console display, we use our HanoiDisplayer
        this(disks, new HanoiDisplayer());
    }

    /**
     * Full constructor (This one will be directly use by the hanoi GUI, with its own HanoiDisplayer)
     * @param disks The number of disks for the hanoi tower
     * @param displayer The displayer that will be use for the displaying
     */
    public Hanoi(int disks, HanoiDisplayer displayer) {
        this.displayer = displayer;

        // create the three needles i.e. the towers
        this.needles = new Stack[] {new Stack(), new Stack(), new Stack()};

        // add all the disks to the first needle
        for (int i = disks; i > 0; --i) {
            this.needles[0].push(i);
        }
        this.nbDisks = disks;
    }

    /**
     * Display the initial state and resolve the hanoi tower problem
     */
    public void solve() {
        this.displayer.display(this);
        this.solver(this.nbDisks, this.needles[0], this.needles[1], this.needles[2]);
    }

    /**
     * Resolve in a recursive way the hanoi tower problem. It will move a nb of disks from a niddle source to a
     * destination niddle via an auxiliary niddle.
     * @param disk The nb of disk to move
     * @param src Source The source niddle as a Stack
     * @param aux Auxiliary The auxiliary niddle as a Stack
     * @param dest The source niddle as a Stack
     */
    private void solver(int disk, Stack src, Stack aux, Stack dest) {
        if (disk == 1) {
            this.move(src, dest);
        } else {
            this.solver(disk - 1, src, dest, aux);
            this.move(src, dest);
            this.solver(disk - 1, aux, src, dest);
        }
    }

    /**
     * Move one disk from the source niddle to the destination niddle and display the state via the displayer
     * @param src The source niddle as a Stack
     * @param dest The destination niddle as a Stack
     */
    private void move(Stack src, Stack dest) {
        dest.push(src.pop());
        ++this.moves; // Increase the moves number
        this.displayer.display(this);
    }

    /**
     * Return the current number of move
     * @return The current number of move
     */
    public int turn() {
        return this.moves;
    }

    /**
     *  Check if we solved
     *  (To do that we used a formula => total moves to solve = nbDisk^2 - 1)
     * @return True if it's solved, false otherwise
     */
    public boolean finished() {
        return this.moves == Math.pow(2, this.nbDisks - 1);
    }

    /**
     * The current status of our hanoi tower (each needles and disks)
     * @return A bidimensional array that represents the current status of our hanoi tower (each needles and disks)
     */
    public int[][] status() {
        int[][] status = new int[3][];

        // Loop through all needles
        for (int i = 0; i < needles.length; ++i) {
            Object needle[] = this.needles[i].toArray();
            status[i] = new int[needle.length];
            // Loop through all disks in the needle
            for (int j = 0; j < needle.length; ++j) {
                status[i][j] = (int) needle[j];
            }
        }

        return status;
    }
}
