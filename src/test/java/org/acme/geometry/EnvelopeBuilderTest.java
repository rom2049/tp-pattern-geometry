package org.acme.geometry;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeBuilderTest {

	@Test
	public void testEnvelopeBuilder() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		builder.insert(new Coordinate(0.0,1.0));
		builder.insert(new Coordinate(2.0,0.0));
		builder.insert(new Coordinate(1.0,3.0));
		Envelope result = builder.build();
		
		Assert.assertEquals("0.0,0.0,2.0,3.0", result.toString());
	}

}
