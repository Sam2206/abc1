package SpringBootApp.bean;

import java.util.Collection;

public class OrderList 
{
	private Collection<Order> orders;
	
	public OrderList() {}

	public OrderList(Collection<Order> orders) {
		super();
		this.orders = orders;
	}

	public Collection<Order> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Order> orders) {
		this.orders = orders;
	}
	
	

}
