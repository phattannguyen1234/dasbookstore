public class BookOfOrder {
    private String title;
    int quantity;
    int price;
    int orderId;

    public BookOfOrder(int orderId, String title, int quantity, int price) {
        this.orderId = orderId;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString(){
        return String.format("%-25s%-18s%-12s",
                title,
                quantity,
                price);
    }
}
