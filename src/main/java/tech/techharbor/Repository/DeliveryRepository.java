package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.DeliveryModel;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<DeliveryModel, Integer> {
    List<DeliveryModel> findByDeliveryManId (Integer deliveryManId);
}
