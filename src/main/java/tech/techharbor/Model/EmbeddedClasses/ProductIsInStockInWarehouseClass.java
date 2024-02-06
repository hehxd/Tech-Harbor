package tech.techharbor.Model.EmbeddedClasses;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
@Data
@Embeddable
public class ProductIsInStockInWarehouseClass implements Serializable {

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "warehouse_id", nullable = false)
    private Integer warehouseId;

    public ProductIsInStockInWarehouseClass(Integer productId, Integer warehouseId) {
        this.productId = productId;
        this.warehouseId = warehouseId;
    }

    public ProductIsInStockInWarehouseClass() {
    }
}
