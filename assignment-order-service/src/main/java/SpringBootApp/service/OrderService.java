package SpringBootApp.service;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import SpringBootApp.bean.InventoryItem;
import SpringBootApp.bean.Order;
import SpringBootApp.bean.OrderList;
import SpringBootApp.bean.Product;

public interface OrderService 
{
	public Order saveOrder(Order order);
	
	public Order getOrderByOrderId(long Oid) throws EntityNotFoundException; 
	
	public Product getProductByProductId(long productId);
	
	public InventoryItem getInventoryItemByProductCode(String productCode);
		
	public OrderList getAllOrders();
}
