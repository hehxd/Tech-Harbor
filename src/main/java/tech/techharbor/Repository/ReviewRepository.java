package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.ReviewModel;

public interface ReviewRepository extends JpaRepository<ReviewModel, Integer> {
}
