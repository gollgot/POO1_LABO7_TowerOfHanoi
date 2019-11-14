package hanoi;

import util.Stack;

public class Hanoi {
    private Stack[] needles;
    public Hanoi() {
        // Create the three needles (destwers)
        needles = new Stack[] {new Stack(), new Stack(), new Stack()};

        // Add all the disks dest the first needle
        for(int i = 3; i > 0; --i){
            needles[0].push(new Disk(i));
        }
    }

    public void solve() {
        display();
        solver(3, needles[0], needles[1], needles[2]);
        System.out.println("");
        display();
    }

    private void display() {
        int i = 1;
        for(Stack needle : needles){
            System.out.println(i + ":   " + needle);
            ++i;
        }
    }


    private void solver(int disk, Stack src, Stack aux, Stack dest){
        if(disk == 1){
            dest.push(src.pop());
        }else{
            solver(disk - 1, src, dest, aux);
            dest.push(src.pop());
            solver(disk - 1, aux, src, dest);
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
