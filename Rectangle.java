package multpleDimensions;

public class Rectangle extends Shape {
	protected double width, length;

	protected Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}

	@Override
	protected double area() {
		System.out.println("");
		System.out.println("***Area of a Rectangle***");
		return width * length ;
	} }




