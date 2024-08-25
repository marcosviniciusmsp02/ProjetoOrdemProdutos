package entities;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enumeracao.OrderStatus;

public class Order {
	private LocalDateTime moment;
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList();
	private Client client;
	
	public Order() {
	}
	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	public LocalDateTime getMoment() {
		return moment;
	}
	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void addItem(OrderItem item) {
		items.add(item);
	}
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	public double total() {
		double sum = 0;
		for(OrderItem i : items) {
			sum += i.getPrice() * i.getQuantity();
				}
		return sum;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment:" + fmt.format(this.moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client:");
		sb.append(client + "\n");
		sb.append("\nOrder items:\n");
		for(OrderItem o : items) {
			sb.append(o + "\n");
		}
		sb.append("Total price: $" + total());
		return sb.toString();
	}
	
}
