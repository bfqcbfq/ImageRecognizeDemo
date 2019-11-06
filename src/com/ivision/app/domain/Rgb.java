package com.ivision.app.domain;

public class Rgb {
	
	private int rgbR;
	
	private int rgbG;
	
	private int rgbB;

	
	
	public Rgb() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Rgb(int rgbR, int rgbG, int rgbB) {
		super();
		this.rgbR = rgbR;
		this.rgbG = rgbG;
		this.rgbB = rgbB;
	}



	public int getRgbR() {
		return rgbR;
	}



	public void setRgbR(int rgbR) {
		this.rgbR = rgbR;
	}



	public int getRgbG() {
		return rgbG;
	}



	public void setRgbG(int rgbG) {
		this.rgbG = rgbG;
	}



	public int getRgbB() {
		return rgbB;
	}



	public void setRgbB(int rgbB) {
		this.rgbB = rgbB;
	}



	@Override
	public String toString() {
		return "Rgb [rgbR=" + rgbR + ", rgbG=" + rgbG + ", rgbB=" + rgbB + "]";
	}
	
	

}
