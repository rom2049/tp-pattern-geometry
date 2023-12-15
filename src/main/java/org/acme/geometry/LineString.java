package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry {
	
	private List<Point> points;
	
	public LineString() {
//		this.points = new ArrayList<Point>();
		this(null);
	}

	public LineString(List<Point> points) {
		this.points = points != null ? points : new ArrayList<Point>();
	}
	
	public int getNumPoints() {
		return this.points.size();
	}
	
	public Point getPointN(int n) {
		return this.points.get(n-1);
	}
	
	@Override
	public String getType() {
		return "LineString";
	}
	
	@Override
	public Boolean isEmpty() {
		return this.points.isEmpty();
	}
	
	@Override
	public void translate(double dx, double dy) {
		for(Point p: points) {
			p.translate(dx, dy);
		}
	}
	
	@Override
	public LineString clone() {
		return new LineString(this.points);
	}
	
	@Override
	public Envelope getEnvelope() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		for(Point p: this.points) {
			builder.insert(p.getCoordinate());
		}
		Envelope result = builder.build();
		return result;
	}
	
	@Override
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}
}
