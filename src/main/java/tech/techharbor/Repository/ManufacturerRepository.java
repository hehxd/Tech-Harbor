package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.ManufacturerModel;

public interface ManufacturerRepository extends JpaRepository<ManufacturerModel, Integer> {
}
