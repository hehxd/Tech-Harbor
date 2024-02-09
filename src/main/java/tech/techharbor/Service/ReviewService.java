package tech.techharbor.Service;


import tech.techharbor.Model.ReviewModel;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<ReviewModel> listReviews();
    Optional<ReviewModel> findById(Integer id);

    ReviewModel create(Integer rating, String description, Integer customerId, Integer productId);

    ReviewModel update(Integer reviewId, Integer rating, String description);

    void delete(Integer id);

    List<ReviewModel> getReviewsByProductId(Integer productId);

}
