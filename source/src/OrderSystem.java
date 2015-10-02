class Order {
	Item[] allItemsInOrder;
	
	
	double getTotalPrice(){
		return 1;
		
	}
	
	void printItems(){
		
		
	}
}

class Item {
	String description;
	
	double getPrice(){return this.getPrice();} //TODO Korrekt so?
	
	void print(){
		System.out.println("\nDescription: " + description);
	}
	
}

class ProductItem extends Item {
	int amount;
	double pricePerUnit;
	
	public ProductItem(int amount, double pricePerUnit) {
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
		System.out.println("Price per unit: " + pricePerUnit);
	}
	
}

class ServiceItem extends Item {
	double price;
	
	@Override
	double getPrice(){
		return price;
	}
}





public class OrderSystem {
	public static void main(String[] args) {
		System.out.println("test");
		
		Item i = new ProductItem(2, 10.0);
		Item j = new ProductItem(3, 30.0);
		
		i.print();
		
	}
}