package tech.techharbor.Web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.techharbor.Model.ProductModel;
import tech.techharbor.Model.ReviewModel;
import tech.techharbor.Model.UserTableModel;
import tech.techharbor.Service.ProductService;
import tech.techharbor.Service.ReviewService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserReviewController {
    private final ReviewService reviewService;
    private final ProductService productService;

    public UserReviewController(ReviewService reviewService, ProductService productService) {
        this.reviewService = reviewService;
        this.productService = productService;
    }

    @GetMapping("/reviews/{id}")
    public String showUserReviews(@PathVariable Integer id, Model model, HttpSession session) {
        UserTableModel user = (UserTableModel) session.getAttribute("user");
        model.addAttribute("user", user);
        List<ReviewModel> allReviews = reviewService.listReviews();
        List<ReviewModel> reviews = new ArrayList<>();
        List<ProductModel> products = new ArrayList<>();
        for (ReviewModel review : allReviews) {

            if (review.getCustomerId().equals(user.getUserId())) {
                reviews.add(review);
                ProductModel product = productService.findById(review.getProductId());
                products.add(product);
            }
        }
        model.addAttribute("reviews", reviews);
        model.addAttribute("products", products);
        model.addAttribute("index", 0);
        return "myReviews";
    }


}
