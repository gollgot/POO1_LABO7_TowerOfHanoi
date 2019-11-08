import util.Stack;

public class Main {

    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push(new Personne("Loic"));
        stack.push(new Personne("Jack"));
        stack.push(new Personne("Jean"));

        System.out.println(stack);
        Object[] data = stack.toArray();
        ((Personne)data[0]).setName("LALA");
        System.out.println(stack);

    }
}
