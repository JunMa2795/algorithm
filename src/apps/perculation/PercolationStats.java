package apps.perculation;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats 
{
	private int experimentsCount;
	private Percolation percolation;
	private double[] fractions;

	// perform trials independent experiments on an n-by-n grid
	public PercolationStats(int n, int trials)
	{
		if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Given N <= 0 || Trials <= 0");
        }
		experimentsCount = trials;
		fractions = new double[experimentsCount];
		for (int expNum = 0; expNum < experimentsCount; expNum++) 
		{
			percolation = new Percolation(n);
			int openedSites = 0;
			while (!percolation.percolates()) 
			{
				int i = StdRandom.uniform(1, n + 1);
				int j = StdRandom.uniform(1, n + 1);
				if (!percolation.isOpen(i, j))
				{
					percolation.open(i, j);
					openedSites++;
				}
			}
			double fraction = (double) openedSites / (n * n);
			fractions[expNum] = fraction;
		}
		
	}

	// sample mean of percolation threshold
	public double mean()
	{
		return StdStats.mean(fractions);
	}

	// sample standard deviation of percolation threshold
	public double stddev() 
	{
		return StdStats.stddev(fractions);
	}

	// low  endpoint of 95% confidence interval
	public double confidenceLo()
	{
		return mean() - ((1.96 * stddev()) / Math.sqrt(experimentsCount));
	}
	
	// high endpoint of 95% confidence interval
	public double confidenceHi()
	{
		return mean() + ((1.96 * stddev()) / Math.sqrt(experimentsCount));
	}

	// test client (described below)
	public static void main(String[] args)
	{
		int n = Integer.parseInt(args[0]);
		int t = Integer.parseInt(args[1]);
		PercolationStats ps = new PercolationStats(n, t);

		String confidence = ps.confidenceLo() + ", " + ps.confidenceHi();
		StdOut.println("mean                    = " + ps.mean());
		StdOut.println("stddev                  = " + ps.stddev());
		StdOut.println("95% confidence interval = " + confidence);
	}
}