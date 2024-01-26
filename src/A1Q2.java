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
		stack.add(element);
		current_size += 1;
	}
	
	int pop() {
		int top_of_the_stack = stack.remove(current_size - 1);
		current_size -= 1;
		return top_of_the_stack;
	}
	
	int peek() {
		if(current_size == 0) {
			return 0;
		}
		return stack.get(current_size-1);
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
	int getSize() {
		return current_size;
	}
	void print() {
		for(int i = 0; i < current_size; i++) {
			System.out.println(queue.get(i));
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
    	MyQueue exit_tunnel = new MyQueue();
    	MyStack buffer_line = new MyStack();
    	
    	int look_for = 1;
    	
    	for(int i = 0; i < arr.length; i++) {
    		
    		if(arr[i] == look_for) {
    			exit_tunnel.enqueue(arr[i]);
    			look_for += 1;
    		}else {
    			while(buffer_line.peek() == look_for && !buffer_line.isEmpty()) {
					exit_tunnel.enqueue(buffer_line.pop());
					look_for += 1;
    	    	}
    			buffer_line.push(arr[i]); 
    		}
    	}
    	
    	while(buffer_line.peek() == look_for && !buffer_line.isEmpty()) {
			exit_tunnel.enqueue(buffer_line.pop());
			look_for += 1;
    	}
    	if(!exit_tunnel.isEmpty()) {
//    		exit_tunnel.print();
    		return exit_tunnel.getSize();
    	}
//    	System.out.println();
        return 0;
    }

    /**
     * This main function contains a few test cases that can be used to check
     * that your code compiles and runs. Note that these test cases are NOT complete,
     * and you need to test your code thoroughly with more cases.
     */
    public static void main(String[] args) {

        // Printing "true" means the return value is correct.
    	
    	// 4,5,2,1,3
        int[] arr = {4,5,2,1,3}; 
        System.out.println(3 == solve(arr));

        arr = new int[] {5, 4, 3, 1, 2};
        System.out.println(5 == solve(arr));

        arr = new int[] {1};
        System.out.println(1 == solve(arr));

        arr = new int[] {2, 3, 1};
        System.out.println(1 == solve(arr));

        arr = new int[] {7, 1, 5, 4, 3, 2, 8, 10, 9, 6};
        System.out.println(6 == solve(arr));
        
        //My test cases
        arr = new int[] {6,7,9,2,1,5,3,4};
        System.out.println(5 == solve(arr));
        
        arr = new int[] {1,6,2,3,4};
        System.out.println(4 == solve(arr));
    }
}
