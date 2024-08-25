package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enumeracao.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		System.out.print("Email:");
		String emailClient = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY):");
		LocalDate birthDate = LocalDate.parse(sc.next() , fmt);
		Client client = new Client(nameClient,emailClient,birthDate);
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		sc.nextLine();
		String status = sc.nextLine();
		LocalDateTime moment = LocalDateTime.now();
		Order order = new Order(moment,OrderStatus.valueOf(status), client);
		
		System.out.print("How many items to this order?");
		int n = sc.nextInt();
		sc.nextLine();
		for(int i=1; i<=n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name:");
			String nameProduct = sc.nextLine();
			System.out.print("Product price: ");
			double priceProduct = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			Product product = new Product(nameProduct, priceProduct);
			OrderItem orderItem = new OrderItem(quantity, product);
			order.addItem(orderItem);
		}
		System.out.println();
		System.out.println(order);
		
		sc.close();
	}}
		


