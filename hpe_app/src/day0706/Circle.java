package day0706;

public class Circle extends Shape {

	protected int radius;

	public Circle() {
		radius = 0;
	}

	public Circle(int radius) {
		this.radius = radius;
		r = getRadius();
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public double area() {
		return (Math.PI * radius * radius);
	}

	@Override
	public double circumference() {
		return (Math.PI * radius * 2);
	}
}
