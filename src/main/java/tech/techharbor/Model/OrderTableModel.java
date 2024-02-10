package tech.techharbor.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Objects;

@Entity
@Data
@Table(name = "order_table", schema = "project", catalog = "db_202324z_va_prj_techharbor")
public class OrderTableModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id", nullable = false)
    private Integer orderId;
    @Basic
    @Column(name = "order_status", nullable = false, length = 100)
    private String orderStatus;
    @Basic
    @Column(name = "order_date", nullable = false)
    private Date orderDate;
    @Basic
    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

    public OrderTableModel(String orderStatus, Date orderDate, Integer customerId) {
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.customerId = customerId;
    }

    public OrderTableModel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderTableModel that = (OrderTableModel) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(orderStatus, that.orderStatus) && Objects.equals(orderDate, that.orderDate) && Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderStatus, orderDate, customerId);
    }
}
