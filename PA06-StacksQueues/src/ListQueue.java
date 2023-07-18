public class ListQueue implements QueueInterface {

    private Node front;
    private Node back;
    private int size;

    public ListQueue() {
        front = null;
        back = null;
        size = 0;
    }

    public ListQueue(ListQueue copy) {
        Node curr = copy.front;

        while (curr != null) {
            this.enqueue(curr.data);
            curr = curr.next;
        }
    }

    /*
     * Add an element to the back of the queue.
     * 
     * @param value - An integer to be added to the queue
     * 
     * @return null
     */
    @Override
    public void enqueue(int value) {
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
     * Remove and return the front element in the queue.
     * If the user attempts to dequeue from an empty queue returns -1.
     * 
     * @return the element at the front of the queue
     */
    @Override
    public int dequeue() {
        if (size == 0) {
            return -1;
        }
        int val = front.data;

        front = front.next;

        size--;

        return val;
    }

    /*
     * Returns but does NOT remove the front element of the queue.
     * 
     * if the queue is empty returns -1.
     */
    @Override
    public int peek() {
        if (size == 0) {
            return -1;
        }
        return front.data;
    }

    /*
     * Returns true if the queue has no elements.
     */
    @Override
    public boolean isEmpty() {
        return front == null;
    }

    /*
     * Returns the number of elements in the queue.
     */
    @Override
    public int size() {
        return size;
    }

    /*
     * Removes all elements from the queue.
     * 
     * @return null
     */
    @Override
    public void clear() {
        front = null;
        back = front;
        size = 0;
    }

    /*
     * Class to create nodes in the linked list backing the queue
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
     * ToString method that returns the queue in the form
     * {val, val} where the first val is the front of the queue
     * 
     * @return ret - String representing queue
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
     * Returns a boolean specifying if two queue objects
     * have the same size and elements in each spot.
     * 
     * @param o - an object to compare the current instance of the class to
     * 
     * @return Boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof ListQueue) {
            ListQueue queue = (ListQueue) o;
            if (queue.size != size) {
                return false;
            }
            Node curr = queue.front;
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
