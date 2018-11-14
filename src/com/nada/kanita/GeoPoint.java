package com.nada.kanita;

public class GeoPoint
{
	private final double xCoordinate, yCoordinate;
	
	public GeoPoint(double x, double y)
	{
		this.xCoordinate = x;
		this.yCoordinate = y;
	}
	
	public double getXCoordinate()
	{
		return xCoordinate;
	}
	
	public double getYCoordinate()
	{
		return yCoordinate;
	}
	
	@Override
	public String toString()
	{
		return xCoordinate + "," + yCoordinate;
	}
}
