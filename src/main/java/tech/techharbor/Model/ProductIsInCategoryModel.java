package tech.techharbor.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product_is_in_category", schema = "project", catalog = "db_202324z_va_prj_techharbor")
public class ProductIsInCategoryModel {
    @Basic
    @Id
    @Column(name = "product_id", nullable = false)
    private Integer productId;
    @Basic
    @Id
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductIsInCategoryModel that = (ProductIsInCategoryModel) o;
        return Objects.equals(productId, that.productId) && Objects.equals(categoryId, that.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, categoryId);
    }
}
