package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.ReviewModel;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewModel, Integer> {

    List<ReviewModel> findByProductId(Integer productId);

}
