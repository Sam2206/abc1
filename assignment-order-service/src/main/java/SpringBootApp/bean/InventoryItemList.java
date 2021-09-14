package SpringBootApp.bean;

import java.util.List;

public class InventoryItemList 
{
	private List<InventoryItem> inventoryItem;
	
	public InventoryItemList() {}

	public InventoryItemList(List<InventoryItem> inventoryItem) {
		super();
		this.inventoryItem = inventoryItem;
	}

	public List<InventoryItem> getInventoryItem() {
		return inventoryItem;
	}

	public void setInventoryItem(List<InventoryItem> inventoryItem) {
		this.inventoryItem = inventoryItem;
	}
	
	
}
