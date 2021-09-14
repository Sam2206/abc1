package SpringBootApp.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringBootApp.bean.InventoryItem;
import SpringBootApp.service.InventoryService;

@RestController
public class InventoryResource
{
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping(value="/code/{productCode}",produces="application/json")
	public InventoryItem getInventoryItemByProductCode(@PathVariable("productCode")String productCode)
	{
		return inventoryService.getInventoryItemByProductCode(productCode);
	}
	
	@PutMapping(value="/code/{productCode}/{availableQuantity}",produces="application/json")
	public void updateInventoryItemQuantityByProductCode(@PathVariable("productCode") String productCode, @PathVariable("availableQuantity") int availableQuantity)
	{
		inventoryService.updateInventoryItemQuantityByProductCode(productCode, availableQuantity);
	}
}
