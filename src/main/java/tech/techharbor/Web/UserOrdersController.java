package tech.techharbor.Web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.techharbor.Model.OrderTableContainsProductModel;
import tech.techharbor.Model.OrderTableModel;
import tech.techharbor.Model.ProductModel;
import tech.techharbor.Model.UserTableModel;
import tech.techharbor.Service.OrderTableContainsProductService;
import tech.techharbor.Service.OrderTableService;
import tech.techharbor.Service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        List<OrderTableContainsProductModel> ordersWithProducts = orderTableContainsProductService.listAll();

        List<OrderTableContainsProductModel> finalOrderList = new ArrayList<>();
        List<OrderTableModel> allOrders = new ArrayList<>();
        List<ProductModel> products = new ArrayList<>();

        for (OrderTableModel order :orders) {
            for(OrderTableContainsProductModel orderProducts : ordersWithProducts){
                if(Objects.equals(order.getOrderId(), orderProducts.getOrderTableContainsProductClass().getOrderId())){
                    allOrders.add(order);
                    finalOrderList.add(orderProducts);
                    products.add(productService.findById(orderProducts.getOrderTableContainsProductClass().getProductId()));
                }
            }
        }


        if(!finalOrderList.isEmpty() || !products.isEmpty()) {
            model.addAttribute("orderList", finalOrderList);
            model.addAttribute("products", products);
            model.addAttribute("orders",allOrders);
        }


        return "myOrders";
    }
}
