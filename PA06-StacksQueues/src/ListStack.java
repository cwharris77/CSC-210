public class ListStack implements StackInterface {

    private Node front;
    private Node back;
    private int size;

    public ListStack() {
        front = null;
        back = null;
        size = 0;
    }

    public ListStack(ListStack copy) {
        Node curr = copy.front;
        
        while (curr != null) {
            this.push(curr.data);
            curr = curr.next;
        }

    }

    /*
     * Add an element to the top of the stack.
     * 
     * @param value - int to be added to the stack
     */
    @Override
    public void push(int value) {
        if (front == null) {
            front = new Node(value, null);
            back = front;
        } else {
            back.next = new Node(value, null);
            back = back.next;

        }
        size++;
    }

    /*
     * Remove and return the top element in the stack.
     * 
     * If the user attempts to pop an empty stack, ignores the
     * request and returns -1.
     */
    @Override
    public int pop() {
        if (size == 0) {
            return -1;
        }
        back = front;
        while (back.next.next != null) {
            back = back.next;
        }
        int val = back.next.data;

        back.next = null;

        size--;

        return val;
    }

    /*
     * Returns but does NOT remove the front element of the stack.
     * 
     * if the stack is empty returns -1.
     */
    @Override
    public int peek() {
        if (size == 0) {
            return -1;
        }
        return back.data;
    }

    /*
     * Returns true if the stack has no elements.
     */
    @Override
    public boolean isEmpty() {
        return front == null;
    }

    /*
     * Returns the number of elements in the stack.
     */
    @Override
    public int size() {
        return size;
    }

    /*
     * Removes all elements from the stack.
     */
    @Override
    public void clear() {
        front = null;
        back = front;
        size = 0;
    }

    /*
     * Class to create nodes in the linked list backing the stack
     */
    private class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /*
     * ToString method that returns the stack in the form
     * {val, val} where the first val is the bottom of the
     * stack
     * 
     * @return ret - String representing stack
     */
    @Override
    public String toString() {
        Node curr = front;
        String ret = "{";
        while (curr != null) {
            if (curr.next == null) {
                ret += curr.data;
                curr = curr.next;
            } else {
                ret += curr.data + ",";
                curr = curr.next;
            }

        }
        ret += "}";

        return ret;
    }

    /*
     * Returns a boolean specifying if two stack objects
     * have the same size and elements in each spot.
     * 
     * @param o - an object to compare the current instance of the class to
     * 
     * @return Boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof ListStack) {
            ListStack stack = (ListStack) o;
            if (stack.size != size) {
                return false;
            }
            Node curr = stack.front;
            Node thisCurr = front;
            while (curr.next != null) {
                if (curr.data != thisCurr.data) {
                    return false;
                }
                curr = curr.next;
                thisCurr = thisCurr.next;
            }
            return true;
        }

        return false;
    }

}
