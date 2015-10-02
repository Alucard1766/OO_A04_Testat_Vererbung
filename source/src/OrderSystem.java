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

class Item {
	String description;
	
	public Item(String description) {
		this.description = description;
	}
	
	double getPrice(){return this.getPrice();} //TODO Korrekt so?
	
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
		Item i = new ProductItem("Product i", 2, 10.0);
		Item j = new ProductItem("Product j", 3, 30.0);
		Item s = new ServiceItem("Service s", 50.0);
		
		Item[] items = new Item[3];
		items[0] = i;
		items[1] = j;
		items[2] = s;
		
		Order order1 = new Order(items);
		order1.printItems();
		System.out.println("Total Price: " + order1.getTotalPrice());
		
	}
}