package com.teamfive.product.DTO;

public class ProductUpdateKafkaMessage {
    private String action;
    private ProductDTO product;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductUpdateKafkaMessage{" +
                "action='" + action + '\'' +
                ", product=" + product +
                '}';
    }
}
