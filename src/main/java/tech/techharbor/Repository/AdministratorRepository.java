package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.AdministratorModel;

public interface AdministratorRepository extends JpaRepository<AdministratorModel, Integer> {

}
