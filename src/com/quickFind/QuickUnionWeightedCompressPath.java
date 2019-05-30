package com.quickFind;

/**
 * Improvement 2: Weighted QuickUnion + Path compression
 * 
 * Find: O(N) = lgN
 * */
public class QuickUnionWeightedCompressPath {
	private int[] id;
	private int[] sz;
	
	public QuickUnionWeightedCompressPath(int N)
	{
		id = new int[N];
		for(int i = 0; i < N; i++) 
		{
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	private int root(int i)
	{
		while(i != id[i]) 
		{
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
	
	// find the max of connected component containing i
	private int find(int i) 
	{
		int max = id.length - 1;
		while(max >= 0)
		{
			if(root(max) == root(i)) break;
			max--;
		}
		return max;
	}
	
	public boolean connected(int p, int q)
	{	return root(p) == root(q);	}
	
	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		if(i == j) return;
		if(sz[i] < sz[j])
		{
			id[i] = id[j];
			sz[j] += sz[i];
		} else
		{
			id[j] = id[i];
			sz[i] += sz[j];
		}
	}
}
