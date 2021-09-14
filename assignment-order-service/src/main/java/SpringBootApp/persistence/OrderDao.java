package SpringBootApp.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

import SpringBootApp.bean.Order;

public interface OrderDao extends JpaRepository<Order, Long>
{

}
