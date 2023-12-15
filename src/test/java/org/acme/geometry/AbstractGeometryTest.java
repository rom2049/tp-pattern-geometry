package org.acme.geometry;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AbstractGeometryTest {

	@Test
	public void testAbstractGeometryEmptyPoint() {
		AbstractGeometry geometry = new Point(new Coordinate());
		assertEquals( "POINT EMPTY", geometry.asText() );
	}

	@Test
	public void testAbstractGeometryPoint() {
		AbstractGeometry geometry = new Point(new Coordinate(3.0,4.0));
		assertEquals( "POINT(3.0 4.0)", geometry.asText() );
	}
	
	@Test
	public void testAbstractGeometryEmptyLineString() {
		AbstractGeometry geometry = new LineString();
		assertEquals("LINESTRING EMPTY", geometry.asText());
	}
	
	
	@Test
	public void testAbstractGeometryLineString() {
		Point p1 = new Point(new Coordinate(0.0, 0.0));
		Point p2 = new Point(new Coordinate(1.0, 1.0));
		Point p3 = new Point(new Coordinate(5.0, 5.0));
		
		Point[] pp = {p1, p2, p3};
		List<Point> listP = new ArrayList<Point>(Arrays.asList(pp));
		AbstractGeometry geometry = new LineString(listP);	
		assertEquals("LINESTRING(0.0 0.0,1.0 1.0,5.0 5.0)", geometry.asText());
	}

}
