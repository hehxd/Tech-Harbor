package tech.techharbor.Model.EmbeddedClasses;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
@Data
@Embeddable
public class ProductIsInCategoryClass implements Serializable {

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    public ProductIsInCategoryClass(Integer productId, Integer categoryId) {
        this.productId = productId;
        this.categoryId = categoryId;
    }

    public ProductIsInCategoryClass() {
    }
}

