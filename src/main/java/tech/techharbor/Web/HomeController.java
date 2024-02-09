package tech.techharbor.Web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.techharbor.Model.UserTableModel;
import tech.techharbor.Service.CategoryService;
import tech.techharbor.Service.ProductService;

@Controller
public class HomeController {

    private final CategoryService categoryService;
    private final ProductService productService;

    public HomeController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/")
    public String getHomePage(Model model, HttpSession session) {
        model.addAttribute("categories", categoryService.listCategories());
        model.addAttribute("products", productService.listProducts());
        UserTableModel user = (UserTableModel) session.getAttribute("user");
        model.addAttribute("user", user);

        return "index";
    }

}
