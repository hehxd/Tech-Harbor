package tech.techharbor.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Integer> {

}
