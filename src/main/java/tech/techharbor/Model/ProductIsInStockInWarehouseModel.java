package tech.techharbor.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product_is_in_stock_in_warehouse", schema = "project", catalog = "db_202324z_va_prj_techharbor")
public class ProductIsInStockInWarehouseModel {
    @Basic
    @Id
    @Column(name = "product_id", nullable = false)
    private Integer productId;
    @Basic
    @Id
    @Column(name = "warehouse_id", nullable = false)
    private Integer warehouseId;
    @Basic
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductIsInStockInWarehouseModel that = (ProductIsInStockInWarehouseModel) o;
        return Objects.equals(productId, that.productId) && Objects.equals(warehouseId, that.warehouseId) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, warehouseId, quantity);
    }
}
