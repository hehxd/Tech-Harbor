package tech.techharbor.Model.EmbeddedClasses;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class ProductIsInCategoryClass implements Serializable {

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    public ProductIsInCategoryClass() {
    }
}

