package apps.collinear;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BruteCollinearPoints {
	private LineSegment[] lineSegments;

	// finds all line segments containing 4 points
	public BruteCollinearPoints(Point[] points) {
		checkNull(points);
		checkDuplicate(points);

		Arrays.sort(points);

		final int N = points.length;
		final List<LineSegment> list = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			Point p = points[i];
			for (int j = i + 1; j < N; j++) {
				Point q = points[j];
				for (int k = j + 1; k < N; k++) {
					Point r = points[k];
					for (int l = k + 1; l < N; l++) {
						Point s = points[l];
						if (p.slopeTo(q) == q.slopeTo(r) && q.slopeTo(r) == r.slopeTo(s)) {
							list.add(new LineSegment(p, s));
						}
					}
				}
			}
			lineSegments = list.toArray(new LineSegment[0]);
		}
	}

	// the number of line segments
	public int numberOfSegments() {
		return this.lineSegments.length;
	}

	// the line segments
	public LineSegment[] segments() {
		return this.lineSegments.clone();
	}

	private void checkNull(Point[] points) {
		if (points == null)
			throw new IllegalArgumentException();
		for (Point p : points) {
			if (p == null) {
				throw new IllegalArgumentException();
			}
		}
	}

	private void checkDuplicate(Point[] points) {
		for (int i = 0; i < points.length - 1; i++) {
			if (points[i].compareTo(points[i + 1]) == 0) {
				throw new IllegalArgumentException("Duplicate(s) found.");
			}
		}
	}
}
