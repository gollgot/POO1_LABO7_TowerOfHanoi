package hanoi;

public class HanoiDisplayer {

    private String[] conversionTable = {"One  ", "Two  ", "Three"};

    public void display(Hanoi hanoi) {
        System.out.println("-- Turn: " + hanoi.turn());
        int[][] status = hanoi.status();

        for(int row = 0; row < status.length; ++row){
            System.out.print(conversionTable[row] + " : [");
            for(int col = 0; col < status[row].length; ++col){
                System.out.print(" <" + status[row][col] +">");
            }
            System.out.println(" ]");
        }

    }

}
