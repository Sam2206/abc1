package SpringBootApp.service;

import SpringBootApp.bean.Product;

public interface CatalogService
{
	Product getProduct(Long productId);
}
