package apps.unknown;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Stack;

public class PointSET {

	private SET<Point2D> set;

	// construct an empty set of points
	public PointSET() {
		set = new SET<Point2D>();
	}

	// is the set empty?
	public boolean isEmpty() {
		return set.isEmpty();
	}

	// number of points in the set
	public int size() {
		return set.size();
	}

	// add the point p to the set (if it is not already in the set)
	// proportional to logarithm of N in the worst case
	public void insert(Point2D p) {
		set.add(p);
	}

	// does the set contain the point p?
	// proportional to logarithm of N in the worst case
	public boolean contains(Point2D p) {
		return set.contains(p);
	}

	// draw all of the points to standard draw
	public void draw() {

	}

	// all points in the set that are inside the rectangle
	// proportional to N in the worst case
	public Iterable<Point2D> range(RectHV rect) {
		Stack<Point2D> s = new Stack<Point2D>();

		for (Point2D p : set)
			if (rect.contains(p))
				s.push(p);

		return s;
	}

	// a nearest neighbor in the set to p: null if set is empty
	// proportional to N
	public Point2D nearest(Point2D p) {
		if (isEmpty())
			return null;

		double dis, minDis = Double.MAX_VALUE;
		Point2D q = null;

		for (Point2D ip : set) {
			dis = p.distanceSquaredTo(ip);
			if (dis < minDis) {
				minDis = dis;
				q = ip;
			}
		}

		return q;
	}
}
