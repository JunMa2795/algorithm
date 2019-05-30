package com.quickFind;

public class ThreeSum {
	
	public static int threeSum(int[] a)
	{
		int k;
		int result = 0;
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 1; j < a.length; j++)
			{
				k = binarySearch(a, -(a[i] + a[j]));
				if (k < 0) continue;
				if (a[i] < a[j] && a[j] < a[k]) result++;
			}
		}
		return result;
	}
	
	public static int binarySearch(int[] a, int key)
	{
		int lo = 0, hi = a.length - 1;
		while (lo <= hi)
		{
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else return mid;
		}
		return -1;
	}
	
	public static void main(String[] args)
	{
		int[] array = {-40, -20, -10, 0, 5, 10, 30, 40};
		System.out.println(threeSum(array));
	}
}


class EggDrop {
	public int superEggDrop(int K, int N)
	{
		int[] dp = new int[K+1];
		for (int i = 0; i <= K; i++)
			dp[i] = 1;
		int r = 0;
		while (dp[K] < N + 1)
		{
			for (int i = K; i > 0; i--)
				dp[i] += dp[i-1];
			r++;
		}
		return r;
	}
}

