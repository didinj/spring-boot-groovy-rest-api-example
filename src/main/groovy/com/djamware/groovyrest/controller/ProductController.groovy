package com.djamware.groovyrest.controller

import com.djamware.groovyrest.entity.Product
import com.djamware.groovyrest.service.impl.ProductServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("product")
class ProductController {
    @Autowired
    ProductServiceImpl ProductService

    @GetMapping
    List<Product> getAllProductList(){
        ProductService.findAll()
    }

    @PostMapping
    Product saveProduct(@RequestBody Product product){
        ProductService.saveProduct product
    }

    @PutMapping('/{productId}')
    Product updateProduct(@PathVariable Long productId, @RequestBody Product product){
        ProductService.updateProduct productId, product
    }

    @DeleteMapping('/{productId}')
    deleteProduct(@PathVariable Long productId){
        ProductService.deleteProduct productId
    }

    @GetMapping('/{productId}')
    Product getProductById(@PathVariable Long productId){
        ProductService.findById productId
    }
}
