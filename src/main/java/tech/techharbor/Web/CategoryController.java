package tech.techharbor.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tech.techharbor.Model.CategoryModel;
import tech.techharbor.Model.EmbeddedClasses.ProductIsInCategoryClass;
import tech.techharbor.Model.ProductIsInCategoryModel;
import tech.techharbor.Model.ProductModel;
import tech.techharbor.Repository.ProductIsInCategoryRepository;
import tech.techharbor.Service.CategoryService;
import tech.techharbor.Service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
                              Model model) {

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

        model.addAttribute("categories", allCategories);
        model.addAttribute("products", productsInCategory);

        return "categoryPage";
    }

}
