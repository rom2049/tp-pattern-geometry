package org.acme.geometry;

public class Point extends AbstractGeometry {
	
	private Coordinate coordinate;
	
	public Point() {
//		this.coordinate = new Coordinate();
		this(Coordinate.EMPTY);
	}
	
	public Point(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public Coordinate getCoordinate() {
		return this.coordinate;
	}
	
	@Override
	public String getType() {
		return "Point";
	}

	@Override
	public Boolean isEmpty() {
		return this.coordinate.isEmpty();
	}
	
	@Override
	public void translate(double dx, double dy) {
		double newX = this.coordinate.getX() + dx;
		double newY = this.coordinate.getY() + dy;
		Coordinate newCoord = new Coordinate(newX, newY);
		this.coordinate = newCoord;
	}
	
	@Override
	public Point clone() {
		return new Point(this.coordinate);
	}
	
	@Override
	public Envelope getEnvelope() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		builder.insert(this.coordinate);
		Envelope result = builder.build();
		return result;
	}
	
	@Override
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}
}
