package com.teamfive.product.Services;

import com.teamfive.product.DTO.ProductDTO;
import com.teamfive.product.Entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ProductInterface {

    ProductEntity add(ProductDTO productDTO);
    ProductEntity get(String id);
    ProductEntity getMiniProduct(String id);
    ArrayList<ProductEntity> getByCategory(String category);
    void update(ProductEntity productEntity);

}
