package org.acme.geometry;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LogGeometryVisitorTest {

	@Test
	public void testPoint() {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);

		Geometry g = new Point(new Coordinate(3.0, 4.0));
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		g.accept(visitor);
		String result = os.toString();
		assertEquals("Je suis un point avec x=3.0 et y=4.0", result);
	}
	
	@Test
	public void testEmpty() {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);

		Geometry g = new Point(new Coordinate());
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		g.accept(visitor);
		String result = os.toString();
		assertEquals("Je suis un point vide.", result);
	}
	
	@Test
	public void testLineString() {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		
		Coordinate c1 = new Coordinate(2.0, 5.0);
		Point p1 = new Point(c1);
		Coordinate c2 = new Coordinate(10.0, 2.0);
		Point p2 = new Point(c2);
		Coordinate c3 = new Coordinate(0.0, 3.0);
		Point p3 = new Point(c3);
		
		Point[] pp = {p1, p2, p3};
		List<Point> listP = new ArrayList<Point>(Arrays.asList(pp));

		Geometry g = new LineString(listP);		
		
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		g.accept(visitor);
		String result = os.toString();
		assertEquals("Je suis une polyligne définie par 3 point(s)", result);
	}
	
	@Test
	public void testLineStringEmpty() {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);

		Geometry g = new LineString();		
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		g.accept(visitor);
		String result = os.toString();
		assertEquals("Je suis une polyligne vide.", result);
	}

}
