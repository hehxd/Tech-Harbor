package tech.techharbor.Service.Impl;

import org.springframework.stereotype.Service;
import tech.techharbor.Model.ReviewModel;
import tech.techharbor.Repository.ReviewRepository;
import tech.techharbor.Service.ReviewService;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<ReviewModel> listReviews() {
        return this.reviewRepository.findAll();
    }

    @Override
    public Optional<ReviewModel> findById(Integer id) {
        return this.reviewRepository.findById(id);
    }

    @Override
    public ReviewModel create(Integer rating, String description, Integer customerId, Integer productId) {
        ReviewModel review = new ReviewModel(rating,description,customerId,productId);
        return this.reviewRepository.save(review);
    }

    @Override
    public ReviewModel update(Integer id, Integer rating, String description) {
        ReviewModel review = this.reviewRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid review ID: " + id));
        review.setReviewRating(rating);
        review.setReviewDescription(description);
        return this.reviewRepository.save(review);
    }

    @Override
    public void delete(Integer id) {
        this.reviewRepository.deleteById(id);
    }

    @Override
    public List<ReviewModel> getReviewsByProductId(Integer productId) {
        return this.reviewRepository.findByProductId(productId);
    }
}
