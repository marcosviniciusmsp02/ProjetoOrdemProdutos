package entities;

public class OrderItem {
	private Integer quantity;
	private Double price;
	private Product product;
	
	public OrderItem() {
	}
	public OrderItem(Integer quantity , Product product) {
		this.quantity = quantity;
		this.product = product;
		this.price = product.getPrice();
		
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
	public void setPrice(Double price) {
		this.price = price;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double subTotal(double price) {
		return this.quantity * this.price;
	}
	public String toString() {
		return product.getName() + ", $" + this.price + ", Quantity: " + this.quantity + 
				", Subtotal: $" + subTotal(price);
	}
}
