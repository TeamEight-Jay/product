package com.teamfive.product.Services;

import com.teamfive.product.DTO.ProductDTO;
import com.teamfive.product.Entity.ProductEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProductInterface {

    ProductEntity add(ProductDTO productDTO);
    ProductEntity get(String id);
    ProductEntity getMiniProduct(String id);

}
