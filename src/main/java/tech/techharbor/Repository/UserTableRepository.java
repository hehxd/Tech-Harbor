package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.UserTableModel;

public interface UserTableRepository extends JpaRepository<UserTableModel, Integer> {

    UserTableModel findByUsername(String username);

}
