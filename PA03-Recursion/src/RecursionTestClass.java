/*
 * This file will hold all of your testcases. Remember, to run all
 * of your tests, right-click on 'RunTests.java' and select 'Run As' ->
 * JUnit Test.
 */
import static org.junit.Assert.assertEquals;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import org.junit.Test;

public class RecursionTestClass {
	
	/*
	 * Here I have provided an example of one of the tests that I
	 * would write. For each of your tests, leave a brief comment
	 * above the test specifying its purpose. For example, for this
	 * test, I might write, "indexOf_test1 tests when s2 is not a 
	 * substring of s1. This should return -1."
	 */
    @Test
    public void test_indexOf_test1() {
        int result = Recursion.indexOf("Hello", "World");
        System.out.println("indexOf(Hello, World), got " + result);
        assertEquals(-1, result);
    }
    
    /*
     * This test tests indexOf for the case s2 is contained in s1. It should
     * return 0.
     */
    @Test
    public void test_indexOf_test2() {
    	int result = Recursion.indexOf("Hello", "H");
        System.out.println("indexOf(Hello, H), got " + result);
        assertEquals(0, result);
    }
    
    /*
     * This test tests indexOf for the case s2 is contained in s1. It should
     * return 4.
     */
    @Test
    public void test_indexOf_test3() {
    	int result = Recursion.indexOf("My new String", "e");
        System.out.println("indexOf(My new String, e), got " + result);
        assertEquals(4, result);
    }
    
    /*
     * This method tests removeEvenNumbers for the case where the stack
     * has even integers in it and k = the number of integers.
     */
    @Test
    public void test_removeEvenNumbers1() {
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(1);
    	stack.push(4);
    	stack.push(3);
    	stack.push(5);
    	stack.push(2);
    	stack.push(4);
    	stack.push(6);
    	
    	int result = Recursion.removeEvenNumbers(stack, 4);
        System.out.println("removeEvenNumbers(stack,4), got " + result);
        assertEquals(4, result);
    }
    
    /*
     * This method tests removeEvenNumbers for the edge case of the stack being 
     * empty. It should return 0
     */
    @Test
    public void test_removeEvenNumbers2() {
    	Stack<Integer> stack = new Stack<Integer>();
   
    	int result = Recursion.removeEvenNumbers(stack, 1);
        System.out.println("removeEvenNumbers(stack, 1), got " + result);
        assertEquals(0, result);
    }
    
    /*
     * This method tests removeEvenNumbers for the case where the stack
     * has even integers in it and k > the number of integers.
     */
    @Test
    public void test_removeEvenNumbers3() {
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(1);
    	stack.push(4);
    	stack.push(3);
    	stack.push(5);
    	stack.push(2);
    	stack.push(4);
    	
    	int result = Recursion.removeEvenNumbers(stack, 5);
        System.out.println("removeEvenNumbers(stack,5), got " + result);
        assertEquals(3, result);
    }
    
    /*
     * This method tests removeEvenNumbers for the case where k is
     * lower than the position of the first even int.
     */
    @Test
    public void test_removeEvenNumbers4() {
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(1);
    	stack.push(4);
    	stack.push(3);
    	stack.push(5);
    	stack.push(2);
    	stack.push(4);
    	
    	int result = Recursion.removeEvenNumbers(stack, 0);
        System.out.println("removeEvenNumbers(stack,0), got " + result);
        assertEquals(0, result);
    }
    
    /*
     * This method tests removeEvenNumbers for the case where k is
     * lower than the total number of even but still greater than the 
     * position of the first even int. It should return 1
     */
    @Test
    public void test_removeEvenNumbers5() {
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(1);
    	stack.push(4);
    	stack.push(3);
    	stack.push(5);
    	stack.push(2);
    	stack.push(4);
    	
    	int result = Recursion.removeEvenNumbers(stack, 1);
        System.out.println("removeEvenNumbers(stack, 1), got " + result);
        assertEquals(1, result);
    }
    
    /*
     * This method tests evenDigits for the case where there are
     * no even integers in the given int. Should return 0.
     */
    @Test
    public void test_evenDigits1() {
    	int result = Recursion.evenDigits(33157);
        System.out.println("evenDigits(33157), got " + result);
        assertEquals(0, result);
    }
    
    /*
     * This method tests evenDigits for the case where there are
     * no even integers in the given int and the int is only one digit.
     * Should return 0.
     */
    @Test
    public void test_evenDigits2() {
    	int result = Recursion.evenDigits(3);
        System.out.println("evenDigits(3), got " + result);
        assertEquals(0, result);
    }
    
    /*
     * This method tests evenDigits for the case where there is
     * one even integer in the given int. Should return the given
     * int.
     */
    @Test
    public void test_evenDigits3() {
    	int result = Recursion.evenDigits(2);
        System.out.println("evenDigits(2), got " + result);
        assertEquals(2, result);
    }
    
    /*
     * This method tests evenDigits for the case where there is
     * more than one even integer in the given int. Should return the 
     * even integers from the given int.
     */
    @Test
    public void test_evenDigits4() {
    	int result = Recursion.evenDigits(2348);
        System.out.println("evenDigits(2348), got " + result);
        assertEquals(248, result);
    }
    
