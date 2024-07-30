package lab_prog3;

import java.util.Scanner;

//Abstraction: Abstract class
abstract class Vehicle {
 String name;
 
 Vehicle(String name) {
     this.name = name;
 }
 
 // Abstract method
 abstract void displayInfo();
}

//Concrete classes extending the abstract class
class Car extends Vehicle {
 Car(String name) {
     super(name);
 }
 
 // Run-time Polymorphism: Overriding the abstract method
 @Override
 void displayInfo() {
     System.out.println("This is a car named: " + name);
 }
}

class Bike extends Vehicle {
 Bike(String name) {
     super(name);
 }
 
 // Run-time Polymorphism: Overriding the abstract method
 @Override
 void displayInfo() {
     System.out.println("This is a bike named: " + name);
 }
}

public class run_time_poly {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     Vehicle vehicle = null;
     
     while (true) {
         System.out.println("Menu:");
         System.out.println("1. Create Car");
         System.out.println("2. Create Bike");
         System.out.println("3. Exit");
         System.out.print("Enter your choice: ");
         
         int choice = scanner.nextInt();
         scanner.nextLine();  // Consume newline
         
         switch (choice) {
             case 1:
                 System.out.print("Enter the name of the car: ");
                 String carName = scanner.nextLine();
                 vehicle = new Car(carName);
                 vehicle.displayInfo();
                 break;
             case 2:
                 System.out.print("Enter the name of the bike: ");
                 String bikeName = scanner.nextLine();
                 vehicle = new Bike(bikeName);
                 vehicle.displayInfo();
                 break;
             
             case 3:
                 System.out.println("Exiting...");
                 scanner.close();
                 System.exit(0);
             default:
                 System.out.println("Invalid choice. Please try again.");
         }
     }
 }
}