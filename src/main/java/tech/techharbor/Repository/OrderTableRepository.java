package tech.techharbor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.techharbor.Model.OrderTableModel;

import java.util.List;

public interface OrderTableRepository extends JpaRepository<OrderTableModel, Integer> {
    List<OrderTableModel> findByCustomerId(Integer customerId);
}

