class Order {
	Item[] allItemsInOrder;
	
	public Order(Item[] orderedItems) {
		allItemsInOrder = orderedItems;
	}
	
	double getTotalPrice(){
		double totalPrice = 0.0;
		for (Item item : allItemsInOrder) {
			totalPrice += item.getPrice();
		}
		return totalPrice;
	}
	
	void printItems(){
		for (Item item : allItemsInOrder) {
			item.print();
		}
	}
}

abstract class Item {
	String description;
	
	public Item(String description) {
		this.description = description;
	}
	
	abstract double getPrice();
	
	void print(){
		System.out.println("Description: " + description);
	}
	
}

class ProductItem extends Item {
	int amount;
	double pricePerUnit;
	
	public ProductItem(String description, int amount, double pricePerUnit) {
		super(description);
		this.amount = amount;
		this.pricePerUnit = pricePerUnit;
	}
	
	@Override
	double getPrice(){
		return amount * pricePerUnit;
	}
	
	@Override
	void print(){
		super.print();
		System.out.println("Amount: " + amount);
		System.out.println("Price per unit: " + pricePerUnit + "\n");
	}
	
}

class ServiceItem extends Item {
	double price;
	
	public ServiceItem(String description, double price) {
		super(description);
		this.price = price;
	}
	
	@Override
	double getPrice(){
		return price;
	}
	
	@Override
	void print(){
		super.print();
		System.out.println("Price: " + price + "\n");
	}
}





public class OrderSystem {
	public static void main(String[] args) {
		Item i1 = new ProductItem("Product i1", 2, 10.0);
		Item i2 = new ProductItem("Product i2", 3, 30.0);
		Item s1 = new ServiceItem("Service s", 50.0);
		
		Item[] items1 = new Item[3];
		items1[0] = i1;
		items1[1] = i2;
		items1[2] = s1;
		
		Item[] items2 = new Item[1];
		items2[0] = s1;
		
		
		Order order1 = new Order(items1);
		order1.printItems();
		System.out.println("Total Price: " + order1.getTotalPrice() + "\n\n");
		
		Order order2 = new Order(items2);
		order2.printItems();
		System.out.println("Total Price: " + order2.getTotalPrice());
		
	}
}