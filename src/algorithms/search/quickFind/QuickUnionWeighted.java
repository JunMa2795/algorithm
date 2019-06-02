package algorithms.search.quickFind;

/**
 * Improvement 1
 * 
 * Find: O(N) = lgN
 * */
public class QuickUnionWeighted {
	private int[] id;
	private int[] sz;
	
	public QuickUnionWeighted(int N)
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
		while(i != id[i]) i = id[i];
		return i;
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
