/**
 * EECS 2101 X, Winter 2024.
 * Assignment 2, Question 2 starter code.
 * Please read carefully the instructions in the assignment handout
 * and the starter code.
 */
package A2;
// Do NOT change the package!

import java.util.ArrayList;
// Do NOT add any import!
/**
 * The A2Q2 class
 */
public class A2Q2 {

    /**
     * A class representing a single move in the TOH solution,
     * i.e., moving the disk at the top of fromPeg to the top of toPeg
     * Note: a move is invalid if it results in a larger disk being above a smaller disk.
     *
     * DO NOT MODIFY THIS CLASS.
     */
    public static class Move {

        private final int fromPeg;
        private final int toPeg;

        public Move(int from, int to) {
            this.fromPeg = from;
            this.toPeg = to;
        }

        public String toString() {
            return String.format("%d to %d", this.fromPeg, this.toPeg);
        }
        public int getFromPeg() { return this.fromPeg; };
        public int getToPeg() { return this.toPeg; };
    }
    
    public static class MyStack {
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
    public static void threePegTOHHelper(int n, ArrayList<Move> moves, int from, int to, int auxiliary) {
    	if(n == 1) {
    		moves.add(new Move(from, to));
    		System.out.println(from +" " + " " + to);
    		return;
    	}
    	threePegTOHHelper(n-1, moves, from, auxiliary, to);
    	moves.add(new Move(from, to));
    	System.out.println(from +" " + " " + to);
    	threePegTOHHelper(n-1, moves, auxiliary, to,from );
    	
    	
    }

    /**
     * Return the sequence of moves that solves the 3-peg TOH problem with n disks.
     * Assumptions:
     * - The pegs are numbered 1, 2, 3
     * - The origin peg is 1.
     * - The destination peg is 2.
     * - n > 0
     */
    public static ArrayList<Move> threePegTOH(int n) {
        // TODO: Complete this method
    	ArrayList<Move> moves = new ArrayList<Move>();
    	threePegTOHHelper(n,moves, 1,2,3);
   
    	return moves;
//        return null; // Placeholder return statement. Should be changed when the method is implemented..
    }

    /**
     * Return the sequence of moves that solves the 4-peg TOH problem with n disks,
     * with the strategy described in the assignment handout
     * Assumptions:
     * - The pegs are numbered 1, 2, 3, 4
     * - The origin peg is 1.
     * - The destination peg is 2.
     * - n > 0
     */
    public static ArrayList<Move> fourPegTOH(int n) {

        // TODO: Complete this method
        return null; // Placeholder return statement. Should be changed when the method is implemented..
    }

    public static void main(String[] args) {
//        System.out.println(threePegTOH(3));
//        System.out.println(fourPegTOH(3));
    	threePegTOH(3);
    }
}
