package org.acme.geometry;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {

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

}
