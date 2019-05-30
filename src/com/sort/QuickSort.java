package com.sort;

import com.util.Util;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		while (true) {
			while (Util.less(a[++i], a[lo]))
				if (i == hi)
					break;
			while (Util.less(a[lo], a[--j]))
				if (j == lo)
					break;

			if (i >= j)
				break;
			Util.exch(a, i, j);
		}
		Util.exch(a, lo, j);
		return j;
	}

	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}
}
