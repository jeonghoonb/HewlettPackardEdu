package day0706;

public class ShapeUser {
	public static void main(String[] args) {
		Shape[] shape = new Shape[3];
		shape[0] = new Circle(5);
		shape[1] = new Circle(7);
		shape[2] = new Rectangle(9, 5);

		System.out.println("Shape[0]'s area : " + shape[0].area());
		System.out.println("Shape[1]'s area : " + shape[1].area());
		System.out.println("Shape[2]'s area : " + shape[2].area());
		System.out.println();
		System.out.println("Shape[0]'s circumference : " + shape[0].circumference());
		System.out.println("Shape[1]'s circumference : " + shape[1].circumference());
		System.out.println("Shape[2]'s circumference : " + shape[2].circumference());
	}
}
