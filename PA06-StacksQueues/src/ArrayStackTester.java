import org.junit.jupiter.api.Test;

class ArrayStackTester {


    @Test
    void testToString() {
        ListStack myStack = new ListStack();
        ArrayStack myStack2 = new ArrayStack();

        myStack.push(15);
        myStack.push(1);
        myStack.push(25);
        myStack.push(84);
        myStack.clear();
        myStack.push(15);

        myStack2.push(15);
        myStack2.push(15);
        myStack2.pop();

        System.out.println(myStack);

        // System.out.println(myStack.equals(myStack2));
    }

    @Test
    void testToString2() {
        ListStack myStack = new ListStack();
        ListStack myStack2 = new ListStack();

        myStack.push(15);
        myStack.push(2);
        myStack.push(3);
        int x = myStack.pop();

        myStack2.push(15);
        myStack2.push(2);
        myStack2.push(3);
        int y = myStack2.pop();

        // System.out.println(myStack);
        // System.out.println(myStack.equals(myStack2));

    }

    @Test
    void testQueue() {
        ListQueue queue = new ListQueue();
        ArrayQueue queue2 = new ArrayQueue();

        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();

        queue2.enqueue(0);
        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);

        ListQueue myCopy = new ListQueue(queue);

        // System.out.println(myCopy);
        // System.out.println(queue.size());

        // System.out.println(myCopy.size());
    }
}
