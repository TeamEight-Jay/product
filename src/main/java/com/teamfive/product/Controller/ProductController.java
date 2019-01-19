package com.teamfive.product.Controller;


import com.teamfive.product.DTO.ProductDTO;
import com.teamfive.product.Entity.ProductEntity;
import com.teamfive.product.Services.ProductServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductServices productServices;

    @PostMapping("/product/add")
    public ProductDTO add(@RequestBody ProductDTO productDTO)
    {
        ProductEntity productEntity=new ProductEntity();
        productServices.add(productDTO);
        BeanUtils.copyProperties(productDTO,productEntity);
        return productDTO;
    }

    @GetMapping("/product/get")
    public ProductDTO get(@RequestParam String id){
        ProductEntity productEntity= productServices.get(id);
        ProductDTO productDTO=new ProductDTO();
        BeanUtils.copyProperties(productEntity,productDTO);
        return productDTO;
    }

    @GetMapping("product/getMini")
    public ProductDTO getMini(@RequestParam String id){
        ProductEntity productEntity=productServices.getMiniProduct(id);
        ProductDTO productDTO=new ProductDTO();
        BeanUtils.copyProperties(productEntity,productDTO);
        return productDTO;
    }


}
