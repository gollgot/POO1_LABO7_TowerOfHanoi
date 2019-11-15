import hanoi.Hanoi;
import hanoi.gui.JHanoi;
import util.Stack;
import util.StackIterator;

public class Main {

    /**
     * Test our Stack class with a lot of different cases
     */
    private static void testStack() {
        Stack stack = new Stack();

        System.out.println("-- Push 1,2,3 into the stack and display it --");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.print(stack + "\n");

        System.out.println("-- Remove the element on the top with pop() and display it --");
        System.out.println(stack.pop() + "\n");

        System.out.println("-- Display the stack using StackIterator (top element on the left) --");
        StackIterator it = stack.iterator();
        System.out.print("[");
        for(int i = 0; it.hasNext(); ++i){
            if(i > 0){
                System.out.print(",");
            }
            System.out.print(it.next());
        }
        System.out.println("]\n");

        System.out.println("-- Call iterator.next() when we already go through all element --");
        try{
            it.next();
        }catch(RuntimeException e){
            System.out.println("RuntimeException : " + e.getMessage() + "\n");
        }

        System.out.println("-- Push 5,6 and display the array we have using toArray() method on the stack (top element on the left) --");
        stack.push(5);
        stack.push(6);
        Object[] array = stack.toArray();
        System.out.print("[");
        int j = 0;
        for(Object o : array){
            if(j > 0){
                System.out.print(",");
            }
            System.out.print(o);
            ++j;
        }
        System.out.println("]\n");

        System.out.println("-- Pop all elements and display the stack --");
        it = stack.iterator();
        while(it.hasNext()){
            stack.pop();
            it.next();
        }
        System.out.println(stack + "\n");

        System.out.println("-- Call the pop() method when the stack is empty --");
        try {
            stack.pop();
        }catch(RuntimeException e) {
            System.out.println("RuntimeException : " + e.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {

        // No arguments => Run the graphical display
        if(args.length == 0){
            JHanoi j = new JHanoi();
        }
        // One argument (int > 0) => Run the console display
        else if(args.length == 1) {
            try{
                int disks;
                disks = Integer.parseInt(args[0]);
                if(disks > 0){
                    Hanoi h = new Hanoi(disks);
                    h.solve();
                }else{
                    System.err.println("Argument must be greater than 0");
                }
            }
            catch(NumberFormatException e){
                System.err.println("Argument must be an integer value");
            }


        }
        // Too many argument
        else {
            System.err.println("Only one argument is required");
        }

        //testStack();





        // todo : Faire le programme de test avec lecture du nb de disk en ligne de commande (dernier point slide labo)

    }
}
