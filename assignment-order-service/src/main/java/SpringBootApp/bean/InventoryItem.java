package SpringBootApp.bean;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="inventory_item")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class InventoryItem 
{
	@Id
	@Column(name="id")
	private Long id;
	@Column(name="product_code")
	private String productCode;
	@Column(name="available_quantity")
	private Integer availableQuantity;
	
	public InventoryItem() {}

	public InventoryItem(Long id, String productCode, Integer availableQuantity) {
		super();
		this.id = id;
		this.productCode = productCode;
		this.availableQuantity = availableQuantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	
	
	
}
