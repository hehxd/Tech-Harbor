package tech.techharbor.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "delivery_man", schema = "project", catalog = "db_202324z_va_prj_techharbor")
public class DeliveryManModel {
    @Id
    @Column(name = "user_id", nullable = false)
    private Integer userId;


    public DeliveryManModel(Integer userId) {
        this.userId = userId;
    }

    public DeliveryManModel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryManModel that = (DeliveryManModel) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
