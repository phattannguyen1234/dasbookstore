import java.util.Scanner;

public class OrderMethod {

    private final ArrayList<BookOfOrder> booksOfOrder;
    private int orderId;
    InputMethod inputMethod = new InputMethod();
    private final Queue<Order> orders;
    private final Queue<Order> shippingOrders;
    private final Queue<Order> doneOrders;
    private final Queue<Order> cancelOrders;
    Scanner sc = new Scanner( System.in );

    public OrderMethod(){
        booksOfOrder = new ArrayList<>();
        orderId = 1;
        orders = new Queue<>();
        shippingOrders =  new Queue<>();
        doneOrders =  new Queue<>();
        cancelOrders = new Queue<>();
    }

    public void addBookToBuy( Book book, int quantity ){
        if ( book != null ){
            BookOfOrder bookOfOrder = new BookOfOrder(orderId, book.getTitle(), quantity, book.getPrice());
            booksOfOrder.add(bookOfOrder);
            System.out.println( "YOUR BOOK HAS BEEN ADDED SUCCESSFULLY" );
        } else {
            System.out.println( "FAIL TO ADD THIS BOOK" );
        }
    }

    public void createOrder(){
        int check = 0;
        int total = 0;
        for(int i = 0; i <= booksOfOrder.size(); i++){
            if( booksOfOrder.get( i ).getOrderId() == orderId ){
                check = 1;
                break;
            }
        }
        if( check == 1 ){
            System.out.print("ENTER YOUR NAME: ");
            String name = sc.nextLine();
            System.out.print("ENTER YOUR DELIVERY ADDRESS: ");
            String address = sc.nextLine();
            for(int i = 0; i <= booksOfOrder.size(); i++ ){
                if( booksOfOrder.get(i).getOrderId() == orderId ){
                    total += ( booksOfOrder.get(i).getPrice() * booksOfOrder.get(i).getQuantity() );
                }
            }
            Order order = new Order( orderId, name, address, total, "pending");
            orders.offer( order );
            System.out.println( "THE ORDER HAS BEEN CREATED SUCCESSFULLY" );
            orderId++;
        } else {
            System.out.println( "FAIL TO CREATE THE ORDER, THERE'S NO BOOK TO CREATE" );
        }
    }

    public void createAOrder(String name, String address){
        int total = 0;
        for(int i = 0; i < booksOfOrder.size(); i++ ){
            if( booksOfOrder.get(i).getOrderId() == orderId ){
                total += ( booksOfOrder.get(i).getPrice() * booksOfOrder.get(i).getQuantity() );
            }

        }
        Order order = new Order( orderId, name, address, total, "pending");
        orders.offer( order );
        orderId++;
    }

    public void displayOrders(){
        Order temp;
        System.out.println("   [DISPLAY ALL ORDERS]");
        for( int i = 0; i < orders.size(); i++ ){
            temp = orders.poll();
            System.out.println( temp );
            System.out.printf("%-25s%-18s%-16s%n", "[BOOK TITLE]", "[QUANTITY]", "[PRICE] (VND)");
            for( int j = 0; j <= booksOfOrder.size(); j++ ){
                if( booksOfOrder.get( j ).orderId == temp.getId() ){
                    System.out.println( booksOfOrder.get( j ) );
                }
            }
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" );
            orders.offer( temp );
        }
        for( int i = 0; i < shippingOrders.size(); i++ ){
            temp = shippingOrders.poll();
            System.out.println( temp );
            System.out.printf("%-25s%-18s%-16s%n", "[BOOK TITLE]", "[QUANTITY]", "[PRICE] (VND)");
            for( int j = 0; j <= booksOfOrder.size(); j++ ){
                if( booksOfOrder.get( j ).orderId == temp.getId() ){
                    System.out.println( booksOfOrder.get( j ) );
                }
            }
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" );
            shippingOrders.offer( temp );
        }
        for( int i = 0; i < doneOrders.size(); i++ ){
            temp = doneOrders.poll();
            System.out.println( temp );
            System.out.printf("%-25s%-18s%-16s%n", "[BOOK TITLE]", "[QUANTITY]", "[PRICE] (VND)");
            for( int j = 0; j <= booksOfOrder.size(); j++ ){
                if( booksOfOrder.get( j ).orderId == temp.getId() ){
                    System.out.println( booksOfOrder.get( j ) );
                }
            }
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" );
            doneOrders.offer( temp );
        }
        for( int i = 0; i < cancelOrders.size(); i++ ){
            temp = cancelOrders.poll();
            System.out.println( temp );
            System.out.printf("%-25s%-18s%-16s%n", "[BOOK TITLE]", "[QUANTITY]", "[PRICE] (VND)");
            for( int j = 0; j <= booksOfOrder.size(); j++ ){
                if( booksOfOrder.get( j ).orderId == temp.getId() ){
                    System.out.println( booksOfOrder.get( j ) );
                }
            }
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" );
            cancelOrders.offer( temp );
        }
    }

