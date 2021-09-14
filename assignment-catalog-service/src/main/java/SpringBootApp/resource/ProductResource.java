package SpringBootApp.resource;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import SpringBootApp.bean.Product;
import SpringBootApp.bean.ProductList;
import SpringBootApp.service.ProductService;

@RestController
public class ProductResource 
{
	@Autowired
	private ProductService productService;
	
	@GetMapping(value="/products", produces="application/json")
	public ProductList listAllProducts()
	{
		return new ProductList(productService.getAllProducts());
	}
	@GetMapping(value="/products/list", produces="application/json")
	public List<Product> allProducts()
	{
		return productService.getAllProducts();
	}
	@GetMapping(value="/products/code/{productCode}", produces="application/json")
	public Optional<Product> getProductByCode(@PathVariable("productCode") String productCode)
	{
		return productService.getProductByCode(productCode);
	}
	
	@GetMapping(value="products/{productId}", produces="application/json")
	public Product getProductByProductId(@PathVariable("productId") long productid)
	{
		return productService.getProductByProductId(productid);
	}
}
