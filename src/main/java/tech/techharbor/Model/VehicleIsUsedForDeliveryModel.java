package tech.techharbor.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "vehicle_is_used_for_delivery", schema = "project", catalog = "db_202324z_va_prj_techharbor")
public class VehicleIsUsedForDeliveryModel {
    @Basic
    @Id
    @Column(name = "vehicle_id", nullable = false)
    private Integer vehicleId;
    @Basic
    @Id
    @Column(name = "delivery_id", nullable = false)
    private Integer deliveryId;

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleIsUsedForDeliveryModel that = (VehicleIsUsedForDeliveryModel) o;
        return Objects.equals(vehicleId, that.vehicleId) && Objects.equals(deliveryId, that.deliveryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, deliveryId);
    }
}
