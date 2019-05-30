package com.sort;

import com.util.Util;

import edu.princeton.cs.algs4.StdRandom;

public class KnuthShuffle {
	public static void shuffle(Object[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int r = StdRandom.uniform(i + 1);
			Util.exch(a, i, r);
		}
	}
}
