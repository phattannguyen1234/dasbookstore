import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookMethod bookMethod = new BookMethod();
        InputMethod inputMethod = new InputMethod();
        OrderMethod orderMethod = new OrderMethod();

        Scanner sc = new Scanner( System.in);
        int choice = 0;
        boolean running = true;

        // ADD SOME INITIAL BOOKS
        bookMethod.addBook("title q", "a", "b", 10, 99);
        bookMethod.addBook("title t", "a", "a", 10, 87);
        bookMethod.addBook("title c", "a", "b", 10, 45);
        bookMethod.addBook("title b", "a", "c", 10, 100);
        bookMethod.addBook("title d", "a", "a", 10, 12);
        bookMethod.addBook("title x", "a", "d", 10, 34);
        bookMethod.addBook("title y", "a", "c", 10, 25);
        bookMethod.addBook("title z", "a", "b", 10, 21);
        bookMethod.addBook("title g", "a", "b", 10, 11);
        bookMethod.addBook("title h", "a", "a", 10, 33);

        // ADD SOME INITIAL ORDERS
        orderMethod.addBookToBuy( bookMethod.findBookByIdToCreateOrder( 1, 5), 5);
        orderMethod.addBookToBuy( bookMethod.findBookByIdToCreateOrder( 1, 5), 5);
        orderMethod.addBookToBuy( bookMethod.findBookByIdToCreateOrder( 1, 2), 2);
        orderMethod.createAOrder("A", "A123");
//        orderMethod.addBookToBuy( bookMethod.findBookByIdToCreateOrder( 2, 2), 2);
//        orderMethod.addBookToBuy( bookMethod.findBookByIdToCreateOrder( 3, 2), 2);
//        orderMethod.addBookToBuy( bookMethod.findBookByIdToCreateOrder( 4, 2), 2);
//        orderMethod.createAOrder("B", "B234");


        while (running) {
            // MENU
            System.out.println("   [BOOK STORE MENU]");
            System.out.println("[1]   ADD A NEW BOOK");
            System.out.println("[2]   DISPLAY ALL BOOKS");
            System.out.println("[3]   UPDATE A BOOK BY ID");
            System.out.println("[4]   DELETE A BOOK BY ID");
            System.out.println("[5]   DISPLAY BOOK SORTED BY TITLE");
            System.out.println("[6]   DISPLAY BOOK SORTED BY AUTHOR AND PRICE");
            System.out.println("[7]   CREATE A NEW ORDER");
            System.out.println("[8]   DISPLAY ALL ORDERS");
            System.out.println("[9]   FIND OR CANCEL ORDER BY ID");
            System.out.println("[10]  DISPLAY AND PROCESS THE PENDING ORDER");
            System.out.println("[11]  DISPLAY AND PROCESS THE SHIPPING ORDER");
            System.out.println("[12]  CLOSE PROGRAM ");
            System.out.println("############################################################" );
            System.out.print("ENTER YOUR CHOICE: " );

            choice = inputMethod.getInt();
            System.out.println("############################################################" );
            switch(choice){
                case 1:
                    bookMethod.addABook();
                    System.out.println("############################################################" );
                    break;
                case 2:
                    bookMethod.displayBooks();
                    System.out.println("############################################################" );
                    break;
                case 3:
                    bookMethod.editBookById();
                    System.out.println("############################################################" );
                    break;
                case 4:
                    bookMethod.deleteBookById();
                    System.out.println("############################################################" );
                    break;
                case 5:
                    bookMethod.sortAndDisplayByTitle();
                    System.out.println("############################################################" );
                    break;
                case 6:
                    bookMethod.sortAndDisplayByAuthorAndPrice();
                    System.out.println("############################################################" );
                    break;
                case 7:
                    System.out.println("   [CREATE A NEW ORDER]");
                    do{
                        System.out.print("SELECT THE BOOK YOU WANT TO BUY BY ID: ");
                        int bookId = inputMethod.getInt();
                        System.out.print("ENTER THE AMOUNT: ");
                        int quantity = inputMethod.getInt();
                        Book book = bookMethod.findBookByIdToCreateOrder( bookId, quantity);
                        if( book != null){
                            System.out.print("ARE YOU SURE TO ADD THIS BOOK TO BUY? [1]YES/ [0]NO: ");
                            choice = inputMethod.getInt();
                            if(choice == 1){
                                orderMethod.addBookToBuy( book, quantity );
                            }
                        }
                        System.out.print("ADD ANOTHER BOOK? [1]YES/ [0]NO: ");
                        choice = inputMethod.getInt();
                        if(choice == 0){
                            running = false;
                        }
                    } while( running );
                    orderMethod.createOrder();
                    System.out.println("############################################################" );
                    running = true;
                    break;
                case 8:
                    orderMethod.displayOrders();
                    System.out.println("############################################################" );
                    break;
                case 9:
                    orderMethod.findOrCancelOrderById();
                    System.out.println("############################################################" );
                    break;
                case 10:
                    orderMethod.shipTheOrder();
                    System.out.println("############################################################" );
                    break;
                case 11:
                    orderMethod.doneTheOrder();
                    System.out.println("############################################################" );
                    break;
                case 12:
                    running = false;
                    break;
            }
        }
    }
}