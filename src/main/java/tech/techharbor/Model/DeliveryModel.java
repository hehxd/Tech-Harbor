package tech.techharbor.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
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

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Integer getDeliveryManId() {
        return deliveryManId;
    }

    public void setDeliveryManId(Integer deliveryManId) {
        this.deliveryManId = deliveryManId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
