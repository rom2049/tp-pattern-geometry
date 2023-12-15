package org.acme.geometry;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
	
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testConstructorPointEmpty() {
		Point p = new Point();
		Assert.assertTrue(p.getCoordinate().isEmpty());		
	}
	
	@Test
	public void testConstructorPoint() {
		Coordinate c = new Coordinate(3.0,4.0);
		Point p = new Point(c);
		Assert.assertEquals(c, p.getCoordinate());		
	}
	
	@Test
	public void testPointGetType() {
		Point p = new Point();
		Assert.assertEquals("Point", p.getType());		
	}
	

	@Test
	public void testPointIsEmpty() {
		Point p = new Point();
		Assert.assertTrue(p.isEmpty());		
	}
	

}
