package aplication;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String temp = sc.nextLine();
        LocalDate nascimento = LocalDate.parse(temp, dtf);

        Client client = new Client(nome, email, nascimento);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String status = sc.nextLine();

        Order order = new Order(OrderStatus.valueOf(status), client);

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String itemNome = sc.nextLine();
            System.out.print("Product price: ");
            double itemPreco = sc.nextDouble();
            System.out.print("Quantity: ");
            int itemQuant = sc.nextInt();

            order.addItem(new OrderItem(itemQuant, new Product(itemNome, itemPreco)));
        }

        System.out.println();
        System.out.println(order);
        sc.close();
    }
}
