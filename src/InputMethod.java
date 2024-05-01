import java.util.Scanner;

public class InputMethod {
    Scanner sc = new Scanner(System.in);
    int value = 0;
    boolean validInput = false;

    public int getInt() {
        validInput = false;
        while (!validInput) {
            try {
                String input = sc.nextLine();
                // Check if the input is not empty
                if (!input.trim().isEmpty()) {

                    value = Integer.parseInt(input);
                    validInput = true; // Input is valid, exit the loop
                } else {
                    System.out.println("No input provided. Please enter a number.");
                    System.out.print("RE-ENTER YOUR CHOICE: " );
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                System.out.print("RE-ENTER YOUR CHOICE: " );
            }
        }
        System.out.println("You entered: " + value);
        return value;
    }
}
