package com.teamfive.product.Entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= ProductEntity.TABLE_NAME)
public class ProductEntity {

    public final static String TABLE_NAME="PRODUCT";
    private static final String ID_COLUMN="ID";

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid",strategy = "uuid2")
    @Column(name= ProductEntity.ID_COLUMN)
    private String productId;
    private String productName;
    private String description;
    private String keyFeatures;
    private String category;
    private ArrayList<String> imageSrc;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<String> getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(ArrayList<String> imageSrc) {
        this.imageSrc = imageSrc;
    }
}
