package SpringBootApp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringBootApp.bean.OrderItem;

public interface OrderItemDao extends JpaRepository<OrderItem, Long>
{

}
