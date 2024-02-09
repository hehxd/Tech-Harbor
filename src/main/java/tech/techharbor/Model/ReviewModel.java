package tech.techharbor.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "review", schema = "project", catalog = "db_202324z_va_prj_techharbor")
public class ReviewModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "review_id", nullable = false)
    private Integer reviewId;
    @Basic
    @Column(name = "review_rating", nullable = false)
    private Integer reviewRating;
    @Basic
    @Column(name = "review_description", nullable = false, length = 100)
    private String reviewDescription;
    @Basic
    @Column(name = "customer_id", nullable = false)
    private Integer customerId;
    @Basic
    @Column(name = "product_id", nullable = false)
    private Integer productId;

    public ReviewModel(Integer reviewRating, String reviewDescription, Integer customerId, Integer productId) {
        this.reviewRating = reviewRating;
        this.reviewDescription = reviewDescription;
        this.customerId = customerId;
        this.productId = productId;
    }

    public ReviewModel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewModel that = (ReviewModel) o;
        return Objects.equals(reviewId, that.reviewId) && Objects.equals(reviewRating, that.reviewRating) && Objects.equals(reviewDescription, that.reviewDescription) && Objects.equals(customerId, that.customerId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, reviewRating, reviewDescription, customerId, productId);
    }
}
