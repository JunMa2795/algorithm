package apps.perculation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private final int top = 0;
	private int bottom;
	private int size;
	private int count;
	private boolean[][] isOpened;
	private WeightedQuickUnionUF qu;

	// create n-by-n grid, with all sites blocked
	public Percolation(int n) {
		size = n;
		bottom = n * n + 1;
		qu = new WeightedQuickUnionUF(n * n + 2);
		isOpened = new boolean[size][size];
		count = 0;
	}

	// open site (row, col) if it is not open already
	public void open(int row, int col) {
		isOpened[row - 1][col - 1] = true;
		count++;
		// if on the top row, union site with top node
		if (row == 1)
			qu.union(getQuIndex(row, col), top);
		// if on the bottom row, union site with bottom node
		if (row == size)
			qu.union(getQuIndex(row, col), bottom);
		// union its up site if it is open
		if (row > 1 && isOpen(row - 1, col))
			qu.union(getQuIndex(row, col), getQuIndex(row - 1, col));
		// union its down site if it is open
		if (row < size && isOpen(row + 1, col))
			qu.union(getQuIndex(row, col), getQuIndex(row + 1, col));
		// union its left site if it is open
		if (col > 1 && isOpen(row, col - 1))
			qu.union(getQuIndex(row, col), getQuIndex(row, col - 1));
		// union its right site if it is open
		if (col < size && isOpen(row, col + 1))
			qu.union(getQuIndex(row, col), getQuIndex(row, col + 1));
	}

	// is site (row, col) open?
	public boolean isOpen(int row, int col) {
		return isOpened[row - 1][col - 1];
	}

	// is site (row, col) full?
	public boolean isFull(int row, int col)
	{
		if (0 < row && row <= size && 0 < col && col <= size)
		{
			return qu.connected(top, getQuIndex(row, col));
		} else {
			throw new IndexOutOfBoundsException();
		}

	}

	 // number of open sites
	public int numberOfOpenSites() {
		return count;
	}

	// does the system percolate?
	public boolean percolates()
	{
		return qu.connected(top, bottom);
	}

	private int getQuIndex(int row, int col)
	{
		return (row - 1) * size + col;
	}
}
