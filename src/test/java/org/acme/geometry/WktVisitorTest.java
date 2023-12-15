package org.acme.geometry;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class WktVisitorTest {

	@Test
	public void testWktVisitorEmptyPoint() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new Point(new Coordinate());
		geometry.accept(visitor);
		assertEquals( "POINT EMPTY", visitor.getResult() );
	}

	@Test
	public void testWktVisitorPoint() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new Point(new Coordinate(3.0,4.0));
		geometry.accept(visitor);
		assertEquals( "POINT(3.0 4.0)", visitor.getResult() );
	}
	
	@Test
	public void testWktVisitorEmptyLineString() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new LineString();
		geometry.accept(visitor);
		assertEquals("LINESTRING EMPTY", visitor.getResult());
	}
	
	
	@Test
	public void testWktVisitorLineString() {
		WktVisitor visitor = new WktVisitor();
		Point p1 = new Point(new Coordinate(0.0, 0.0));
		Point p2 = new Point(new Coordinate(1.0, 1.0));
		Point p3 = new Point(new Coordinate(5.0, 5.0));
		
		Point[] pp = {p1, p2, p3};
		List<Point> listP = new ArrayList<Point>(Arrays.asList(pp));
		Geometry geometry = new LineString(listP);	
		geometry.accept(visitor);
		assertEquals("LINESTRING(0.0 0.0,1.0 1.0,5.0 5.0)", visitor.getResult());
	}
}
