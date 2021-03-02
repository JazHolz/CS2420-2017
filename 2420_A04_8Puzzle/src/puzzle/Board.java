package puzzle;

import edu.princeton.cs.algs4.Stack;

public class Board {
	private int n;
	private int[] tileBlocks;
	private int zero;
	private int hamming;
	private int manhattan;

	/**
	 * Construct a board from an N-by-N array of blocks (where blocks[i][j] =
	 * block in row i, column j)
	 * 
	 * @param blocks
	 */

	public Board(int[][] blocks) {
		if (blocks == null) {
			throw new java.lang.NullPointerException();
		}
		n = blocks.length;

		tileBlocks = new int[n * n];

		int tiles = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (blocks[i][j] == 0) {
					zero = tiles;
				}
				tileBlocks[tiles++] = blocks[i][j];
			}
		}
	}

	/**
	 * Board size N
	 * 
	 * @return
	 */

	public int size() {
		return n;
	}

	/**
	 * Number of blocks out of place
	 * 
	 * @return
	 */

	public int hamming() {

		if (hamming > 0) {
			return hamming;
		}
		hamming = 0;

		for (int i = 0; i < tileBlocks.length; i++) {
			if (tileBlocks[i] != (i + 1) && tileBlocks[i] != 0) {
				hamming++;
			}
		}
		return hamming;
	}

	/**
	 * Sum of Manhattan distances between blocks and goal
	 * 
	 * @return
	 */

	public int manhattan() {

		if (manhattan > 0)
			return manhattan;

		manhattan = 0;
		for (int i = 0; i < tileBlocks.length; i++) {
			if (tileBlocks[i] == (i + 1) || i == zero)
				continue;
			manhattan += Math.abs((i / n) - ((tileBlocks[i] - 1)) / n);
			manhattan += Math.abs((i % n) - ((tileBlocks[i] - 1)) % n);
		}

		return manhattan;
	}

	/**
	 * Is this board the goal board?
	 * 
	 * @return
	 */

	public boolean isGoal() {
		if (tileBlocks.length - 1 != zero)
			return false;
		for (int i = 0; i < tileBlocks.length - 1; i++) {
			if (tileBlocks[i] != (i + 1)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Is this board solvable?
	 * 
	 * @return
	 */

	public boolean isSolvable() {

		int inversionTypeOne = 0;

		// Odd
		if (n % 2 != 0) {
			for (int i = 0; i < tileBlocks.length; i++) {
				if (tileBlocks[i] == 0)
					continue;

				for (int j = 1; j < tileBlocks.length; j++) {
					if (tileBlocks[i] > tileBlocks[j] && tileBlocks[j] != 0) {
						inversionTypeOne++;
					}
				}
			}
		}
		if (inversionTypeOne % 2 != 0) {
			return false;
		}

		// Even
		int inversionTypeTwo = 0;
		if (n % 2 == 0) {
			for (int i = 0; i < tileBlocks.length; i++) {
				if (tileBlocks[i] == 0)
					continue; // skip zero
				for (int j = 1; j < tileBlocks.length; j++) {
					if (tileBlocks[i] > tileBlocks[j] && tileBlocks[j] != 0) {
						inversionTypeTwo++;
					}
				}

			}
			inversionTypeTwo += zero / n;
			if (inversionTypeTwo % 2 == 0)
				return false;
		}
		return true;
	}

	/**
	 * Does this board equal y?
	 */

	public boolean equals(Object y) {

		if (y == this) {
			return true;
		}
		if (y == null) {
			return false;
		}
		if (this.getClass() != y.getClass()) {
			return false;
		}

		Board other = (Board) y;

		for (int i = 0; i < tileBlocks.length; i++) {
			if (this.tileBlocks[i] != other.tileBlocks[i]) {
				return false;
			}
		}

		return true;

	}

	/**
	 * All neighboring boards
	 * 
	 * @return
	 */

	public Iterable<Board> neighbors() {

		Stack<Board> boards = new Stack<>();

		if (zero / n != 0) {
			// UP
			stackPush(boards, -n);
		}
		if (zero / n != (n - 1)) {
			// DOWN
			stackPush(boards, n);
		}
		if (zero % n != 0) {
			// LEFT
			stackPush(boards, -1);
		}
		if (zero % n != (n - 1)) {
			// RIGHT
			stackPush(boards, 1);
		}
		return boards;

	}

	private void stackPush(Stack<Board> boards, int i) {
		swap(tileBlocks, zero, zero + i);
		boards.push(new Board(tileBlocks, n, zero + i));
		swap(tileBlocks, zero, zero + i);

	}

	private void swap(int[] tileBlocks2, int i, int j) {
		int swap = tileBlocks2[i];
		tileBlocks2[i] = tileBlocks2[j];
		tileBlocks2[j] = swap;

	}

	private Board(int[] block, int n, int zero) {
		this.n = n;
		this.zero = zero;
		tileBlocks = new int[n * n];
		System.arraycopy(block, 0, tileBlocks, 0, tileBlocks.length);
	}

	/**
	 * String representation of this board (in the output format specified
	 * below)
	 */

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(n + "\n");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				s.append(String.format("%2d ", tileBlocks[i] + tileBlocks[j]));
			}
			s.append("\n");
		}
		return s.toString();
	}

	/**
	 * unit tests (not graded)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

	}
}