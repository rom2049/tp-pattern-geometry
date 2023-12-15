package org.acme.geometry;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {
	
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testConstructorLineStringEmpty() {
		LineString l = new LineString();
		Assert.assertEquals(0, l.getNumPoints());		
	}
	
	@Test
	public void testConstructorLineString() {
		Point p1 = new Point();
		Point p2 = new Point();
		Point p3 = new Point();
		Point[] pp = {p1, p2, p3};
		List<Point> listP = new ArrayList<Point>(Arrays.asList(pp));
		
		
		LineString l = new LineString(listP);
		Assert.assertEquals(3, l.getNumPoints());		
	}
	
	@Test
	public void testLineStringGetType() {
		LineString l = new LineString();
		Assert.assertEquals("LineString", l.getType());
	}
	
	@Test
	public void testLineStringGetNpoint() {
		Point p1 = new Point();
		Point p2 = new Point();
		Point p3 = new Point();
		Point[] pp = {p1, p2, p3};
		List<Point> listP = new ArrayList<Point>(Arrays.asList(pp));
		
		
		LineString l = new LineString(listP);
		Assert.assertEquals(p2, l.getPointN(2));
	}
	
	@Test
	public void testLineStringIsEmpty() {
		LineString l = new LineString();
		Assert.assertTrue(l.isEmpty());
	}
	
	@Test
	public void testLineStringTranslate() {
		Coordinate c1 = new Coordinate(2.0, 5.0);
		Point p1 = new Point(c1);
		Coordinate c2 = new Coordinate(10.0, 2.0);
		Point p2 = new Point(c2);
		Coordinate c3 = new Coordinate(0.0, 3.0);
		Point p3 = new Point(c3);
		
		Point[] pp = {p1, p2, p3};
		List<Point> listP = new ArrayList<Point>(Arrays.asList(pp));
		
		LineString l = new LineString(listP);
		
		l.translate(1.0, 2.0);
		
		
		Assert.assertEquals(3.0, l.getPointN(1).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(4.0, l.getPointN(2).getCoordinate().getY(), EPSILON);
		Assert.assertEquals(5.0, l.getPointN(3).getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testLineStringClone() {
		Coordinate c1 = new Coordinate(2.0, 5.0);
		Point p1 = new Point(c1);
		Coordinate c2 = new Coordinate(10.0, 2.0);
		Point p2 = new Point(c2);
		Coordinate c3 = new Coordinate(0.0, 3.0);
		Point p3 = new Point(c3);
		
		Point[] pp = {p1, p2, p3};
		List<Point> listP = new ArrayList<Point>(Arrays.asList(pp));
		
		LineString l = new LineString(listP);
		
		LineString clone = l.clone();		
		
		Assert.assertNotEquals(l, clone);
		
		clone.translate(2.0, 2.0);
		
		Assert.assertEquals(4.0, clone.getPointN(1).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(4.0, l.getPointN(1).getCoordinate().getX(), EPSILON);
	}
	
	@Test
	public void testLineStringEnvelope() {
		Coordinate c1 = new Coordinate(2.0, 5.0);
		Point p1 = new Point(c1);
		Coordinate c2 = new Coordinate(10.0, 2.0);
		Point p2 = new Point(c2);
		Coordinate c3 = new Coordinate(0.0, 3.0);
		Point p3 = new Point(c3);
		
		Point[] pp = {p1, p2, p3};
		List<Point> listP = new ArrayList<Point>(Arrays.asList(pp));
		
		LineString l = new LineString(listP);	
		Envelope env = l.getEnvelope();
		
		Assert.assertEquals("0.0,2.0,10.0,5.0", env.toString());
	}

}
