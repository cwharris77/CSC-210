
public class ArrayQueue implements QueueInterface {

    private static final int DEFAULT_SIZE = 10;
    private int[] array;
    private int size;

    public ArrayQueue() {
        array = new int[DEFAULT_SIZE];
        size = 0;
    }

    public ArrayQueue(ArrayQueue copy) {
        this.size = copy.size;
        this.array = copy.array;
    }

    /*
     * Add an element to the back of the queue.
     * 
     * @param value - An integer to be added to the queue
     * 
     * @reurn null
     */
    @Override
    public void enqueue(int value) {
        if (size >= array.length) {
            growArray();
        }
        array[size] = value;
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
        int result = array[0];

        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;

        return result;
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
        return array[0];
    }

    /*
     * Returns true if the queue has no elements.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
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
        size = 0;
    }

    /*
     * Helper method to grow the size of the array backing the queue
     * 
     * @return null
     */
    private void growArray() {
        int[] newArray = new int[2 * array.length];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    /*
     * ToString method that returns the queue in the form
     * {val, val} where the first val is the front of the queue
     * 
     * @return ret - String representing queue
     */
    @Override
    public String toString() {
        String ret = "{";
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                ret += array[i];
            } else {
                ret += array[i] + ",";
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
        if (o instanceof ArrayQueue) {
            ArrayQueue queue = (ArrayQueue) o;
            if (queue.size != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (queue.array[i] != array[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
