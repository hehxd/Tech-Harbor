package tech.techharbor.Web;

import jakarta.servlet.http.HttpSession;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.techharbor.Model.*;
import tech.techharbor.Repository.ProductIsInCategoryRepository;
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

    private final ProductIsInCategoryRepository productIsInCategoryRepository;

    public ProductController(ProductService productService, ReviewService reviewService, CategoryService categoryService, SubcategoryService subcategoryService, ProductIsInCategoryRepository productIsInCategoryRepository) {
        this.productService = productService;
        this.reviewService = reviewService;
        this.categoryService = categoryService;
        this.subcategoryService = subcategoryService;
        this.productIsInCategoryRepository = productIsInCategoryRepository;
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
        return "productPage";
    }

    @PostMapping("/add-review")
    public String addReview(@RequestParam Integer productId,
                            @RequestParam Integer reviewRating,
                            @RequestParam String reviewDescription,
                            HttpSession session) {

        UserTableModel user = (UserTableModel) session.getAttribute("user");

        reviewService.create(reviewRating, reviewDescription, user.getUserId(), productId);
        System.out.println("add-review called");
        System.out.println(user);

        return "redirect:/product/" + productId;
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String name,
                         Model model,
                         HttpSession session) {
        List<ProductModel> products = this.productService.findAll();
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

        return "filterPage";
    }

}
