package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.ProductIsInCategoryModel;

public interface ProductIsInCategoryRepository extends JpaRepository<ProductIsInCategoryModel, Integer> {
}
