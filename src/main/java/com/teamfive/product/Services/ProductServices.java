package com.teamfive.product.Services;


import com.teamfive.product.DTO.ProductDTO;
import com.teamfive.product.DTO.ratingUpdateKafkaMessage;
import com.teamfive.product.Entity.ProductEntity;
import com.teamfive.product.Repositories.ProductRepositories;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServices implements ProductInterface {


    @Autowired
    ProductRepositories productRepositories;

    private final double UPDATE_FACTOR=0.35;


    @Override
    public ProductEntity add(ProductDTO productDTO) {
        ProductEntity productEntity=new ProductEntity();
        BeanUtils.copyProperties(productDTO,productEntity);
        productEntity.setProductRating(2.5f);
        //productEntity.setRatingCount(0);
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

    @Override
    public ArrayList<ProductEntity> getByCategory(String category) {
        return  productRepositories.findByCategory(category);
    }

    @Override
    public void update(ProductEntity productEntity) {
        productRepositories.save(productEntity);
    }

    @KafkaListener(topics = "ORDER_RATING",group = "group_order_rating",containerFactory = "orderRatingKafkaListenerFactory")
    private void updateRating(ratingUpdateKafkaMessage ratingUpdateKafkaMessage)
    {
        ProductEntity productEntity=this.get(ratingUpdateKafkaMessage.getProductId());
        if(productEntity==null) return;
        double oldRating=productEntity.getProductRating();
        double recentRating=ratingUpdateKafkaMessage.getRating();
        double newRating= ((1-UPDATE_FACTOR)*oldRating) + UPDATE_FACTOR*recentRating;
        productEntity.setProductRating(newRating);
        this.update(productEntity);
        System.out.println(("UPDATED RATING FOR " + productEntity.getProductId() + " FROM " + oldRating + " TO " + newRating));
    }
}
