package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Integer> {

    CategoryModel findByCategoryName(String name);

}
