package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.SubcategoryModel;

public interface SubcategoryRepository extends JpaRepository<SubcategoryModel, Integer> {

}
