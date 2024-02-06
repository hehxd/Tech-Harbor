package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.DeliveryModel;

public interface DeliveryRepository extends JpaRepository<DeliveryModel, Integer> {
}
