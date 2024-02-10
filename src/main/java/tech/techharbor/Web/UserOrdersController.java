package tech.techharbor.Web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.techharbor.Model.OrderTableModel;
import tech.techharbor.Model.UserTableModel;
import tech.techharbor.Service.OrderTableService;
import java.util.List;

@Controller
public class UserOrdersController {

    private final OrderTableService orderTableService;

    public UserOrdersController(OrderTableService orderTableService) {
        this.orderTableService = orderTableService;
    }

    @GetMapping("/orders/{id}")
    public String showUserOrders(@PathVariable Integer id,
                              Model model,
                              HttpSession session) {

        UserTableModel user = (UserTableModel) session.getAttribute("user");
        model.addAttribute("user", user);
        List<OrderTableModel> orders = orderTableService.findByCustomerId(user.getUserId());


        model.addAttribute("orders",orders);

        return "myOrders";
    }
}
