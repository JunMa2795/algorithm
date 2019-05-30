package apps.collinear;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FastCollinearPoints {
	
	private LineSegment[] lineSegments;

	// finds all line segments containing 4 or more points
	public FastCollinearPoints(Point[] points) {
		checkNull(points);
		checkDuplicate(points);
		
		Arrays.sort(points);

		final int N = points.length;
		final List<LineSegment> list = new LinkedList<>();
		
		for (int i = 0; i < N; i ++) {
			Point p = points[i];
			Point[] pointsBySlope = points.clone();
			Arrays.sort(pointsBySlope, p.slopeOrder());
			
			int x = 1;
			while (x < N) {
				LinkedList<Point> candidates = new LinkedList<>();
				final double SLOPE_REF = p.slopeTo(pointsBySlope[x]);
				do {
					candidates.add(pointsBySlope[x++]);
				} while (x < N && p.slopeTo(pointsBySlope[x]) == SLOPE_REF);
				
				if (candidates.size() >= 3 && p.compareTo(candidates.peek()) < 0) {
					Point min = p;
					Point max = candidates.removeLast();
					list.add(new LineSegment(min, max));
				}
			}
		}
		lineSegments = list.toArray(new LineSegment[0]);
	}

	// the number of line segments
	public int numberOfSegments() {
		return lineSegments.length;
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
