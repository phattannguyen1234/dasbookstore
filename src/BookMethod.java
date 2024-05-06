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
        System.out.println("   [ADD A NEW BOOK]" );
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
    }

    public void displayBooks(){
        System.out.println("   [DISPLAY ALL BOOKS]" );
        System.out.printf("%-13s%-25s%-20s%-20s%-18s%-16s%n", "[BOOK ID]", "[BOOK TITLE]", "[CATEGORY]", "[AUTHOR]", "[QUANTITY]", "[PRICE] (VND)");
        for(int i = 0; i <= books.size() ; i++){
            System.out.println( books.get(i) );
        }
    }

    public void editBookById(){
        System.out.println( "   [EDIT A BOOK SEARCH BY ID]" );
        System.out.print( "ENTER THE BOOK ID: " );
        int id = inputMethod.getInt();
        int check = 0;
        int i;
        for(i = 0; i <= books.size() ; i++){
            if(books.get(i).getId() == id){
                System.out.println( "HERE IS THE BOOK YOU WANT TO EDIT" );
                System.out.printf("%-13s%-25s%-20s%-20s%-18s%-16s%n", "[BOOK ID]", "[BOOK TITLE]", "[CATEGORY]", "[AUTHOR]", "[QUANTITY]", "[PRICE] (VND)");
                System.out.println( books.get(i) );
                check = 1;
                break;
            }
        }
        if( check == 0 ){
            System.out.println( "CAN NOT FIND THE BOOK" );
        } else {
            String strValue;
            Integer intValue;
            System.out.println( "[NOTICE] *** INPUT NOTHING, NOTHING BE CHANGED" );
            System.out.print( "ENTER NEW TITLE: " );
            strValue = inputMethod.strAcceptNull();
            if( strValue != null ){
                books.get( i ).setTitle( strValue );
            }

            System.out.print( "ENTER NEW AUTHOR:" );
            strValue = inputMethod.strAcceptNull();
            if( strValue != null ){
                books.get( i ).setAuthor( strValue );
            }

            System.out.print( "ENTER NEW QUANTITY:" );
            intValue = inputMethod.intAcceptNull();
            if( intValue != null ){
                books.get( i ).setQuantity( intValue );
            }

            System.out.print( "ENTER NEW PRICE:" );
            intValue = inputMethod.intAcceptNull();
            if( intValue != null ){
                books.get( i ).setPrice( intValue );
            }
        }
    }

    public void deleteBookById(){
        System.out.println( "   [DELETE A BOOK SEARCH BY ID]" );
        System.out.print( "ENTER THE BOOK ID: " );
        int id = inputMethod.getInt();
        int check = 0;
        int i;
        for(i = 0; i <= books.size() ; i++){
            if(books.get(i).getId() == id){
                System.out.println( "HERE IS THE BOOK YOU WANT TO DELETE" );
                System.out.printf("%-13s%-25s%-20s%-20s%-18s%-16s%n", "[BOOK ID]", "[BOOK TITLE]", "[CATEGORY]", "[AUTHOR]", "[QUANTITY]", "[PRICE] (VND)");
                System.out.println( books.get(i) );
                check = 1;
                break;
            }
        }
        if( check == 0 ) {
            System.out.println("CAN NOT FIND THE BOOK");
        }else {
            System.out.print( "ARE YOU SURE TO DELETE? [1]YES/ [0]NO: " );
            int choice = inputMethod.getInt();
            if( choice == 1 ){
                books.remove( i );
                System.out.println( "DELETED SUCCESSFULLY" );
            }
        }
    }

    public Book findBookByIdToCreateOrder(int id, int quantity){
        int i = 0;
        int check = 0;
        for(i = 0; i <= books.size(); i++){
            if(books.get(i).getId() == id){
                System.out.println("HERE IS THE BOOK YOU WANT TO BUY" );
                System.out.printf("%-13s%-25s%-20s%-20s%-18s%-16s%n", "[BOOK ID]", "[BOOK TITLE]", "[CATEGORY]", "[AUTHOR]", "[QUANTITY]", "[PRICE] (VND)");
                System.out.println( books.get(i) );
                check = 1;
                break;
            }
        }
        if(check == 0){
            System.out.println( "[NOTICE] *** CAN NOT FIND THE BOOK" );
            return null;
        }
        if( books.get( i ).getQuantity() < quantity ){
            System.out.println( "CAN NOT ADD THIS BOOK TO BUY, THERE'S ONLY " + books.get( i ).getQuantity() + " BOOK IN THE STORE" );
            return null;
        } else{
            books.get( i ).setQuantity( books.get( i ).getQuantity() - quantity );
            return books.get(i);
        }

    }

