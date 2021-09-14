package SpringBootApp.service;

import SpringBootApp.bean.InventoryItem;

public interface InventoryService 
{
	public InventoryItem getInventoryItemByProductCode(String productCode);
	
	public void updateInventoryItemQuantityByProductCode(String productCode, Integer availableQuantity);
}
