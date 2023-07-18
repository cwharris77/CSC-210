
public class ArrayStack implements StackInterface {
    private static final int DEFAULT_SIZE = 10;
    private int[] array;
    private int size;

    public ArrayStack() {
        array = new int[DEFAULT_SIZE];
        size = 0;
    }

    public ArrayStack(ArrayStack copy) {
        this.size = copy.size;
        this.array = copy.array;
    }

    /*
     * Add an element to the top of the stack.
     * 
     * @param value - int to be added to the stack
     */
    @Override
    public void push(int value) {
        if (size >= array.length) {
            growArray();
        }
        array[size] = value;
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
        int result = array[0];

        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;

        return result;
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
        return array[size - 1];
    }

    /*
     * Returns true if the stack has no elements.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
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
        size = 0;
    }

    /*
     * Helper method to grow the size of the array backing the stack.
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
     * ToString method that returns the stack in the form
     * {val, val} where the first val is the bottom of the
     * stack
     * 
     * @return ret - String representing stack
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
     * Returns a boolean specifying if two stack objects
     * have the same size and elements in each spot.
     * 
     * @param o - an object to compare the current instance of the class to
     * 
     * @return Boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof ArrayStack) {
            ArrayStack stack = (ArrayStack) o;
            if (stack.size != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (stack.array[i] != array[i]) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

}
