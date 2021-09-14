package SpringBootApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import SpringBootApp.bean.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@Service
public class CatalogServiceImpl implements CatalogService
{

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	
    @CircuitBreaker(name="product",fallbackMethod = "productDetailsFallBack")

	public Product getProduct(Long productId) {
		return restTemplate.getForObject("http://catalog-service/products/"+productId, Product.class);
	}
	
	 public Product productDetailsFallBack(Exception e){
	      
	        return new Product(0l,null,null,null,0.0);
	    }

}
