package tech.techharbor.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "subcategory", schema = "project", catalog = "db_202324z_va_prj_techharbor")
public class SubcategoryModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "subcategory_id", nullable = false)
    private Integer subcategoryId;
    @Basic
    @Column(name = "subcategory_name", nullable = false, length = 100)
    private String subcategoryName;
    @Basic
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    public SubcategoryModel(String subcategoryName, Integer categoryId) {
        this.subcategoryName = subcategoryName;
        this.categoryId = categoryId;
    }

    public SubcategoryModel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubcategoryModel that = (SubcategoryModel) o;
        return Objects.equals(subcategoryId, that.subcategoryId) && Objects.equals(subcategoryName, that.subcategoryName) && Objects.equals(categoryId, that.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subcategoryId, subcategoryName, categoryId);
    }
}
