package multpleDimensions;

public class Square extends Shape {

	protected double a;

	protected Square(double a) {
		this.a = a;
	}

	@Override
	public double area() {
		System.out.println("");
		System.out.println("***Area of a Square***");
		return a * a;
	}


}
