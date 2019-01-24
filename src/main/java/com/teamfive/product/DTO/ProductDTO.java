package com.teamfive.product.DTO;


import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
    private String productId;
    private String productName;
    private String description;
    private String keyFeatures;
    private ArrayList<String> imageSrc;
    private String category;

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

    public ArrayList<String> getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(ArrayList<String> imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", keyFeatures='" + keyFeatures + '\'' +
                ", imageSrc=" + imageSrc +
                ", category='" + category + '\'' +
                '}';
    }
}
