package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.WarehouseModel;

public interface WarehouseRepository extends JpaRepository<WarehouseModel, Integer> {
}
