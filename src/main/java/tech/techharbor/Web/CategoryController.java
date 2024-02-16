package tech.techharbor.Web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tech.techharbor.Model.*;
import tech.techharbor.Repository.ProductIsInCategoryRepository;
import tech.techharbor.Service.CategoryService;
import tech.techharbor.Service.ProductService;
import tech.techharbor.Service.SubcategoryService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CategoryController {

    private final CategoryService categoryService;
    private final ProductService productService;

    private final SubcategoryService subcategoryService;
    private final ProductIsInCategoryRepository productIsInCategoryRepository;


    public CategoryController(CategoryService categoryService, ProductService productService, SubcategoryService subcategoryService, ProductIsInCategoryRepository productIsInCategoryRepository) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.subcategoryService = subcategoryService;
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
        model.addAttribute("subcategories", subcategoryService.listSubcategories());
        model.addAttribute("products", productsInCategory);
        UserTableModel user = (UserTableModel) session.getAttribute("user");
        model.addAttribute("user", user);
        Object deliveryManObject = session.getAttribute("deliveryMan");
        model.addAttribute("deliveryMan", deliveryManObject);
        return "categoryPage";
    }

    @GetMapping("/category/subcategory/{name}")
    public String showSubcategoryProducts(@PathVariable String name,
                                          Model model,
                                          HttpSession session) {
        List<CategoryModel> allCategories = categoryService.listCategories();
        SubcategoryModel subCategory = subcategoryService.findBySubcategoryNameLike(name);

        List<ProductIsInCategoryModel> productIsInCategories = productIsInCategoryRepository.findAll();

        System.out.println(subCategory);
        List<ProductModel> productsInCategory = new ArrayList<>();
        for (ProductIsInCategoryModel productIsInCategory : productIsInCategories) {
            ProductModel product = productService.findById(productIsInCategory.getProductIsInCategoryClass().getProductId());
            if (product.getProductName().contains(name)) {
                productsInCategory.add(product);
            }
        }


        model.addAttribute("selectedCategory", name);
        model.addAttribute("categories", allCategories);
        model.addAttribute("subcategories", subcategoryService.listSubcategories());
        model.addAttribute("products", productsInCategory);
        UserTableModel user = (UserTableModel) session.getAttribute("user");
        model.addAttribute("user", user);
        Object deliveryManObject = session.getAttribute("deliveryMan");
        model.addAttribute("deliveryMan", deliveryManObject);
        return "categoryPage";
    }

}
