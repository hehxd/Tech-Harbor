package tech.techharbor.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.SubcategoryModel;

public interface SubcategoryRepository extends JpaRepository<SubcategoryModel, Integer> {
}
