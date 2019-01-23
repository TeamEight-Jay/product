package com.teamfive.product.Controller;


import com.teamfive.product.DTO.ProductDTO;
import com.teamfive.product.DTO.ProductUpdateKafkaMessage;
import com.teamfive.product.Entity.ProductEntity;
import com.teamfive.product.Services.ProductServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductServices productServices;


    @Autowired
    private KafkaTemplate<String,ProductUpdateKafkaMessage> kafkaTemplateProductUpdate;

    @PostMapping("/product/add")
    public ProductDTO add(@RequestBody ProductDTO productDTO)
    {
        ProductEntity productEntity=new ProductEntity();

        ProductEntity insertedProduct=productServices.add(productDTO);

        ProductDTO insertedDTO=new ProductDTO();
        BeanUtils.copyProperties(insertedProduct,insertedDTO);

        ProductUpdateKafkaMessage productUpdateKafkaMessage=new ProductUpdateKafkaMessage();
        productUpdateKafkaMessage.setAction("INSERT");
        productUpdateKafkaMessage.setProduct(insertedDTO);

        kafkaTemplateProductUpdate.send("PRODUCT",productUpdateKafkaMessage);

        return insertedDTO;
    }

    @RequestMapping(value = "/product/get/{id}",method = RequestMethod.GET)
    public ProductDTO get(@PathVariable String id){
        ProductEntity productEntity= productServices.get(id);
        if(productEntity==null) return null;
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

    @GetMapping("product/category/{category}")
    public List<ProductDTO> getCategoryList(@PathVariable String category)
    {
        Iterable<ProductEntity> productEntityList=productServices.getByCategory(category);
        List<ProductDTO> productDTOList=new ArrayList<ProductDTO>();
        for (ProductEntity p:productEntityList) {
            ProductDTO productDTO=new ProductDTO();
            BeanUtils.copyProperties(p,productDTO);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }


}
