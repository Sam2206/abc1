package SpringBootApp.service;

import java.util.List;
import java.util.Optional;

import SpringBootApp.bean.Product;

public interface ProductService
{
	List<Product> getAllProducts();
	
	Optional<Product> getProductByCode(String productCode);
	
	Product getProductByProductId(long productId);
}
