package tech.techharbor.Model.EmbeddedClasses;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
@Data
@Embeddable
public class OrderTableContainsProductClass implements Serializable {

    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    public OrderTableContainsProductClass(Integer orderId, Integer productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public OrderTableContainsProductClass() {
    }
}
