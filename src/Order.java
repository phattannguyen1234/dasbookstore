public class Order {
    int id;
    String buyer;
    String address;
    int total;
    String status;

    public Order(int id, String buyer, String address, int total, String status) {
        this.id = id;
        this.buyer = buyer;
        this.address = address;
        this.total = total;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return String.format("%-20s%-20s%-20s%-20s%-20s",
                "ID: " + id,
                "Buyer: " + buyer,
                "Address: " + address,
                "Total: " + total,
                "Status: " + status);
    }
}
