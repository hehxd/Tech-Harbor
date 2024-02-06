package tech.techharbor.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "warehouse", schema = "project", catalog = "db_202324z_va_prj_techharbor")
public class WarehouseModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "warehouse_id", nullable = false)
    private Integer warehouseId;
    @Basic
    @Column(name = "warehouse_location", nullable = false, length = 100)
    private String warehouseLocation;

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseLocation() {
        return warehouseLocation;
    }

    public void setWarehouseLocation(String warehouseLocation) {
        this.warehouseLocation = warehouseLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarehouseModel that = (WarehouseModel) o;
        return Objects.equals(warehouseId, that.warehouseId) && Objects.equals(warehouseLocation, that.warehouseLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(warehouseId, warehouseLocation);
    }
}
