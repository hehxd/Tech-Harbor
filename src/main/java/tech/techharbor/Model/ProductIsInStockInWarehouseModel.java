package tech.techharbor.Model;

import jakarta.persistence.*;
import lombok.Data;
import tech.techharbor.Model.EmbeddedClasses.ProductIsInStockInWarehouseClass;

import java.util.Objects;

@Entity
@Data
@Table(name = "product_is_in_stock_in_warehouse", schema = "project", catalog = "db_202324z_va_prj_techharbor")
public class ProductIsInStockInWarehouseModel {
    @EmbeddedId
    ProductIsInStockInWarehouseClass productIsInStockInWarehouseClass;
    @Basic
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Override
    public int hashCode() {
        return Objects.hash(productIsInStockInWarehouseClass, quantity);
    }
}
