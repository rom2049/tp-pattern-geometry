package org.acme.geometry;

public class WktWriter {
	
	public String write(Geometry geometry) {
		if ( geometry instanceof Point ){
		    Point point = (Point)geometry;
		    if(point.isEmpty()) {
		    	return "POINT EMPTY";
		    } else {
		    	return "POINT("+point.getCoordinate().getX()+" "+point.getCoordinate().getY()+")";
		    }
		}else if ( geometry instanceof LineString ){
		    LineString lineString = (LineString)geometry;
		    if(lineString.isEmpty()) {
		    	return "LINESTRING EMPTY";
		    } else {
		    	String res = "LINESTRING(";
		    	int numPoint = lineString.getNumPoints();
		    	boolean first = true;
		    	for(int i=0; i<numPoint; i++) {
		    		Coordinate c = lineString.getPointN(i+1).getCoordinate();
		    		if(!first) {
		    			res += ",";
		    		}
		    		first = false;
		    		res += c.getX()+" "+c.getY();
		    	}
		    	res += ")";
		    	return res;
		    }
		}else{
		    throw new RuntimeException("geometry type not supported");
		}
	}


}
