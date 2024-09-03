package java_basics.proj6.program7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class NumberOperations<T extends Number> {

    private List<T> numbers;

    public NumberOperations() {
        this.numbers = new ArrayList<>();
    }

    public void addNumber(T number) {
        numbers.add(number);
    }

    public void removeNumber(T number) {
        numbers.remove(number);
    }

    public List<T> getNumbers() {
        return numbers;
    }

    public static double sum(List<? extends Number> list) {
        double sum = 0.0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        Collections.sort(list);
    }
}

public class labprogram8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumberOperations<Number> operations = new NumberOperations<>();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Integer");
            System.out.println("2. Add Double");
            System.out.println("3. Remove Number");
            System.out.println("4. Calculate Sum");
            System.out.println("5. Sort Numbers");
            System.out.println("6. Display Numbers");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter an Integer: ");
                    int intValue = scanner.nextInt();
                    operations.addNumber(intValue);
                    break;
                case 2:
                    System.out.print("Enter a Double: ");
                    double doubleValue = scanner.nextDouble();
                    operations.addNumber(doubleValue);
                    break;
                case 3:
                    System.out.print("Enter the number to remove (Integer or Double): ");
                    if (scanner.hasNextInt()) {
                        int removeInt = scanner.nextInt();
                        operations.removeNumber(removeInt);
                    } else if (scanner.hasNextDouble()) {
                        double removeDouble = scanner.nextDouble();
                        operations.removeNumber(removeDouble);
                    } else {
                        System.out.println("Invalid input.");
                    }
                    break;
                case 4:
                    double sum = NumberOperations.sum(operations.getNumbers());
                    System.out.println("Sum of numbers: " + sum);
                    break;
                case 5:
                    List<Double> doubleList = new ArrayList<>();
                    for (Number num : operations.getNumbers()) {
                        doubleList.add(num.doubleValue());
                    }
                    NumberOperations.sort(doubleList);
                    System.out.println("Sorted numbers: " + doubleList);
                    break;
                case 6:
                    System.out.println("Current numbers: " + operations.getNumbers());
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }
}
