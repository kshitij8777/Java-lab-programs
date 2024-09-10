package lab_prog3;

import java.util.*;

abstract class Printer {
	abstract void configuration();
	abstract void display();
}

class DotMatrix extends Printer {
	void configuration() {
		System.out.println("Dot-Matrix configuration");
	}
	void display() {
		System.out.println("Dot-Matrix display");;
	}
}

class LaserJet extends Printer {
	void configuration() {
		System.out.println("Laser-Jet configuration");
	}
	void display() {
		System.out.println("Laser-Jet display");
	}
}

public class abstraction {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Printer pr;
		System.out.println("1.Dot-Matrix \n2.Laser-Jet \n3.Exit");
		while(true) {
			System.out.println("Enter ur choice:");
			int ch = sc.nextInt();
			switch (ch) {
			case 1: {
				pr = new DotMatrix();
				pr.configuration();
				pr.display();
				break;
			}
			case 2: {
				pr = new LaserJet();
				pr.configuration();
				pr.display();
				break;
			}
			case 3:
				System.out.println("Exit");
				sc.close();
				return;
			default:
				System.out.println("Invalid choice");
				break;
			}
		}
	}
}








# run time polimorphism 
	
package lab3;

import java.util.Scanner;

interface Vehicle{
	abstract void drive();
}

class Car implements Vehicle{
	public void drive() {
		System.out.println("Human driving car");
	}
}

class MotorCycle implements Vehicle{
	public void drive() {
		System.out.println("Human driving motorcycle");
	}
}

public class Polymorphism {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vehicle c;
		Vehicle m;
		System.out.println("1.Car\n2.Motorcycle\n3.Exit");
		while(true) {
			System.out.println("Enter your choice:");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:{
				c = new Car();
				c.drive();
				break;
			}
			case 2:{
				m = new MotorCycle();
				m.drive();
				break;
			}
			case 3:
				System.out.println("Exit from program");
				sc.close();
				return;
				default:
					System.out.println("Invalid choice");
					break;
			}
		}	
	/*	Vehicle c = new Car();
		Vehicle m = new MotorCycle();
		c.drive();
		m.drive(); */
	}
}
