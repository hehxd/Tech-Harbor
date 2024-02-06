package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
}
