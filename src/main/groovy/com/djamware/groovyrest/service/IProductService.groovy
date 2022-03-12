package com.djamware.groovyrest.service

import com.djamware.groovyrest.entity.Product

interface IProductService {
    List<Product> findAll()

    Product findById(Long productId)

    Product saveProduct(Product product)

    Product updateProduct(Long productId, Product product)

    Product deleteProduct(Long productId)
}