    public void findOrCancelOrderById(){
        Order temp;
        int checkStatus = 0;
        int check;
        int id;

        System.out.println( "   [FIND OR CANCEL ORDER BY ID]" );
        System.out.print( "ENTER THE ORDER ID: " );
        id = inputMethod.getInt();
        for( int i = 0; i < orders.size(); i++ ){
            temp = orders.poll();
            check = 0;
            if( temp.getId() == id ){
                System.out.println( "HERE IS THE ORDER WITH ID: " + id );
                System.out.println( temp );
                System.out.printf("%-25s%-18s%-16s%n", "[BOOK TITLE]", "[QUANTITY]", "[PRICE] (VND)");
                for( int j = 0; j <= booksOfOrder.size(); j++ ){
                    if( booksOfOrder.get( j ).orderId == temp.getId() ){
                        System.out.println( booksOfOrder.get( j ) );
                    }
                }
                check = 1;
                checkStatus = 1;
            }
            if( check == 1 ){
                System.out.print( "DO YOU WANT TO CANCEL THIS ORDER [1]YES/ [0]NO: " );
                int choice = inputMethod.getInt();
                if ( choice == 0 ){
                    orders.offer( temp );
                } else{
                    temp.setStatus( "canceled" );
                    cancelOrders.offer( temp );
                    System.out.println( "CANCELED SUCCESSFULLY" );
                }
            } else orders.offer( temp );
        }
        if( checkStatus == 0 ) {
            for (int i = 0; i < shippingOrders.size(); i++) {
                temp = shippingOrders.poll();
                check = 0;
                if (temp.getId() == id) {
                    System.out.println( "[HERE IS THE ORDER WITH ID ]" + id );
                    System.out.println(temp);
                    System.out.printf("%-25s%-18s%-16s%n", "[BOOK TITLE]", "[QUANTITY]", "[PRICE] (VND)");
                    for (int j = 0; j <= booksOfOrder.size(); j++) {
                        if (booksOfOrder.get(j).orderId == temp.getId()) {
                            System.out.println(booksOfOrder.get(j));
                        }
                    }
                    check = 1;
                    checkStatus = 1;
                }
                if (check == 1) {
                    System.out.println("THIS ORDER ID SHIPPING. CAN NOT CANCEL");
                    shippingOrders.offer(temp);
                } else shippingOrders.offer(temp);
            }
        }
        if( checkStatus == 0 ){
            for( int i = 0; i < doneOrders.size(); i++ ){
                temp = doneOrders.poll();
                check = 0;
                if( temp.getId() == id ){
                    System.out.println( "[HERE IS THE ORDER WITH ID ]" + id );
                    System.out.println( temp );
                    System.out.printf("%-25s%-18s%-16s%n", "[BOOK TITLE]", "[QUANTITY]", "[PRICE] (VND)");
                    for( int j = 0; j <= booksOfOrder.size(); j++ ){
                        if( booksOfOrder.get( j ).orderId == temp.getId() ){
                            System.out.println( booksOfOrder.get( j ) );
                        }
                    }
                    check = 1;
                    checkStatus = 1;
                }
                if( check == 1 ){
                    System.out.println( "THIS ORDER HAS BEEN SHIPPED. CAN NOT CANCEL" );
                    doneOrders.offer( temp );
                } else doneOrders.offer( temp );
            }
        }
        if ( checkStatus == 0 ){
            System.out.println( "COULD NOT FIND THE ORDER" );
        }
    }

    public void shipTheOrder(){
        boolean running = true;

        System.out.println( "   [SHIP THE ORDER]" );
        do{
            if( !orders.isEmpty() ){
                System.out.println( "HERE IS THE NEXT PENDING ORDER TO PROCESS" );
                System.out.println( orders.peek() );

                System.out.printf("%-25s%-18s%-16s%n", "[BOOK TITLE]", "[QUANTITY]", "[PRICE] (VND)");
                for( int j = 0; j <= booksOfOrder.size(); j++ ){
                    if( booksOfOrder.get( j ).orderId == orders.peek().getId() ){
                        System.out.println( booksOfOrder.get( j ) );
                    }
                }
                System.out.print( "DO YOU WANT TO SET THIS ORDER TO BE SHIPPED [1]YES/ [0]EXIT: " );
                int choice = inputMethod.getInt();
                if( choice == 1 ){
                    Order temp = orders.peek();
                    temp.setStatus( "shipping" );
                    shippingOrders.offer( temp );
                    orders.poll();
                    System.out.println( "THIS ORDER IS TURNED TO SHIPPING PROCESS SUCCESSFULLY" );
                }else {
                    System.out.println( "STOPPED PROCESS PENDING ORDERS, THEN EXITED" );
                    running = false;
                }
            } else {
                System.out.println( "[NOTICE] *** THERE'S NO PENDING ORDER TO PROCESS, THEN EXITED" );
                running = false;
            }
        }while( running );
    }

    public void doneTheOrder(){
        boolean running = true;

        System.out.println( "   [DONE THE ORDER]" );
        do{
            if( !shippingOrders.isEmpty() ){
                System.out.println( "HERE IS THE NEXT SHIPPING ORDER TO PROCESS" );
                System.out.println( shippingOrders.peek() );

                System.out.printf("%-25s%-18s%-16s%n", "[BOOK TITLE]", "[QUANTITY]", "[PRICE] (VND)");
                for( int j = 0; j <= booksOfOrder.size(); j++ ){
                    if( booksOfOrder.get( j ).orderId == shippingOrders.peek().getId() ){
                        System.out.println( booksOfOrder.get( j ) );
                    }
                }
                System.out.print( "DO YOU WANT TO SET THIS ORDER TO BE DONE [1]YES/ [0]EXIT: " );
                int choice = inputMethod.getInt();
                if( choice == 1 ){
                    Order temp = shippingOrders.peek();
                    temp.setStatus( "done" );
                    doneOrders.offer( temp );
                    shippingOrders.poll();
                    System.out.println( "THIS ORDER IS SET TO BE DONE SUCCESSFULLY" );
                }else {
                    System.out.println( "STOPPED PROCESS SHIPPING ORDERS, THEN EXITED" );
                    running = false;
                }
            } else {
                System.out.println( "[NOTICE] *** THERE'S NO SHIPPING ORDER TO PROCESS, THEN EXITED" );
                running = false;
            }
        }while( running );
    }
}
