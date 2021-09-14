package SpringBootApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringBootApp.bean.InventoryItem;
import SpringBootApp.persistence.InventoryDao;

@Service
public class InventoryServiceImpl implements InventoryService
{

	@Autowired 
	private InventoryDao inventoryDao;
	@Override
	public InventoryItem getInventoryItemByProductCode(String productCode) {
		return inventoryDao.findByProductCode(productCode);
	}

	@Override
	public void updateInventoryItemQuantityByProductCode(String productCode, Integer availableQuantity) {
		inventoryDao.updateAvailableQuantity(productCode, availableQuantity);
	}

}
