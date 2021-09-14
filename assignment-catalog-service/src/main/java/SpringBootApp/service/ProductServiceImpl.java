package SpringBootApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringBootApp.bean.Product;
import SpringBootApp.persistence.ProductDao;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> getAllProducts() {
		
		List<Product> productList=new ArrayList<>();
		productDao.findAll().forEach(productList::add);
		return productList;
	}

	@Override
	public Optional<Product> getProductByCode(String productCode) {
		
		return productDao.findByCode(productCode);
	}

	@Override
	public Product getProductByProductId(long productId) {
		return productDao.getById(productId);
	}

}
