package com.teamfive.product.Repositories;

import com.teamfive.product.Entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepositories extends CrudRepository<ProductEntity,String >{


}
