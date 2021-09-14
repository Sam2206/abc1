package SpringBootApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import SpringBootApp.bean.InventoryItem;
import SpringBootApp.bean.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class InventoryServiceImpl implements InventoryService
{

	@Autowired
	private RestTemplate restTemplate;
	@Override
	
    @CircuitBreaker(name="inventoryItem",fallbackMethod = "inventoryItemFallBack")

	public InventoryItem getInventoryItemByProductCode(String productCode) {
		return restTemplate.getForObject("http://inventory-service/code/"+productCode, InventoryItem.class);
	}

	 public InventoryItem inventoryItemFallBack(Exception e){
		 
	        return new InventoryItem(0l, null, null);
	    }
}
