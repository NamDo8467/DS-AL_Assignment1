/**
 * EECS 2101 X, Winter 2024
 * Assignment 3, Question 2 starter code.
 * Please read carefully the instructions in the assignment handout
 * and the starter code.
 */
package A3;
// Do NOT modify the package declaration
// Do NOT add any import
/**
 * Your own implementation of a HashTable class.
 * Add the appropriate fields and methods you want in order to solve this problem.
 */

// Node class for the linked list
class Node {
	public int key;
	public int value;
	public Node next;
	public Node(int key, int value, Node next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}
}
class HashTable {

    // TODO: implement your own HashTable class
	private Node table[];
	
	public HashTable(int size) {
		this.table = new Node [size];
		
	}
	public int hash(int key) {
		if(key < 0) {
			key = key *(-1);
		}
		return key%table.length;
	}
	public void put(int key, int value) {
		int index = hash(key);
		Node node = table[index];
	
		while(node!= null) {
			if(node.key == key) {
				node.value = value;
				return;
			}
			node = node.next;
		}
		table[index] = new Node(key, value, table[index]);
		
	}
	public int getOrDefault(int key, int defaultValue) {
		int index = hash(key);
		Node node = table[index];
		while(node!= null) {
			if(node.key == key) {
				return node.value;
			}
			node = node.next;
		}
		return defaultValue;
	}
	
}
public class A3Q2 {
	public static int RANGE = 50;
	public static int TABLE_SIZE = 1037; // prime number that is greater than (RANGE + RANGE)^2
	
    /**
     * Return the number of unique integer solutions where each integer is in the range [-50, 50].
     * The equation is given in the handout.
     * Precondition: A, B, C, D, E, S are integers in the range [-5000, 5000]
     * Note that the return value of this function is a long integer, not just an int.
     *
     * Do NOT modify the signature of this function.
     */
    public static long solve(int A, int B, int C, int D, int E, int S) {
        // TODO: implement this function
    	HashTable table = new HashTable(TABLE_SIZE);
         for (int x1 = -RANGE; x1 <= RANGE; x1++) {
             for (int x2 = -RANGE; x2 <= RANGE; x2++) {
                 int sum = A * x1 + B * (int) Math.pow(x2, 2);
                 table.put(sum, table.getOrDefault(sum, 0) + 1);
             }
         }
         
         long count = 0; // This will hold the number of solutions.
         
         // Phase 2: Check if the sums of C*x3^3 + D*x4^4 + E*x5^5 exist in the hash table.
         for (int x3 = -RANGE; x3 <= RANGE; x3++) {
             for (int x4 = -RANGE; x4 <= RANGE; x4++) {
                 for (int x5 = -RANGE; x5 <= RANGE; x5++) {
                     int sum = C * (int) Math.pow(x3, 3) + D * (int) Math.pow(x4, 4) + E * (int) Math.pow(x5, 5);
                     count += table.getOrDefault(S - sum, 0);
                 }
             }
         }
         
         return count;

    }

    public static void main(String[] args) {

        // Below are a few test cases.
        // Printing "true" means the return value is correct.
        // Each call to solve() must take less than 5 seconds.

        System.out.println(340 == solve(12, 34, 56, 78, 9, 10));
        System.out.println(16665 == solve(20, -11, -2, 0, 11, -2011));
        System.out.println(10510100501L == solve(0, 0, 0, 0, 0, 0));
    	
    	
    }
}
