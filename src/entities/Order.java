package entities;

import entities.enums.OrderStatus;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private LocalDateTime moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> items = new ArrayList<OrderItem>();

    public Order() {
    }
    public Order(OrderStatus status, Client client) {
        this.moment = LocalDateTime.now();
        this.client = client;
        this.status = status;
    }



    public String getMoment() {
        return moment.format(dtf);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }
    public void removeItem(OrderItem item){
        items.remove(item);
    }
    public Double total(){
        double sum = 0;
        for(OrderItem item : items){
            sum += item.subTotal();
        }
        return sum;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY:\n");
        sb.append("Order moment: ").append(getMoment());
        sb.append("\nOrder status: ").append(getStatus());
        sb.append("\nClient: ").append(client);
        sb.append("\nOrder items:\n");
        for (OrderItem item : items) {
            sb.append(item).append("\n");
        }
        sb.append("Total: $").append(total());
        return sb.toString();
    }


}
