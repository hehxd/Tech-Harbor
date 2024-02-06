package tech.techharbor.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "order_table_contains_product", schema = "project", catalog = "db_202324z_va_prj_techharbor")
public class OrderTableContainsProductModel {
    @Basic
    @Id
    @Column(name = "order_id", nullable = false)
    private Integer orderId;
    @Basic
    @Id
    @Column(name = "product_id", nullable = false)
    private Integer productId;
    @Basic
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
        OrderTableContainsProductModel that = (OrderTableContainsProductModel) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(productId, that.productId) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId, quantity);
    }
}
