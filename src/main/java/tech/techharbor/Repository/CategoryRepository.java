package tech.techharbor.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.CategoryModel;
import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryModel, Integer> {

    CategoryModel findByCategoryName(String name);

}
