package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.WarehousemanModel;

public interface WarehousemanRepository extends JpaRepository<WarehousemanModel, Integer> {
}
