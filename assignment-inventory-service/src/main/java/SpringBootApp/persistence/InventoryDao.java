package SpringBootApp.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import SpringBootApp.bean.InventoryItem;

@Repository
@Transactional
public interface InventoryDao extends JpaRepository<InventoryItem, Long>
{
	public InventoryItem findByProductCode(String productCode);
	
	
	@Modifying
	@Query("update InventoryItem i set i.availableQuantity =:availableQuantity where i.productCode=:productCode")
	void updateAvailableQuantity(@Param(value="productCode") String productCode, @Param(value="availableQuantity") Integer availableQuantity);
}
