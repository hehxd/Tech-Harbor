package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.ServiceManModel;

public interface ServiceManRepository extends JpaRepository<ServiceManModel, Integer> {
}
