package tech.techharbor.Web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.techharbor.Model.OrderTableModel;
import tech.techharbor.Model.ProductModel;
import tech.techharbor.Model.UserTableModel;
import tech.techharbor.Service.OrderTableContainsProductService;
import tech.techharbor.Service.OrderTableService;
import tech.techharbor.Service.ProductService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class ShoppingCartController {

    private final ProductService productService;
    private final OrderTableService orderTableService;
    private final OrderTableContainsProductService orderTableContainsProductService;

    public ShoppingCartController(ProductService productService, OrderTableService orderTableService, OrderTableContainsProductService orderTableContainsProductService) {
        this.productService = productService;
        this.orderTableService = orderTableService;
        this.orderTableContainsProductService = orderTableContainsProductService;
    }

    List<ProductModel> shoppingCartList = new ArrayList<>();
    @GetMapping("/shoppingCart")
    public String getShoppingCart(HttpSession session, Model model){
        UserTableModel user = (UserTableModel) session.getAttribute("user");
        Integer totalPrice = 0;

        for (ProductModel product : shoppingCartList) {
            totalPrice += product.getProductPrice();
        }


        model.addAttribute("user", user);
        model.addAttribute("grandTotal",totalPrice);
        model.addAttribute("cartItems",shoppingCartList);

        return "shoppingCart";
    }


    @GetMapping("/shoppingCart/{id}")
    public String getProduct(@PathVariable Integer id, HttpSession session){

        UserTableModel user = (UserTableModel) session.getAttribute("user");
        ProductModel product = productService.findById(id);
        shoppingCartList.add(product);

        java.util.Date utilDate = new Date();
        OrderTableModel order = orderTableService.create("Created",new java.sql.Date(utilDate.getTime()),user.getUserId());
        orderTableContainsProductService.create(order.getOrderId(),product.getProductId(),1);
        return "redirect:/";

    }

}
