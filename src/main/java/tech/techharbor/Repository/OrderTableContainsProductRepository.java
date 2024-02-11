package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.EmbeddedClasses.OrderTableContainsProductClass;
import tech.techharbor.Model.OrderTableContainsProductModel;

public interface OrderTableContainsProductRepository extends JpaRepository<OrderTableContainsProductModel,Integer> {
}
