package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.VehicleModel;

public interface VehicleRepository extends JpaRepository<VehicleModel, Integer> {
}
