package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdfBirth = new SimpleDateFormat("dd/MM/yyyy");
		
		// client data
		String name;
		String email;
		String birthDate;
		// order data
		String status;
		int itensInOrder;
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		name = sc.nextLine();
		System.out.print("Email: ");
		email = sc.next();
		System.out.print("Birth Date: ");
		birthDate = sc.next();
		
		Date birth = sdfBirth.parse(birthDate);
		Client client = new Client(name, email, birth);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		status = sc.next();
		
		// create a Order and Order List
		Order order = new Order();
		System.out.printf("How many items to this order?");
		itensInOrder = sc.nextInt();
		for(int i = 1; i <= itensInOrder; i++) {
			//Product data
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String nameProduct = sc.nextLine();
			System.out.println("Product price: ");
			Double price = sc.nextDouble();
			// Order Item data
			System.out.printf("Quantity: ");
			int qntd = sc.nextInt();
			OrderItem ordItem = new OrderItem(qntd,price);
			ordItem.getProduct().setName(nameProduct);	
			ordItem.getProduct().setPrice(price);
		}
	
		System.out.println("ORDER SUMMARY: ");
		System.out.printf("Order moment: "); 
		System.out.println(sdf.format(order.geMoment()));
		System.out.printf("Order status: "); 
		System.out.println(order.getOrderStatus());
		System.out.printf("Client: ");
		System.out.println(client.getName() + " (" + sdfBirth.format(client.getBirthDate()) + ") " + client.getEmail());
		System.out.println("Order items: ");

		double total = 0.0;
		for(OrderItem ordIte : order.getItem()) {
			System.out.println(ordIte.getProduct().getName() + ", $" + ordIte.getPrice() + ", Quantity: "
			 + ordIte.getQuantity() + ", Subtotal: $" + ordIte.subTotal());
			total += ordIte.subTotal();
		}
		
		System.out.println("Total price: " + total);
		sc.close();
	}

}
