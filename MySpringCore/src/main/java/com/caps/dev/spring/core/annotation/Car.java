package com.caps.dev.spring.core.annotation;

public class Car {

	private String brand;
	private String name;
	private Engine eng;
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", name=" + name + ", eng=" + eng + "]";
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Engine getEng() {
		return eng;
	}
	public void setEng(Engine eng) {
		this.eng = eng;
	}
}
