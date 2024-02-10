package tech.techharbor.Web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tech.techharbor.Model.CategoryModel;
import tech.techharbor.Model.ProductIsInCategoryModel;
import tech.techharbor.Model.ProductModel;
import tech.techharbor.Model.UserTableModel;
import tech.techharbor.Repository.ProductIsInCategoryRepository;
import tech.techharbor.Service.CategoryService;
import tech.techharbor.Service.ProductService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CategoryController {

    private final CategoryService categoryService;
    private final ProductService productService;

    private final ProductIsInCategoryRepository productIsInCategoryRepository;


    public CategoryController(CategoryService categoryService, ProductService productService, ProductIsInCategoryRepository productIsInCategoryRepository) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.productIsInCategoryRepository = productIsInCategoryRepository;
    }

    @GetMapping("/category/{name}")
    public String showProduct(@PathVariable String name,
                              Model model,
                              HttpSession session) {

        List<CategoryModel> allCategories = categoryService.listCategories();
        CategoryModel category = categoryService.categoryByName(name) != null ? categoryService.categoryByName(name) : null;

        List<ProductIsInCategoryModel> productIsInCategories = productIsInCategoryRepository.findAll();
        List<Integer> productIds = new ArrayList<>();

        for (ProductIsInCategoryModel productIsInCategory : productIsInCategories) {
            if (productIsInCategory.getProductIsInCategoryClass().getCategoryId().equals(category != null ? category.getCategoryId() : null)) {
                productIds.add(productIsInCategory.getProductIsInCategoryClass().getProductId());
            }
        }
        List<ProductModel> productsInCategory = productService.findAllProductsWithIds(productIds);
        model.addAttribute("selectedCategory", name);
        model.addAttribute("categories", allCategories);
        model.addAttribute("products", productsInCategory);
        UserTableModel user = (UserTableModel) session.getAttribute("user");
        model.addAttribute("user", user);
        return "categoryPage";
    }

}
