import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookMethod bookMethod = new BookMethod();
        InputMethod inputMethod = new InputMethod();
        Scanner sc = new Scanner( System.in);
        int choice = 0;
        boolean running = true;

        while (running) {
            // MENU
            System.out.println("[1]  ADD A NEW BOOK");
            System.out.println("[2]  EDIT A BOOK");
            System.out.println("[3]  DELETE A BOOK");
            System.out.println("[4]  SEARCH BOOKS");
            System.out.println("[5]  VIEW ALL BOOKS SORTED BY ");
            System.out.println("[10] CLOSE PROGRAM ");
            System.out.println("############################################################" );
            System.out.print("ENTER YOUR CHOICE: " );

            choice = inputMethod.getInt();
            System.out.println("############################################################" );
            switch(choice){
                case 1:
                    System.out.println("[ADD A NEW BOOK]" );
                    System.out.print("Enter the book's title: " );
                    String title = sc.nextLine();
                    System.out.print("Enter the book's category: " );
                    String category = sc.nextLine();
                    System.out.print("Enter the book's author: " );
                    String author = sc.nextLine();
                    System.out.print("Enter the book's quantity: " );
                    int quantity = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter the book's price: " );
                    int price = Integer.parseInt(sc.nextLine());
                    bookMethod.addBook( title, category, author, quantity, price);
                    System.out.println( "The book added successfully!" );
                    System.out.println("############################################################" );
                    break;
                case 2:
                    System.out.print("Enter the book's id: " );
                    System.out.println("############################################################" );
                    break;
                case 3:
                    System.out.println("############################################################" );
                    break;
                case 4:
                    bookMethod.addABook();
                    break;
                case 5:
                    bookMethod.displayBooks();
                    break;
                case 10:
                    running = false;
                    break;
            }
        }
    }
}