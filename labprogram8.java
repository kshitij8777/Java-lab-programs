import java.util.ArrayList;
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

    public double sum() {
        double sum = 0;
        for (T number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
}

public class lab8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumberOperations<Number> operations = new NumberOperations<>();
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Integer");
            System.out.println("3. Remove Number");
            System.out.println("4. Calculate Sum");
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

                case 3:
                    System.out.print("Enter the number to remove  : ");
                        int removeInt = scanner.nextInt();
                        operations.removeNumber(removeInt);
                    
                    break;

                case 4:
                    double sum = operations.sum();
                    System.out.println("Sum of numbers: " + sum);
                    break;

                case 6:
                    System.out.println("Current numbers: " + operations.getNumbers());
                    break;

                case 7:
                   
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        
    }
}
