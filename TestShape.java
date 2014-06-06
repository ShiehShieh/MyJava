import java.io.*;

class Circle {
	private double x;
	private double y;
	private double radius;
//	private BufferReader stdout = new BufferReader(new InputStreamReader(System.in));
	Circle(double x, double y, double radius){
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	double findArea(){
		System.out.println("Area :" + 3.14 * this.radius * this.radius);
		return 3.14 * this.radius * this.radius;
	}

	double findPerimeter(){
		System.out.println("Perimeter :" + 6.28 * this.radius);
		return 6.28 * this.radius;
	}

	void display(){
		System.out.println("Central point location :" + this.x + "," + this.y);
		System.out.println("Radius :" + this.radius);
	}

}

class Rectangle {
	private double x;
	private double y;
	private double width;
	private double height;

	Rectangle(double x, double y, double width, double height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	double findArea(){
		System.out.println("Area :" + this.width * this.height);
		return this.width * this.height;
	}

	double findPerimeter(){
		System.out.println("Perimeter :" + 2 * (this.width + this.height));
		return 2 * (this.width + this.height);
	}

	void display(){
		System.out.println("Upper left location :" + this.x + "," + this.y);
		System.out.println("Size :" + this.width + " ," + this.height);
	}

}

public class TestShape {
	public static void main(String[] args) {
		Circle[] circles = new Circle[5];
		Rectangle[] rectangles = new Rectangle[5];
		Rectangle rectangle = new Rectangle(0, 5, 5, 5);
		int i = 0;

		for (double x = 0, y = 0, r = 1; i < circles.length; ++x, ++y, ++r, ++i) {
			circles[i] = new Circle(x, y, r);
		}

		i = 0;
		for (double x = 0, y = 0, w = 1, h = 2; i < rectangles.length; ++x, ++y, ++w, ++h, ++i) {
			rectangles[i] = new Rectangle(x, y, w, h);
		}

		for (int ii = 0; ii < circles.length; ++ii) {
			circles[ii].display();
			rectangles[ii].display();
			System.out.println();
		}

	}

}
