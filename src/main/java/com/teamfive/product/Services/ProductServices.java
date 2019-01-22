package com.teamfive.product.Services;


import com.teamfive.product.DTO.ProductDTO;
import com.teamfive.product.Entity.ProductEntity;
import com.teamfive.product.Repositories.ProductRepositories;
import org.springframework.beans.BeanUtils;
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
        ProductEntity productEntity=new ProductEntity();
        BeanUtils.copyProperties(productDTO,productEntity);
        ProductEntity insertedProduct = productRepositories.save(productEntity);
        return insertedProduct;
    }

    @Override
    public ProductEntity get(String id) {
        return productRepositories.findOne(id);
    }

    @Override
    public ProductEntity getMiniProduct(String id) {
        ProductEntity productEntity=new ProductEntity();
        productEntity=productRepositories.findOne(id);
        ProductEntity miniProductEntity=new ProductEntity();
        miniProductEntity.setImageSrc(productEntity.getImageSrc());
        miniProductEntity.setProductId(productEntity.getProductId());
        miniProductEntity.setProductName(productEntity.getProductName());
        return  miniProductEntity;
    }
}
