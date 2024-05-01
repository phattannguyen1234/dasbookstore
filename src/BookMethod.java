import java.util.Scanner;

public class BookMethod {
    private final ArrayList<Book> books;
    private int bookId;
    InputMethod inputMethod = new InputMethod();
    Scanner sc = new Scanner(System.in);

    public BookMethod(){
        books = new ArrayList<>();
        bookId = 1;
    }
    public void addBook( String title, String category, String author, int quantity, int price){

        Book book = new Book(bookId, title, category, author, quantity, price );
        books.add( book );
        bookId++;
    }

    public void addABook(){
        System.out.println("[ADD A NEW BOOK]" );
        System.out.print("Enter the book's title: " );
        String title = sc.nextLine();
        System.out.print("Enter the book's category: " );
        String category = sc.nextLine();
        System.out.print("Enter the book's author: " );
        String author = sc.nextLine();
        System.out.print("Enter the book's quantity: " );
        int quantity = inputMethod.getInt();
        System.out.print("Enter the book's price: " );
        int price = inputMethod.getInt();
        Book book = new Book(bookId, title, category, author, quantity, price );
        books.add( book );
        bookId++;
        System.out.println( "The book added successfully!" );
        System.out.println("############################################################" );
    }

    public void displayBooks(){
        System.out.println("Book list:" );
        for(int i = 0; i < books.size() ; i++){
            System.out.println( books.get(i) );
        }
    }

    public void findBookById(){

    }

}
