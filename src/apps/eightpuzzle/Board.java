package apps.eightpuzzle;
import java.util.LinkedList;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 
 * @author jack
 *
 */
public class Board {

	private int n, spaceRow, spaceCol; 
	private int[][] board;

	// construct a board from an n-by-n array of blocks
	// (where blocks[i][j] = block in row i, column j)
	public Board(int[][] blocks) {
		this.n = blocks.length;
		this.board = copy(blocks);
	}

	private int[][] copy(int[][] blocks) {
		int[][] copy = new int[blocks.length][blocks.length];
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks.length; j++) {
				copy[i][j] = blocks[i][j];
				if (isSpace(blocks, i, j)) {
					this.spaceRow = i;
					this.spaceCol = j;
				}
			}
		}
		return copy;
	}

	private boolean isSpace(int[][] item, int row, int col) {
		return item[row][col] == 0;
	}

	private int goalForBlock(int row, int col) {
		if ((row == this.n - 1) && (col == this.n - 1))
			return 0;
		return row * this.n + col + 1;
	}

	private int getDistance(int row, int col) {
		if (isSpace(this.board, row, col))
			return 0;
		int distance = 0;
		distance += Math.abs((this.board[row][col] - 1) / this.n - row);
		distance += Math.abs((this.board[row][col] - 1) % this.n - col);
		return distance;
	}

	// board dimension n
	public int dimension() {
		return this.n;
	}

	// number of blocks out of place
	public int hamming() {
		int hamming = 0;
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board.length; j++) {
				if (this.board[i][j] != goalForBlock(i, j) && !isSpace(this.board, i, j))
					hamming++;
			}
		}
		return hamming;
	}

	// sum of Manhattan distances between blocks and goal
	public int manhattan() {
		int manhattan = 0;
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board.length; j++) {
				if (this.board[i][j] != goalForBlock(i, j))
					manhattan += getDistance(i, j);
			}
		}
		return manhattan;
	}

	// is this board the goal board?
	public boolean isGoal() {
		return this.manhattan() == 0;
	}

	// a board that is obtained by exchanging any pair of blocks
	public Board twin() {
		int row, col, row2, col2;
		
		do {
			row = StdRandom.uniform(0, this.n);
			col = StdRandom.uniform(0, this.n);
			row2 = StdRandom.uniform(0, this.n);
			col2 = StdRandom.uniform(0, this.n);
		} while (isSpace(this.board, row, col) && isSpace(this.board, row2, col2));

		return new Board(swap(row, col, row2, col2));
	}

	// does this board equal y?
	public boolean equals(Object y) {
		if (y == this)
			return true;
		if (y == null || !(y.getClass() != this.getClass()) || ((Board) y).board.length != board.length)
			return false;
		for (int row = 0; row < this.board.length; row++)
			for (int col = 0; col < this.board.length; col++)
				if (((Board) y).board[row][col] != this.board[row][col])
					return false;
		return true;
	}
	
	private int[][] swap(int row1, int col1, int row2, int col2) {
		int[][] copy = copy(this.board);
		int tmp = copy[row1][col1];
		copy[row1][col1] = copy[row2][col2];
		copy[row2][col2] = tmp;

		return copy;
	}


	// all neighboring boards
	public Iterable<Board> neighbors() {
		LinkedList<Board> neighbors = new LinkedList<Board>();

		if (spaceRow > 0)
			neighbors.add(new Board(swap(spaceRow, spaceCol, spaceRow - 1, spaceCol)));
		if (spaceRow < dimension() - 1)
			neighbors.add(new Board(swap(spaceRow, spaceCol, spaceRow + 1, spaceCol)));
		if (spaceCol > 0)
			neighbors.add(new Board(swap(spaceRow, spaceCol, spaceRow, spaceCol - 1)));
		if (spaceCol < dimension() - 1)
			neighbors.add(new Board(swap(spaceRow, spaceCol, spaceRow, spaceCol + 1)));

		return neighbors;
	}

	// string representation of this board (in the output format specified below)
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(this.n + "\n");
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				s.append(String.format("%2d ", this.board[i][j]));
			}
			s.append("\n");
		}
		return s.toString();
	}

	// unit tests (not graded)
	public static void main(String[] args) {

	}
}
