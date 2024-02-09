package tech.techharbor.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "user_table", schema = "project", catalog = "db_202324z_va_prj_techharbor")
public class UserTableModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    @Basic
    @Column(name = "username", nullable = false, length = 100)
    private String username;
    @Basic
    @Column(name = "name_user", nullable = false, length = 100)
    private String nameUser;
    @Basic
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Basic
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Basic
    @Column(name = "phone_number", nullable = true, length = 100)
    private String phoneNumber;
    @Basic
    @Column(name = "administrator_id", nullable = true)
    private Integer administratorId;

    public UserTableModel(String username, String nameUser, String email, String password, String phoneNumber) {
        this.username = username;
        this.nameUser = nameUser;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public UserTableModel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTableModel that = (UserTableModel) o;
        return Objects.equals(userId, that.userId) && Objects.equals(username, that.username) && Objects.equals(nameUser, that.nameUser) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(administratorId, that.administratorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, nameUser, email, password, phoneNumber, administratorId);
    }
}
