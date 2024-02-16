package tech.techharbor.Model.EmbeddedClasses;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
@Data
@Embeddable
public class ProductIsInStockInWarehouseClass implements Serializable {

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "warehouse_id", nullable = false)
    private Integer warehouseId;

    public ProductIsInStockInWarehouseClass() {
    }
}
