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
                    bookMethod.addABook();
                    break;
                case 2:
                    System.out.print("Enter the book's id: " );
                    System.out.println("############################################################" );
                    break;
                case 3:
                    System.out.println("############################################################" );
                    break;
                case 4:
                    orderMethod.displayOrders();
                    break;
                case 5:
                    bookMethod.displayBooks();
                    break;
                case 6:
                    bookMethod.sortAndDisplayByTitle();
                    break;
                case 7:
                    bookMethod.sortByTitle();
                    break;
                case 8:
                    do{
                        System.out.print("SELECT YOUR BOOK --- BOOK ID: ");
                        int bookId = inputMethod.getInt();
                        System.out.print("QUANTITY OF THE BOOK: ");
                        int quantity = inputMethod.getInt();
                        Book book = bookMethod.findBookByIdToCreateOrder( bookId, quantity);
                        System.out.println( book );


                        System.out.print("ARE YOU SURE TO ADD THIS BOOK TO BUY? [1]YES/ [0]NO: ");
                        choice = inputMethod.getInt();
                        if(choice == 1){
                            orderMethod.addBookToBuy( book, quantity );
                        }

                        System.out.print("ADD ANOTHER BOOK? [1]YES/ [0]NO: ");
                        choice = inputMethod.getInt();
                        if(choice == 0){
                            running = false;
                        }
                    } while(running);

                    orderMethod.createOrder();
                    break;
                case 9:
                    bookMethod.sortByAuthorAndPrice();
                    break;
                case 10:
                    running = false;
                    break;
            }
        }
    }
}