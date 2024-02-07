package tech.techharbor.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.techharbor.Model.ProductModel;
import tech.techharbor.Service.ProductService;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public String showProduct(@PathVariable Integer id,
                              Model model) {
        ProductModel product = productService.findById(id);
        model.addAttribute("product",product);
        return "productPage";
    }


}
