package util;

public class Stack {

    private Node top;
    private int size;

    public void push(Object object) {
        Node node = new Node(object);
        node.next = this.top;
        this.top = node;
        ++size;
    }

    public Object pop() {
        Object obj = this.top.element;
        this.top = this.top.next;
        --size;
        return obj;
    }

    public Object[] getArray() {
        Object[] data = new Object[size];
        Node current = top;
        for(int i = 0; current != null; ++i){
            data[i] = current.element;
            current = current.next;
        }
        return data;
    }

    /**
     * Return a String representation of the current Stack instance.
     * /!\ Careful that all Object contains in the stack override their own toString() method
     * @return A String representation of the current Stack instance
     */
    public String toString() {
        String res = "";
        Node current = top;
        for(int i = 1; current != null; ++i){
            res += "#" + i + " : " + current.element + "\n";
            current = current.next;
        }
        return res;
    }
}
