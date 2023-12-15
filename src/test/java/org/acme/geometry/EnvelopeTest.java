package org.acme.geometry;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeTest {
	
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testConstructorEnvelope() {
		Envelope env = new Envelope();
		Assert.assertTrue(env.isEmpty());		
	}
	
	@Test
	public void testEnvelopeGet() {
		Coordinate c1 = new Coordinate(0.0,1.0);
		Coordinate c2 = new Coordinate(2.0,3.0);
		Envelope env = new Envelope(c1, c2);
		
		Assert.assertEquals(0.0, env.getXmin(),EPSILON);
		Assert.assertEquals(2.0, env.getXmax(),EPSILON);
		Assert.assertEquals(1.0, env.getYmin(),EPSILON);
		Assert.assertEquals(3.0, env.getYmax(),EPSILON);
	}
	
	@Test
	public void testEnvelopeToString() {
		Coordinate c1 = new Coordinate(0.0,1.0);
		Coordinate c2 = new Coordinate(2.0,3.0);
		Envelope env = new Envelope(c1, c2);
		
		Assert.assertEquals("0.0,1.0,2.0,3.0", env.toString());
	}

}
