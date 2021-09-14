package SpringBootApp.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Order 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	private String customerEmail;
	private String customerAddress;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	private List<OrderItem> items;
	
	public Order() {}

	public Order(Long id, String customerEmail, String customerAddress, List<OrderItem> items) {
		super();
		this.id = id;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	
}
