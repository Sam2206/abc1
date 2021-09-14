package SpringBootApp.resource;

import java.util.Collection;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import SpringBootApp.bean.InventoryItem;
import SpringBootApp.bean.Order;
import SpringBootApp.bean.OrderList;
import SpringBootApp.bean.Product;
import SpringBootApp.service.OrderService;

@RestController
public class OrderResource
{
	@Autowired
	private OrderService orderService;
	
	@GetMapping(value="/orders/products/{productId}", produces="application/json")
	public Product getProductByProductid(@PathVariable("productId") long productId)
	{
		return orderService.getProductByProductId(productId);
	}
	
	@GetMapping(value="/orders/inventory/{productCode}", produces="application/json")
	public InventoryItem getInventoryItemProductCode(@PathVariable("productCode") String productCode)
	{
		return orderService.getInventoryItemByProductCode(productCode);
	}
	
	@GetMapping(value="/orders", produces="application/json")
	public OrderList getAllOrders()
	{
		return orderService.getAllOrders();
	}
	
	@GetMapping(path="/orders/{id}", produces = "Application/json")
	ResponseEntity<Object> getOrderByOrderId(@PathVariable("id") long Oid) {
		Order order;
		try {
			order = orderService.getOrderByOrderId(Oid);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(new Order()); 
		}
		return ResponseEntity.status(HttpStatus.SC_OK).body(order);
	}
	
	@PostMapping(value="/orders", produces="application/json", consumes="application/json")
	public Order saveOrder(@RequestBody Order order)
	{
		return orderService.saveOrder(order);
	}
}
