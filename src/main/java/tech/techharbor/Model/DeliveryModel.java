package tech.techharbor.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "delivery", schema = "project", catalog = "db_202324z_va_prj_techharbor")
public class DeliveryModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "delivery_id", nullable = false)
    private Integer deliveryId;
    @Basic
    @Column(name = "delivery_status", nullable = false, length = 100)
    private String deliveryStatus;
    @Basic
    @Column(name = "delivery_address", nullable = false, length = 100)
    private String deliveryAddress;
    @Basic
    @Column(name = "delivery_man_id", nullable = false)
    private Integer deliveryManId;
    @Basic
    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    public DeliveryModel(String deliveryStatus, String deliveryAddress, Integer deliveryManId, Integer orderId) {
        this.deliveryStatus = deliveryStatus;
        this.deliveryAddress = deliveryAddress;
        this.deliveryManId = deliveryManId;
        this.orderId = orderId;
    }

    public DeliveryModel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryModel that = (DeliveryModel) o;
        return Objects.equals(deliveryId, that.deliveryId) && Objects.equals(deliveryStatus, that.deliveryStatus) && Objects.equals(deliveryAddress, that.deliveryAddress) && Objects.equals(deliveryManId, that.deliveryManId) && Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryId, deliveryStatus, deliveryAddress, deliveryManId, orderId);
    }
}
