package com.teamfive.product.Services;


import com.teamfive.product.DTO.ProductDTO;
import com.teamfive.product.Entity.ProductEntity;
import com.teamfive.product.Repositories.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductServices implements ProductInterface {

    @Autowired
    ProductRepositories productRepositories;


    @Override
    public ProductEntity add(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductEntity get(String id) {
        return null;
    }

    @Override
    public ProductEntity getMiniProduct(String id) {
        return null;
    }
}
