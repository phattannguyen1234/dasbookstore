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
            System.out.println( book );
        }

    }

    public void createOrder(){
        System.out.print("ENTER YOUR NAME: ");
        String name = sc.nextLine();
        System.out.print("ENTER YOUR DELIVERY ADDRESS: ");
        String address = sc.nextLine();

        int total = 0;
        for(int i = 0; i < booksOfOrder.size(); i++ ){
            if( booksOfOrder.get(i).getOrderId() == orderId ){
                total += ( booksOfOrder.get(i).getPrice() * booksOfOrder.get(i).getQuantity() );
            }
        }

//        System.out.print("REVIEW YOUR ORDER");

        Order order = new Order( orderId, name, address, total, "pending");
        orders.offer( order );
        orderId++;
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

        System.out.println("[DISPLAY ALL ORDERS]");
        for( int i = 0; i < orders.size(); i++ ){
            temp = orders.poll();
            System.out.println( temp );
            for( int j = 0; j < booksOfOrder.size(); j++ ){
                if( booksOfOrder.get( j ).orderId == temp.getId() ){
                    System.out.println( booksOfOrder.get( j ) );
                }
            }
            orders.offer( temp );
        }

        for( int i = 0; i < shippingOrders.size(); i++ ){
            temp = shippingOrders.poll();
            System.out.println( temp );
            for( int j = 0; j < booksOfOrder.size(); j++ ){
                if( booksOfOrder.get( j ).orderId == temp.getId() ){
                    System.out.println( booksOfOrder.get( j ) );
                }
            }
            shippingOrders.offer( temp );
        }

        for( int i = 0; i < doneOrders.size(); i++ ){
            temp = doneOrders.poll();
            System.out.println( temp );
            for( int j = 0; j < booksOfOrder.size(); j++ ){
                if( booksOfOrder.get( j ).orderId == temp.getId() ){
                    System.out.println( booksOfOrder.get( j ) );
                }
            }
            doneOrders.offer( temp );
        }

        for( int i = 0; i < cancelOrders.size(); i++ ){
            temp = cancelOrders.poll();
            System.out.println( temp );
            for( int j = 0; j < booksOfOrder.size(); j++ ){
                if( booksOfOrder.get( j ).orderId == temp.getId() ){
                    System.out.println( booksOfOrder.get( j ) );
                }
            }
            cancelOrders.offer( temp );
        }
    }

    public void findOrCancelOrderById( int id ){
        Order temp;
        int checkStatus = 0;
        int check;

        System.out.println( "[HERE IS THE ORDER WITH ID ]" + id );
        for( int i = 0; i < orders.size(); i++ ){
            temp = orders.poll();
            check = 0;

            if( temp.getId() == id ){
                System.out.println( temp );

                for( int j = 0; j < booksOfOrder.size(); j++ ){
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
                }
            } else orders.offer( temp );

        }
        if( checkStatus == 0 ) {
            for (int i = 0; i < shippingOrders.size(); i++) {
                temp = shippingOrders.poll();
                check = 0;

                if (temp.getId() == id) {
                    System.out.println(temp);

                    for (int j = 0; j < booksOfOrder.size(); j++) {
                        if (booksOfOrder.get(j).orderId == temp.getId()) {
                            System.out.println(booksOfOrder.get(j));
                        }
                    }

                    check = 1;
                    checkStatus = 1;
                }

                if (check == 1) {
                    System.out.print("THIS ORDER HAS BEEN SHIPPED. CAN NOT CANCEL");
                    shippingOrders.offer(temp);
                } else shippingOrders.offer(temp);

            }
        }

        if( checkStatus == 0 ){
            for( int i = 0; i < doneOrders.size(); i++ ){
                temp = doneOrders.poll();
                check = 0;

                if( temp.getId() == id ){
                    System.out.println( temp );

                    for( int j = 0; j < booksOfOrder.size(); j++ ){
                        if( booksOfOrder.get( j ).orderId == temp.getId() ){
                            System.out.println( booksOfOrder.get( j ) );
                        }
                    }

                    check = 1;
                    checkStatus = 1;
                }

                if( check == 1 ){
                    System.out.print( "THIS ORDER HAS BEEN SHIPPED. CAN NOT CANCEL" );
                    doneOrders.offer( temp );
                } else doneOrders.offer( temp );
            }
        }

        if ( checkStatus == 0 ){
            System.out.println( "COULD NOT FIND THE ORDER" );
        }
    }

    public void shipTheOrder(){
        System.out.println( orders.peek() );
        Order temp = orders.peek();
        temp.setStatus( "shipping" );
        shippingOrders.offer( temp );
        orders.poll();
        System.out.print( "THIS ORDER IS SHIPPING" );
    }

    public void doneTheOrder(){
        System.out.println( shippingOrders.peek() );
        Order temp = shippingOrders.peek();
        temp.setStatus( "done" );
        doneOrders.offer( temp );
        shippingOrders.poll();
        System.out.print( "THIS ORDER HAS BEEN SHIPPED" );
    }
}
