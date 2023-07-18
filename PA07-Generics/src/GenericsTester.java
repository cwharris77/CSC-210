import org.junit.jupiter.api.Test;

class GenericsTester {

    @Test
    void test() {
        ArrayStack<String> myStack = new ArrayStack<>();

        myStack.push("hello");
        myStack.push("world");
        myStack.push("I");
        myStack.push("am");
        myStack.push("james");


        // String x = myStack.pop();
        // x = myStack.pop();
        // x = myStack.pop();
        // x = myStack.pop();
        // x = myStack.pop();
        // x = myStack.pop();

        // myStack.push("magic");


        ArrayStack<String> copy = new ArrayStack<>(myStack);

        System.out.println("myStack = " + myStack.peek());
        System.out.println("copy = " + copy.peek());
        // System.out.println("myStack = Copy is " + );
    }

    // @Test
    // void testArrayStack() {
    // ArrayStack<String> myStack = new ArrayStack<>();
    //
    // myStack.push("hello");
    // myStack.clear();
    //
    // int x = myStack.size();
    //
    // System.out.println("myArrayStack size = " + x);
    //
    // }
    //
    // @Test
    // void testArrayQueue() {
    // ArrayQueue<Integer> myQueue = new ArrayQueue<>();
    //
    // myQueue.enqueue(3);
    // myQueue.enqueue(3);
    // myQueue.enqueue(3);
    //
    // myQueue.dequeue();
    // myQueue.dequeue();
    // myQueue.dequeue();
    // myQueue.dequeue();
    //
    // System.out.println("myQueue = " + myQueue);
    //
    // }
    //
}
