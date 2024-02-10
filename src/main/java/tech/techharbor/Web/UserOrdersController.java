package tech.techharbor.Web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.techharbor.Model.OrderTableModel;
import tech.techharbor.Model.UserTableModel;
import tech.techharbor.Service.OrderTableContainsProductService;
import tech.techharbor.Service.OrderTableService;
import tech.techharbor.Service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserOrdersController {

    private final OrderTableService orderTableService;
    private final ProductService productService;
    private final OrderTableContainsProductService orderTableContainsProductService;

    public UserOrdersController(OrderTableService orderTableService, ProductService productService, OrderTableContainsProductService orderTableContainsProductService) {
        this.orderTableService = orderTableService;
        this.productService = productService;
        this.orderTableContainsProductService = orderTableContainsProductService;
    }

    @GetMapping("/orders/{id}")
    public String showUserOrders(@PathVariable Integer id,Model model,HttpSession session) {

        UserTableModel user = (UserTableModel) session.getAttribute("user");
        model.addAttribute("user", user);
        List<OrderTableModel> orders = orderTableService.findByCustomerId(user.getUserId());
        List<Integer> quantities = new ArrayList<>();
        for(OrderTableModel orderTableModel:orders){
            quantities.add(this.orderTableContainsProductService.findByEmbeddedClass())
        }

        model.addAttribute("orders",orders);

        return "myOrders";
    }
}
