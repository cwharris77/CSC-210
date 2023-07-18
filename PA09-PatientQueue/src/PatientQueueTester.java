import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PatientQueueTester {

    @Test
    void testPeekEmpty() {
        PatientQueue myQueue = new PatientQueue();

        IndexOutOfBoundsException thrown = Assertions
                .assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    myQueue.peek();
                });

        Assertions.assertEquals("There is nothing in the queue!",
                thrown.getMessage());
    }

    @Test
    void testBubbleUp() {
        PatientQueue myQueue = new PatientQueue();
        Patient annat = new Patient("annat", 4);
        Patient ben = new Patient("ben", 9);
        Patient sasha = new Patient("sahsa", 8);
        Patient wu = new Patient("wu", 7);
        Patient rein = new Patient("rein", 6);
        Patient ford = new Patient("ford", 2);
        // Patient eve = new Patient("eve", 3);

        myQueue.enqueue(annat);
        myQueue.enqueue(ben);
        myQueue.enqueue(sasha);
        myQueue.enqueue(wu);
        myQueue.enqueue(rein);
        myQueue.enqueue(ford);
        myQueue.enqueue("eve", 3);

        // System.out.println(myQueue.toString());
    }

    @Test
    void testBubbleDown() {
        PatientQueue myQueue = new PatientQueue();
        Patient annat = new Patient("annat", 4);
        Patient ben = new Patient("ben", 9);
        Patient sasha = new Patient("sahsa", 8);
        Patient wu = new Patient("wu", 7);
        Patient rein = new Patient("rein", 6);
        Patient ford = new Patient("ford", 2);
        // Patient eve = new Patient("eve", 3);

        myQueue.enqueue(annat);
        myQueue.enqueue(ben);
        myQueue.enqueue(sasha);
        myQueue.enqueue(wu);
        myQueue.enqueue(rein);
        myQueue.enqueue(ford);
        myQueue.enqueue("eve", 3);

        // System.out.println(myQueue.toString());

        myQueue.dequeue();

        // System.out.println(myQueue.toString());
    }

    @Test
    void testChangePriority() {
        PatientQueue myQueue = new PatientQueue();

        Patient annat = new Patient("annat", 4);
        Patient annat2 = new Patient("annat", 7);
        Patient ben = new Patient("ben", 9);
        Patient sasha = new Patient("sahsa", 8);
        Patient wu = new Patient("wu", 7);
        Patient rein = new Patient("rein", 6);
        Patient ford = new Patient("ford", 2);
        Patient eve = new Patient("eve", 3);

        myQueue.enqueue(annat);
        myQueue.enqueue(ben);
        myQueue.enqueue(sasha);
        myQueue.enqueue(wu);
        myQueue.enqueue(rein);
        myQueue.enqueue(ford);
        myQueue.enqueue(eve);
        myQueue.enqueue(annat2);

        myQueue.changePriority("annat", 0);
        myQueue.changePriority("wu", 0);
        myQueue.changePriority("eve", 4);

        // System.out.println(myQueue.toString());
    }

    @Test
    void testClear() {
        PatientQueue myQueue = new PatientQueue();

        Patient annat = new Patient("annat", 4);
        Patient annat2 = new Patient("annat", 7);
        Patient ben = new Patient("ben", 9);
        Patient sasha = new Patient("sahsa", 8);
        Patient wu = new Patient("wu", 7);
        Patient rein = new Patient("rein", 6);
        Patient ford = new Patient("ford", 2);
        Patient eve = new Patient("eve", 3);

        myQueue.enqueue(annat);
        myQueue.enqueue(ben);
        myQueue.enqueue(sasha);
        myQueue.enqueue(wu);
        myQueue.enqueue(rein);
        myQueue.enqueue(ford);
        myQueue.enqueue(eve);
        myQueue.enqueue(annat2);

        myQueue.clear();

        // System.out.println(myQueue.toString());
    }

    @Test
    void testPeek() {
        PatientQueue myQueue = new PatientQueue();

        Patient annat = new Patient("annat", 4);
        Patient annat2 = new Patient("annat", 7);
        Patient ben = new Patient("ben", 9);
        Patient sasha = new Patient("sahsa", 8);
        Patient wu = new Patient("wu", 7);
        Patient rein = new Patient("rein", 6);
        Patient ford = new Patient("ford", 2);
        Patient eve = new Patient("eve", 3);

        myQueue.enqueue(annat);
        myQueue.enqueue(ben);
        myQueue.enqueue(sasha);
        myQueue.enqueue(wu);
        myQueue.enqueue(rein);
        myQueue.enqueue(ford);
        myQueue.enqueue(eve);
        myQueue.enqueue(annat2);

        System.out.println(myQueue);
        System.out.println(myQueue.peekPriority());

    }

    @Test
    void testSize() {
        PatientQueue myQueue = new PatientQueue();

        Patient annat = new Patient("annat", 4);
        Patient annat2 = new Patient("annat", 7);
        Patient ben = new Patient("ben", 9);
        Patient sasha = new Patient("sahsa", 8);
        Patient wu = new Patient("wu", 7);
        Patient rein = new Patient("rein", 6);
        Patient ford = new Patient("ford", 2);
        Patient eve = new Patient("eve", 3);

        myQueue.enqueue(annat);
        myQueue.enqueue(ben);
        myQueue.enqueue(sasha);
        myQueue.enqueue(wu);
        myQueue.enqueue(rein);
        myQueue.enqueue(ford);
        myQueue.enqueue(eve);
        myQueue.enqueue("laiam", 5);
        myQueue.enqueue(annat2);
        myQueue.enqueue("anna", 8);
        myQueue.enqueue("Charles", 15);
        myQueue.enqueue("liam", 5);
        myQueue.enqueue("laiam", 5);

        System.out.println(myQueue);
        System.out.println(myQueue.size());

    }
}
