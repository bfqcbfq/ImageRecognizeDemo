package com.ivision.app.domain;

public class Rgb {
	
	private double rgbR;
	
	private double rgbG;
	
	private double rgbB;

	
	
	public Rgb() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Rgb(double rgbR, double rgbG, double rgbB) {
		super();
		this.rgbR = rgbR;
		this.rgbG = rgbG;
		this.rgbB = rgbB;
	}



	public double getRgbR() {
		return rgbR;
	}



	public void setRgbR(double rgbR) {
		this.rgbR = rgbR;
	}



	public double getRgbG() {
		return rgbG;
	}



	public void setRgbG(double rgbG) {
		this.rgbG = rgbG;
	}



	public double getRgbB() {
		return rgbB;
	}



	public void setRgbB(double rgbB) {
		this.rgbB = rgbB;
	}



	@Override
	public String toString() {
		return "Rgb [rgbR=" + rgbR + ", rgbG=" + rgbG + ", rgbB=" + rgbB + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(rgbB);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rgbG);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rgbR);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rgb other = (Rgb) obj;
		if (Double.doubleToLongBits(rgbB) != Double.doubleToLongBits(other.rgbB))
			return false;
		if (Double.doubleToLongBits(rgbG) != Double.doubleToLongBits(other.rgbG))
			return false;
		if (Double.doubleToLongBits(rgbR) != Double.doubleToLongBits(other.rgbR))
			return false;
		return true;
	}
	
	
	

	

}
