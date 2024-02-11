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
import tech.techharbor.Service.ProductService;
import tech.techharbor.Service.ReviewService;


import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;
    private final ReviewService reviewService;

    public ProductController(ProductService productService, ReviewService reviewService) {
        this.productService = productService;
        this.reviewService = reviewService;
    }

    @GetMapping("/product/{id}")
    public String showProduct(@PathVariable Integer id,
                              Model model,
                              HttpSession session) {
        ProductModel product = productService.findById(id);
        List<ReviewModel> reviews = this.reviewService.getReviewsByProductId(product.getProductId());
        model.addAttribute("product",product);
        model.addAttribute("reviews",reviews);
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

        reviewService.create(reviewRating, reviewDescription,user.getUserId(),productId);
        System.out.println("add-review called");
        System.out.println(user);

        return "redirect:/product/" + productId;
    }

}
