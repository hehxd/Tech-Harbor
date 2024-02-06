package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.EmbeddedClasses.VehicleIsUsedForDeliverClass;
import tech.techharbor.Model.VehicleIsUsedForDeliveryModel;

public interface VehicleIsUsedForDeliveryRepository extends JpaRepository<VehicleIsUsedForDeliveryModel, VehicleIsUsedForDeliverClass> {
}
