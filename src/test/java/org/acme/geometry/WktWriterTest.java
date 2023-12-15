package org.acme.geometry;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class WktWriterTest {

	@Test
	public void testWriteEmptyPoint() {
		Geometry g = new Point(new Coordinate());
		WktWriter writer = new WktWriter();
		assertEquals("POINT EMPTY", writer.write(g));
	}
	
	@Test
	public void testWritePoint() {
		Geometry g = new Point(new Coordinate(3.0,4.0));
		WktWriter writer = new WktWriter();
		assertEquals("POINT(3.0 4.0)", writer.write(g));
	}
	
	@Test
	public void testWriteEmptyLineString() {
		Geometry g = new LineString();
		WktWriter writer = new WktWriter();
		assertEquals("LINESTRING EMPTY", writer.write(g));
	}
	
	
	@Test
	public void testWriteLineString() {
		Point p1 = new Point(new Coordinate(0.0, 0.0));
		Point p2 = new Point(new Coordinate(1.0, 1.0));
		Point p3 = new Point(new Coordinate(5.0, 5.0));
		
		Point[] pp = {p1, p2, p3};
		List<Point> listP = new ArrayList<Point>(Arrays.asList(pp));
		LineString l = new LineString(listP);	
		
		WktWriter writer = new WktWriter();
		assertEquals("LINESTRING(0.0 0.0,1.0 1.0,5.0 5.0)", writer.write(l));
	}

}
