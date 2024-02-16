package tech.techharbor.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Objects;

@Entity
@Data
@Table(name = "vehicle", schema = "project", catalog = "db_202324z_va_prj_techharbor")
public class VehicleModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "vehicle_id", nullable = false)
    private Integer vehicleId;
    @Basic
    @Column(name = "vehicle_model", length = 100)
    private String vehicleModel;
    @Basic
    @Column(name = "vehicle_service")
    private Date vehicleService;
    @Basic
    @Column(name = "delivery_man_id", nullable = false)
    private Integer deliveryManId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleModel that = (VehicleModel) o;
        return Objects.equals(vehicleId, that.vehicleId) && Objects.equals(vehicleModel, that.vehicleModel) && Objects.equals(vehicleService, that.vehicleService) && Objects.equals(deliveryManId, that.deliveryManId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, vehicleModel, vehicleService, deliveryManId);
    }
}
