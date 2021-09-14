package SpringBootApp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringBootApp.bean.InventoryItem;
import SpringBootApp.bean.Order;
import SpringBootApp.bean.OrderItem;
import SpringBootApp.bean.OrderList;
import SpringBootApp.bean.Product;
import SpringBootApp.persistence.OrderDao;
import SpringBootApp.persistence.OrderItemDao;

@Service
public class OrderServiceImpl implements OrderService
{

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderItemDao orderItemDao;
	
	@Autowired
	private CatalogService catalogService;
	
	@Autowired
	private InventoryService inventoryService;
	
	public Product getProductByProductId(long productId)
	{
		return catalogService.getProduct(productId);
	}
	
	@Override
	public Order saveOrder(Order order) 
	{
		List<OrderItem> orderItemList=order.getItems();
		
		List<OrderItem> acceptedOrderList=new ArrayList<>();
		
		for(OrderItem item:orderItemList)
		{
			Product product=catalogService.getProduct(item.getProductId());
			InventoryItem inItem=inventoryService.getInventoryItemByProductCode(product.getCode());
			
			if(item.getQuantity()<=inItem.getAvailableQuantity())
			{
				item.setProductPrice(product.getPrice());
				acceptedOrderList.add(item);
				orderItemDao.save(item);
			}
				
		}
		
		Order acceptedOrder=new Order(order.getId(), order.getCustomerEmail(), order.getCustomerAddress(), acceptedOrderList);
		
		
		return orderDao.save(acceptedOrder);
		
		
		
	}



	@Override
	public InventoryItem getInventoryItemByProductCode(String productCode) {
		return inventoryService.getInventoryItemByProductCode(productCode);
	}

	@Override
	public Order getOrderByOrderId(long Oid) throws EntityNotFoundException {
		Order o = orderDao.getById(Oid);
		return o;
	}

	@Override
	public OrderList getAllOrders() {
		return new OrderList(orderDao.findAll());
	}





}
