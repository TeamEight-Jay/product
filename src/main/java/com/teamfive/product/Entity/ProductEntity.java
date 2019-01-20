package com.teamfive.product.Entity;

import org.springframework.data.annotation.Id;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= ProductEntity.TABLE_NAME)
public class ProductEntity {

    public final static String TABLE_NAME="EMPLOYEE";
    private static final String ID_COLUMN="ID";
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid",strategy = "uuid2")
    @Column(name= ProductEntity.ID_COLUMN)
    private String productId;
    private String productName;
    private String description;
    private String keyFeatures;

    public List<String> getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(List<String> imageSrc) {
        this.imageSrc = imageSrc;
    }

    private List<String> imageSrc;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeyFeatures() {
        return keyFeatures;
    }

    public void setKeyFeatures(String keyFeatures) {
        this.keyFeatures = keyFeatures;
    }

}
