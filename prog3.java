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
