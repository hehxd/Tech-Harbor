package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.CustomerModel;

public interface CustomerRepository extends JpaRepository<CustomerModel, Integer> {

}
