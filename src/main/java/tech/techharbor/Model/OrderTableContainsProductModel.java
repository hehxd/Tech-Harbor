package tech.techharbor.Model;

import jakarta.persistence.*;
import lombok.Data;
import tech.techharbor.Model.EmbeddedClasses.OrderTableContainsProductClass;

import java.util.Objects;

@Entity
@Data
@Table(name = "order_table_contains_product", schema = "project", catalog = "db_202324z_va_prj_techharbor")
public class OrderTableContainsProductModel {

    @EmbeddedId
    private OrderTableContainsProductClass orderTableContainsProductClass;

    @Basic
    @Column(name = "quantity", nullable = false)
    private Integer quantity;


    @Override
    public int hashCode() {
        return Objects.hash(orderTableContainsProductClass, quantity);
    }
}
