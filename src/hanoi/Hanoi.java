package hanoi;

import util.Stack;

public class Hanoi {
    private int moves;
    private int lastDiskNo;
    private Stack[] needles;

    public Hanoi(int disks) {
        // create the three needles i.e. the towers
        this.needles = new Stack[] {new Stack(), new Stack(), new Stack()};

        // add all the disks to the first needle
        for (int i = disks; i > 0; --i) {
            this.needles[0].push(new Disk(i));
        }
        this.lastDiskNo = disks;
    }

    public void solve() {
        this.solver(this.lastDiskNo, this.needles[0], this.needles[1], this.needles[2]);
    }

    private void solver(int disk, Stack src, Stack aux, Stack dest) {
        if (disk == 1) {
            dest.push(src.pop());
        } else {
            solver(disk - 1, src, dest, aux);
            dest.push(src.pop());
            solver(disk - 1, aux, src, dest);
        }
    }

    private void display() {
        int i = 1;
        for(Stack needle : needles){
            System.out.println(i + ":   " + needle);
            ++i;
        }
    }

    /*
    public int[][] status() {
    }

    public boolean finished() {
    }

    public int turn() {
    }
    */
}
