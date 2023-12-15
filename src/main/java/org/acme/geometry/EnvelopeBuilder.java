package org.acme.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnvelopeBuilder {
	
	private List<Double> xVals = new ArrayList<Double>();
	private List<Double> yVals = new ArrayList<Double>();
	
	public void insert(Coordinate coordinate) {
		this.xVals.add(coordinate.getX());
		this.yVals.add(coordinate.getY());
	}
	
	public Envelope build() {
		double xmin = Collections.min(this.xVals);
		double xmax = Collections.max(this.xVals);
		double ymin = Collections.min(this.yVals);
		double ymax = Collections.max(this.yVals);
		
		Coordinate bottomLeft = new Coordinate(xmin, ymin);
		Coordinate topRight = new Coordinate(xmax, ymax);
		return new Envelope(bottomLeft, topRight);
	}

}
