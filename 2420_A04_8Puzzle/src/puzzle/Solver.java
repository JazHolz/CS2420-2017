package puzzle;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
	private Stack<Board> finalSolution;
	private int moves;

	/**
	 * Finds a solution to the initial board (using the A* algorithm)
	 * 
	 * @param initial
	 */

	public Solver(Board initial) {

		if (initial == null) {
			throw new java.lang.NullPointerException();
		}
		if (initial.isSolvable() == false) {
			throw new java.lang.IllegalArgumentException();
		}

		finalSolution = new Stack<>();

		MinPQ<Move> minQueue = new MinPQ<>();

		minQueue.insert(new Move(initial, 0, null));

		while (true) {
			Move move = minQueue.delMin();
			if (move.board.isGoal()) {
				this.moves = move.moves;
				do {
					finalSolution.push(move.board);
					move = move.parent;
				} while (move != null);
				return; 
			}
			for (Board next : move.board.neighbors()) {
				if (move.parent == null || !next.equals(move.parent.board))
					minQueue.insert(new Move(next, move.moves + 1, move));
			}
		}
	}

	private class Move implements Comparable<Move> {

		private Board board;
		private int moves;
		private Move parent;

		public Move(Board b, int m, Move p) {
			this.board = b;
			this.moves = m;
			this.parent = p;
		}

		@Override
		public int compareTo(Move arg0) {
			int difference = this.board.manhattan() + this.moves - arg0.board.manhattan() - arg0.moves;
			if (difference != 0)
				return difference;
			if (this.moves > arg0.moves)
				return -1;
			return 1;
		}
	}

	/**
	 * Minimum number of moves to solve initial board
	 * 
	 * @return
	 */

	public int moves() {
		return moves;

	}

	/**
	 * Sequence of boards in a shortest solution
	 * 
	 * @return
	 */

	public Iterable<Board> solution() {
		return finalSolution;

	}

	/**
	 * Solve a slider puzzle (given below)
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		// create initial board from file
		In in = new In(args[0]);
		int N = in.readInt();
		int[][] blocks = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				blocks[i][j] = in.readInt();
		Board initial = new Board(blocks);

		if (initial.isSolvable()) {
			Solver solver = new Solver(initial);
			StdOut.println("Minimum number of moves = " + solver.moves());
			for (Board board : solver.solution())
				StdOut.println(board);
		}

		else {
			StdOut.println("Unsolvable puzzle");
		}
	}

}
