/**
 * EECS 2101 X, Winter 2024
 * Assignment 1, Question 2 starter code.
 * Please read carefully the instructions in the assignment handout
 * and the starter code.
 */
// Do NOT modify the package declaration

import java.util.ArrayList;
// Do NOT add any import

// You may implement a new class here, such as a Stack or a Queue.
// Any additional class that you use must be included in THIS file.

class MyStack {
	private int current_size = 0;
	
	private ArrayList<Integer> stack = new ArrayList<Integer>();
	public MyStack() {
	}
	
	void push(int element) {
		this.stack.add(element);
		current_size += 1;
	}
	
	int pop() {
		stack.remove(current_size - 1);
		current_size -= 1;
		return 0;
	}
	
	boolean isEmpty() {
		return current_size == 0;
	}
	
	void print() {
		for(int i = 0; i < current_size; i++) {
			System.out.println(stack.get(i));
		}
	}
}


class MyQueue {
	private ArrayList<Integer> queue = new ArrayList<Integer>();
	private int current_size = 0;
	
	public MyQueue() {
		// TODO Auto-generated constructor stub
	}
	
	void enqueue(int element) {
		queue.add(element);
		current_size += 1;
	}
	
	void dequeue () {
		queue.remove(0);
		current_size -= 1;
	}
	boolean isEmpty() {
		return current_size == 0;
	}
	void print() {
		for(int i = 0; i < current_size; i++) {
			System.out.println(queue.get(i));
			System.out.println(i);
		}
	}
}
public class A1Q2 {

    /**
     * The function that you need to implement.
     * Read the assignment handout for the specification.
     *
     * DO NOT MODIFY the declaration of the function (its parameter types and return type).
     */
    public static int solve(int[] arr) {
    	
        // TODO: implement this function
        return 0;
    }

    /**
     * This main function contains a few test cases that can be used to check
     * that your code compiles and runs. Note that these test cases are NOT complete,
     * and you need to test your code thoroughly with more cases.
     */
    public static void main(String[] args) {

        // Printing "true" means the return value is correct.

    	MyQueue queue = new MyQueue();
    	queue.enqueue(2);
    	queue.enqueue(3);
    	queue.enqueue(4);
    	queue.dequeue();
    	queue.dequeue();
    	
        int[] arr = {4, 5, 2, 1, 3};
        System.out.println(3 == solve(arr));

        arr = new int[] {5, 4, 3, 1, 2};
        System.out.println(5 == solve(arr));

        arr = new int[] {1};
        System.out.println(1 == solve(arr));

        arr = new int[] {2, 3, 1};
        System.out.println(1 == solve(arr));

        arr = new int[] {7, 1, 5, 4, 3, 2, 8, 10, 9, 6};
        System.out.println(6 == solve(arr));
    }
}
