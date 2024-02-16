package tech.techharbor.Web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.techharbor.Model.ProductModel;
import tech.techharbor.Model.ReviewModel;
import tech.techharbor.Model.UserTableModel;
import tech.techharbor.Service.CategoryService;
import tech.techharbor.Service.ProductService;
import tech.techharbor.Service.ReviewService;
import tech.techharbor.Service.SubcategoryService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;
    private final ReviewService reviewService;

    private final CategoryService categoryService;

    private final SubcategoryService subcategoryService;


    public ProductController(ProductService productService, ReviewService reviewService, CategoryService categoryService, SubcategoryService subcategoryService) {
        this.productService = productService;
        this.reviewService = reviewService;
        this.categoryService = categoryService;
        this.subcategoryService = subcategoryService;
    }

    @GetMapping("/product/{id}")
    public String showProduct(@PathVariable Integer id,
                              Model model,
                              HttpSession session) {
        ProductModel product = productService.findById(id);
        List<ReviewModel> reviews = this.reviewService.getReviewsByProductId(product.getProductId());
        model.addAttribute("product", product);
        model.addAttribute("reviews", reviews);
        UserTableModel user = (UserTableModel) session.getAttribute("user");
        model.addAttribute("user", user);
        Object deliveryManObject = session.getAttribute("deliveryMan");
        model.addAttribute("deliveryMan", deliveryManObject);
        return "productPage";
    }

    @PostMapping("/add-review")
    public String addReview(@RequestParam Integer productId,
                            @RequestParam Integer reviewRating,
                            @RequestParam String reviewDescription,
                            HttpSession session) {

        UserTableModel user = (UserTableModel) session.getAttribute("user");

        reviewService.create(reviewRating, reviewDescription, user.getUserId(), productId);

        return "redirect:/product/" + productId;
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String name,
                         Model model,
                         HttpSession session) {
        List<ProductModel> products = this.productService.listProducts();
        List<ProductModel> filteredProducts = new ArrayList<>();

        for (ProductModel productModel : products) {
            if (productModel.getProductName().toLowerCase().contains(name.toLowerCase())) {
                filteredProducts.add(productModel);
            }
        }
        model.addAttribute("filteredProducts", filteredProducts);
        model.addAttribute("categories", categoryService.listCategories());
        model.addAttribute("subcategories", subcategoryService.listSubcategories());
        model.addAttribute("products", productService.listProducts());
        UserTableModel user = (UserTableModel) session.getAttribute("user");
        model.addAttribute("user", user);
        Object deliveryManObject = session.getAttribute("deliveryMan");
        model.addAttribute("deliveryMan", deliveryManObject);

        return "filterPage";
    }

}
