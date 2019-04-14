package day0706;

public class Rectangle extends Shape {

	protected int width, height;

	public Rectangle() {
		width = 0;
		height = 0;
	}

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
		x = getWidth();
		y = getHeight();
	}

	@Override
	public double area() {
		return width * height;
	}

	@Override
	public double circumference() {
		return 2 * (width + height);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}