import util.Stack;
import util.StackIterator;

public class Main {

    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push(new Personne("Loic"));
        stack.push(new Personne("Jack"));
        stack.push(new Personne("Jean"));

        System.out.println(stack);

        StackIterator it = stack.iterator();
        System.out.print("[");
        for(int i = 0; it.hasNext(); ++i){
            if(i > 0){
                System.out.print(", ");
            }
            System.out.print(it.next());
        }
        System.out.println("]");

    }
}
