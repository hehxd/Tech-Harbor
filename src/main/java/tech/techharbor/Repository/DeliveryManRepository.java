package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.DeliveryManModel;

public interface DeliveryManRepository extends JpaRepository<DeliveryManModel, Integer> {
}
