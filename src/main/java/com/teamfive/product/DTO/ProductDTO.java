package com.teamfive.product.DTO;

import java.util.List;

public class ProductDTO {
    private String productId;
    private String productName;
    private String description;
    private String keyFeatures;

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
