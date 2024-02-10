package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.EmbeddedClasses.OrderTableContainsProductClass;

public interface OrderTableContainsProductClassRepository extends JpaRepository<OrderTableContainsProductClass,Integer> {
public OrderTableContainsProductClass findById(Integer orderId,Integer productId);
}