//    public int findBookByIdReturnIndex(int id){
//        int i = 0;
//        for(i = 0; i < books.size(); i++){
//            if(books.get(i).getId() == id){
//                System.out.println("HERE IS THE BOOK YOU WANT TO BUY" );
//                System.out.println( books.get(i) );
//                break;
//            }
//        }
//        return books.get(i);
//    }
//
//    public Book findBookByIndexReturnBook(int index){
//
//    }

    public void editBookBy(){
        System.out.println("[EDIT A BOOK SEARCH BY ID]" );
        System.out.print("ENTER THE BOOK ID: " );
        int id = inputMethod.getInt();
        for(int i = 0; i <= books.size() ; i++){
            if(books.get(i).getId() == id){
                System.out.println("HERE IS THE BOOK YOU WANT TO EDIT" );
                System.out.println( books.get(i) );
                System.out.print("HERE IS THE BOOK YOU WANT TO EDIT" );
            }
        }
    } // TRASH

    public void findBookByIdWithBinarySearch(){
        int left = 0;
        int right = books.size() - 1;
        int result = -1;

        System.out.print("ENTER THE BOOK ID: ");
        int Id = inputMethod.getInt();

        while(left <= right){
            int middle = (left + right) / 2;

            if(books.get(middle).getId() == Id){
                result = middle;
            }

            if(Id < books.get(middle).getId()){
                right = middle - 1;
            }
            else{
                left = middle + 1;
            }
        }
        if(result != -1){
            System.out.println(books.get(result));
        }else {
            System.out.println("COULD NOT FIND A BOOK WITH THE ID");
        }
        System.out.println("############################################################" );
    } // TRASH

    public void sortAndDisplayByTitle(){
        System.out.println("   [SORT AND DISPLAY BOOK BY TITLE]");
        for( int i = 0; i <= books.size(); i++ ){
            int indexAtMinValue = i;
            for( int j = i + 1; j <= books.size(); j++ ){
                if( compareString( books.get( j ).getTitle(), books.get( indexAtMinValue ).getTitle() ) == 1 ){
                    indexAtMinValue = j;
                }
            }
            Book temp = books.get( indexAtMinValue );
            books.replace( indexAtMinValue, books.get( i ) );
            books.replace( i, temp );
        }
        displayBooks();
    }

//    public void sortAndDisplayByTitle(){
//        int indexToGetValue = 0;
//        int i = 0;
//
//        while( i < books.size() ){
//            int j = i + 1;
//            while( j < books.size() ) {
//                if(compareString( books.get( i ).getTitle(), books.get( j ).getTitle() ) == 1){
//                    i = j;
//                    indexToGetValue = j;
//                    break;
//                } else{
//                    indexToGetValue = i;
//                }
//                j++;
//            }
//            i++;
//        }
//        System.out.println( books.get( indexToGetValue ) );
//
//        for( int k = 0; k < books.size() - 1; k++) {
//            i = 0;
//            while( i < books.size() ) {
//                int j = i + 1;
//                if ( compareString( books.get( i ).getTitle(), books.get( indexToGetValue ).getTitle() ) == 1 ) {
//                    while( j < books.size() ){
//                        if((compareString( books.get( i ).getTitle(), books.get( j ).getTitle() ) == 1 ) &&
//                            (compareString( books.get( j ).getTitle(), books.get( indexToGetValue ).getTitle() ) == 1 ) ){
//                            i = j;
//                            indexToGetValue = j;
//                            break;
//                        }else {
//                            indexToGetValue = i;
//                        }
//                        j++;
//                    }
//                }
//                i++;
//            }
//            System.out.println( books.get( indexToGetValue ) );
//        }
//    } // TRASH

    public void sortAndDisplayByAuthorAndPrice(){
        System.out.println("   [SORT AND DISPLAY BOOK BY AUTHOR AND PRICE]");
        for(int i = 0; i <= books.size(); i++){
            int indexAtMinValue = i;
            for(int j = i + 1; j <= books.size(); j++){
                if(compareString(books.get( j ).getAuthor(), books.get( indexAtMinValue ).getAuthor()) == 1){
                    indexAtMinValue = j;
                }
            }
            Book temp = books.get( indexAtMinValue );
            books.replace( indexAtMinValue, books.get( i ) );
            books.replace( i, temp );
        }
        for(int i = 0; i <= books.size(); i++){
            int indexAtMinValue = i;
            for(int j = i + 1; j <= books.size(); j++){
                if((compareString(books.get( j ).getAuthor(), books.get( indexAtMinValue ).getAuthor()) == 0) &&
                        (books.get(j).getPrice() < books.get( indexAtMinValue ).getPrice())){
                    indexAtMinValue = j;
                } else if (compareString(books.get( j ).getAuthor(), books.get( indexAtMinValue ).getAuthor()) != 0) {
                    break;
                }
            }
            Book temp = books.get( indexAtMinValue );
            books.replace( indexAtMinValue, books.get( i ) );
            books.replace( i, temp );
        }
        displayBooks();
    }

    public int compareString(String a, String b){
        int len1 = a.length(); // Length of current string
        int len2 = b.length(); // Length of the string to compare with
        int lim = Math.min(len1, len2); // Find the smaller length

        char[] v1 = a.toCharArray(); // Characters of the current string
        char[] v2 = b.toCharArray(); // Characters of the string to compare with

        int i = 0;
        int countEqualChar = 0;
        while (i < lim) {
            char ch1 = v1[i];
            char ch2 = v2[i];
            if (ch1 < ch2) {
                return 1; // Return the difference of the non-matching characters
            } else if (ch1 > ch2) {
                return -1;
            } else {
                countEqualChar++;
            }
            i++;
        }
        if( (countEqualChar == lim) && (len1 > len2) ){
            return -1;
        } else if ( (countEqualChar == lim) && (len1 < len2) ) {
            return 1;
        }
        return 0;
    }
}
