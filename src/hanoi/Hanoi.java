package hanoi;

import util.Stack;

public class Hanoi {
    private int moves;
    private int nbDisks;
    private Stack[] needles;

    public Hanoi(int disks) {
        // create the three needles i.e. the towers
        this.needles = new Stack[] {new Stack(), new Stack(), new Stack()};

        // add all the disks to the first needle
        for (int i = disks; i > 0; --i) {
            this.needles[0].push(i);
        }
        this.nbDisks = disks;
    }

    public Hanoi(int disks, HanoiDisplayer displayer) {

    }

    public void solve() {
        this.display();
        this.solver(this.nbDisks, this.needles[0], this.needles[1], this.needles[2]);
    }

    private void solver(int disk, Stack src, Stack aux, Stack dest) {
        if (disk == 1) {
            this.move(src, dest);
        } else {
            solver(disk - 1, src, dest, aux);
            this.move(src, dest);
            solver(disk - 1, aux, src, dest);
        }
    }

    private void move(Stack src, Stack dest) {
        dest.push(src.pop());
        ++this.moves;
        this.display();
    }

    private void display() {
        int i = 1;
        System.out.println("-- Turn: " + this.turn());
        for(Stack needle : needles){
            System.out.println(i + ":   " + needle);
            ++i;
        }
    }

    public int turn() {
        return this.moves;
    }

    public boolean finished() {
        return this.moves == Math.pow(2, this.nbDisks - 1);
    }

    public int[][] status() {
        int[][] status = new int[3][];

        for (int i = 0; i < 3; ++i) {
            Object needle[] = this.needles[i].toArray();
            status[i] = new int[needle.length];

            for (int j = 0; j < needle.length; ++j) {
                status[i][j] = (int) needle[j];
            }
        }

        return status;
    }
}
