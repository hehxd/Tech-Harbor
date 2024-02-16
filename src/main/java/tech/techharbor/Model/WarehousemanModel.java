package tech.techharbor.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "warehouseman", schema = "project", catalog = "db_202324z_va_prj_techharbor")
public class WarehousemanModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    @Basic
    @Column(name = "warehouse_id", nullable = false)
    private Integer warehouseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarehousemanModel that = (WarehousemanModel) o;
        return Objects.equals(userId, that.userId) && Objects.equals(warehouseId, that.warehouseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, warehouseId);
    }
}
