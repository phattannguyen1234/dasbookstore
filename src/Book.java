public class Book {
    private int id;
    private String title;
    private String category;
    private String author;
    int quantity;
    int price;

    public Book( int id, String title, String category, String author, int quantity, int price){
        this.id = id;
        this.title = title;
        this.category = category;
        this.author = author;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    @Override
    public String toString(){
        return "ID: " + id + "\tTitle: " + title + "\t\tCategory: " + category + "\t\tAuthor: " + author + "\t\tQuantity: " + quantity + "\t\tPrice: " + price;
    }
}
