package entities;

public class OrderItem {

    private Integer quantity;
    private Double price;

    private Product product;
    public OrderItem() {
    }

    public OrderItem(Integer quantity, Product product) {
        this.quantity = quantity;
        price = product.getPrice();
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public Double subTotal(){
        return price * quantity;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(product.getName());
        sb.append( ", $");
        sb.append(String.format("%.2f", getPrice()));
        sb.append( ", Quantity: ");
        sb.append(getQuantity());
        sb.append( ", Subtotal: $");
        sb.append(String.format("%.2f", subTotal()));
        return sb.toString();
    }
}
