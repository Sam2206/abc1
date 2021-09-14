package SpringBootApp.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringBootApp.bean.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long>
{
	public Optional<Product> findByCode(String code);
	
}
