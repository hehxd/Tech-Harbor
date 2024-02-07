package tech.techharbor.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "product", schema = "project", catalog = "db_202324z_va_prj_techharbor")
public class ProductModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id", nullable = false)
    private Integer productId;
    @Basic
    @Column(name = "product_name", nullable = false, length = 100)
    private String productName;
    @Basic
    @Column(name = "product_description", nullable = false, length = 100)
    private String productDescription;
    @Basic
    @Column(name = "product_price", nullable = false)
    private Integer productPrice;
    @Basic
    @Column(name = "product_warranty", nullable = false)
    private Integer productWarranty;
    @Basic
    @Column(name = "product_image", nullable = false, length = -1)
    private String productImage;
    @Basic
    @Column(name = "manufacturer_id", nullable = false)
    private Integer manufacturerId;
    @Basic
    @Column(name = "service_man_id", nullable = false)
    private Integer serviceManId;

    public ProductModel(String productName, String productDescription, Integer productPrice, Integer productWarranty) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productWarranty = productWarranty;
    }

    public ProductModel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductModel that = (ProductModel) o;
        return Objects.equals(productId, that.productId) && Objects.equals(productName, that.productName) && Objects.equals(productDescription, that.productDescription) && Objects.equals(productPrice, that.productPrice) && Objects.equals(productWarranty, that.productWarranty) && Objects.equals(productImage, that.productImage) && Objects.equals(manufacturerId, that.manufacturerId) && Objects.equals(serviceManId, that.serviceManId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productDescription, productPrice, productWarranty, productImage, manufacturerId, serviceManId);
    }
}
