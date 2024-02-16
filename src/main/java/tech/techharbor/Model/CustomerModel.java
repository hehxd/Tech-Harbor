package tech.techharbor.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "customer", schema = "project", catalog = "db_202324z_va_prj_techharbor")
public class CustomerModel {

    @Id
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    public CustomerModel(Integer userId) {
        this.userId = userId;
    }

    public CustomerModel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerModel that = (CustomerModel) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
