package tech.techharbor.Web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.techharbor.Model.UserTableModel;
import tech.techharbor.Service.CategoryService;
import tech.techharbor.Service.ProductService;
import tech.techharbor.Service.SubcategoryService;


@Controller
public class HomeController {

    private final CategoryService categoryService;
    private final SubcategoryService subcategoryService;
    private final ProductService productService;

    public HomeController(CategoryService categoryService, SubcategoryService subcategoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.subcategoryService = subcategoryService;
        this.productService = productService;
    }

    @GetMapping("/")
    public String getHomePage(Model model, HttpSession session) {
        model.addAttribute("categories", categoryService.listCategories());
        model.addAttribute("subcategories", subcategoryService.listSubcategories());
        model.addAttribute("products", productService.listProducts());
        UserTableModel user = (UserTableModel) session.getAttribute("user");
        model.addAttribute("user", user);
        Object deliveryManObject = session.getAttribute("deliveryMan");
        model.addAttribute("deliveryMan", deliveryManObject);
        return "index";
    }

    @GetMapping("/aboutUs")
    public String getAboutUsPage(Model model, HttpSession session) {
        UserTableModel user = (UserTableModel) session.getAttribute("user");
        model.addAttribute("user", user);
        Object deliveryManObject = session.getAttribute("deliveryMan");
        model.addAttribute("deliveryMan", deliveryManObject);
        return "aboutUs";
    }


}