    /*
     * This method tests evenDigits for the case where there the
     * given int is negative and there is more than one even integer. 
     * Should return the even integers from the given int.
     */
    @Test
    public void test_evenDigits5() {
    	int result = Recursion.evenDigits(-2348);
        System.out.println("evenDigits(-2348), got " + result);
        assertEquals(248, result);
    }
    
    /*
     * This method tests evaluate for the case where the queue
     * has different parentheses and digits in the expression. It 
     * should return 13.
     */
    @Test
    public void test_evaluate1() {
    	String expr = "(((1+5)+(2+1))+(1*(2+2)))";
    	Queue<Character> q = new LinkedList<Character>();
    	for (char ch: expr.toCharArray()) {
    	q.add(ch);
    	}
    	
    	int result = Recursion.evaluate(q);
        System.out.println("evaluate(q), got " + result);
        assertEquals(13, result);
    }
    
    /*
     * This method tests evaluate for the case where the queue
     * is empty. It should return 0.
     */
    @Test
    public void test_evaluate2() {
    	Queue<Character> q = new LinkedList<Character>();
    	
    	int result = Recursion.evaluate(q);
        System.out.println("evaluate(q), got " + result);
        assertEquals(0, result);
    }
    
    /*
     * This method tests repeatStack for the case where the stack
     * has the integers 1, 2, 3. It should print {1, 1, 2, 2, 3, 3}
     */
    @Test
    public void test_repeatStack1() {
    	Stack<Integer> stack = new Stack<Integer>();
    	Stack<Integer> testStack = new Stack<Integer>();
    	
    	stack.push(1);
    	stack.push(2);
    	stack.push(3);
    	
    	testStack.push(1);
    	testStack.push(1);
    	testStack.push(2);
    	testStack.push(2);
    	testStack.push(3);
    	testStack.push(3);

    	Recursion.repeatStack(stack);
        System.out.println("repeatStack(stack), got " + stack);
        assertEquals(testStack, stack);
    }
    
    /*
     * This method tests repeatStack for the case where the stack
     * is empty. It should print [].
     */
    @Test
    public void test_repeatStack2() {
    	Stack<Integer> stack = new Stack<Integer>();
    	Stack<Integer> testStack = new Stack<Integer>();

    	Recursion.repeatStack(stack);
        System.out.println("repeatStack(stack), got " + stack);
        assertEquals(testStack, stack);
    }
    
    /*
     * This method tests repeatStack for the case where the stack
     * has the integers -1, -2, -3. It should print {-1, -1, -2, -2, -3, -3}
     */
    @Test
    public void test_repeatStack3() {
    	Stack<Integer> stack = new Stack<Integer>();
    	Stack<Integer> testStack = new Stack<Integer>();
    	
    	stack.push(-1);
    	stack.push(-2);
    	stack.push(-3);
    	
    	testStack.push(-1);
    	testStack.push(-1);
    	testStack.push(-2);
    	testStack.push(-2);
    	testStack.push(-3);
    	testStack.push(-3);
    	
    	Recursion.repeatStack(stack);
        System.out.println("repeatStack(stack), got " + stack);
        assertEquals(testStack, stack);
    }
    
    /*
     * This method tests doubleElements for the case where the queue
     * has the values [1, 2, 3, 4]. It should return [2, 4, 6, 8]
     */
    @Test
    public void test_doubleElements1() {
    	Queue<Integer> q = new LinkedList<Integer>();
    	Queue<Integer> testQ = new LinkedList<Integer>();
    	
    	q.add(1);
    	q.add(2);
    	q.add(3);
    	q.add(4);
    	
    	testQ.add(2);
    	testQ.add(4);
    	testQ.add(6);
    	testQ.add(8);
    	
    	Recursion.doubleElements(q);
        System.out.println("doubleElements(q), got " + q);
        assertEquals(testQ, q);
    }
    
    /*
     * This method tests doubleElements for the case where the queue
     * has the values [-5, -6, -8, -5]. It should return [-10, -12, -16, -10].
     */
    @Test
    public void test_doubleElements2() {
    	Queue<Integer> q = new LinkedList<Integer>();
    	Queue<Integer> testQ = new LinkedList<Integer>();
    	
    	q.add(-5);
    	q.add(-6);
    	q.add(-8);
    	q.add(-5);
    	
    	testQ.add(-10);
    	testQ.add(-12);
    	testQ.add(-16);
    	testQ.add(-10);
    	
    	Recursion.doubleElements(q);
        System.out.println("doubleElements(q), got " + q);
        assertEquals(testQ, q);
    }
    
    /*
     * This method tests doubleElements for the case where the queue
     * is empty. It should return [].
     */
    @Test
    public void test_doubleElements3() {
    	Queue<Integer> q = new LinkedList<Integer>();
    	Queue<Integer> testQ = new LinkedList<Integer>();
    	
    	
    	Recursion.doubleElements(q);
        System.out.println("doubleElements(q), got " + q);
        assertEquals(testQ, q);
    }
    
    /*
     * This method tests doubleElements for the case where the queue
     * has only 1 value, 0. It should return [0].
     */
    @Test
    public void test_doubleElements4() {
    	Queue<Integer> q = new LinkedList<Integer>();
    	Queue<Integer> testQ = new LinkedList<Integer>();
    	
    	q.add(0);
    	
    	testQ.add(0);

    	Recursion.doubleElements(q);
        System.out.println("doubleElements(q), got " + q);
        assertEquals(testQ, q);
    }
}
