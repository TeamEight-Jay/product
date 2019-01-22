package com.teamfive.product.Repositories;

import com.teamfive.product.Entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface ProductRepositories extends CrudRepository<ProductEntity,String >{

    ArrayList<ProductEntity> findByCategory(String category);


}
