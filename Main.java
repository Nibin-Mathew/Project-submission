package multpleDimensions;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Rectangle r = new Rectangle(3.1,2.1);// object for Rectangle
		r.area();
		Square s = new Square(3.1);// Object for square
		s.area();
		System.out.println("");
		try{
		ArrayList<Shape> list = new ArrayList<Shape>();
		list.add(r);
		list.add(s);
		
		System.out.println("The size of Arraylist "+list.size());
		
		System.out.println("");
		
		for(int i=0; i<list.size(); i++){
			System.out.println("The calculated list of values in the array are "+list.get(i).area());
		}
		}
	catch(ArrayIndexOutOfBoundsException ae)
	{
		ae.getMessage();
	}

}}