package tech.techharbor.Model;

import jakarta.persistence.*;
import lombok.Data;
import tech.techharbor.Model.EmbeddedClasses.ProductIsInCategoryClass;

import java.util.Objects;

@Entity
@Data
@Table(name = "product_is_in_category", schema = "project", catalog = "db_202324z_va_prj_techharbor")
public class ProductIsInCategoryModel {

    @EmbeddedId
    ProductIsInCategoryClass productIsInCategoryClass;

    @Override
    public int hashCode() {
        return Objects.hash(productIsInCategoryClass);
    }
}
