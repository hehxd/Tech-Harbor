package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.OrderTableModel;

public interface OrderTableRepository extends JpaRepository<OrderTableModel, Integer> {
}

