package com.djamware.groovyrest.service.impl

import com.djamware.groovyrest.entity.Product
import com.djamware.groovyrest.repository.IProductRepository
import com.djamware.groovyrest.service.IProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository productRepository

    @Override
    List<Product> findAll() {
        productRepository.findAll()
    }

    @Override
    Product findById(Long productId) {
        productRepository.findById productId get()
    }

    @Override
    Product saveProduct(Product product) {
        product.variants?.each { it.product = product }
        productRepository.save product
    }

    @Override
    Product updateProduct(Long productId, Product product){
        def existingProduct = findById(productId)
        existingProduct.with {ep ->
            prodName = product.prodName
            prodDesc = product.prodDesc
            prodPrice = product.prodPrice
            prodImageUrl = product.prodImageUrl
        }
        def variantsToRemove = []
        existingProduct.variants.each {
            def v = product.variants.find { vr -> vr.id == it.id }
            if (v == null) variantsToRemove.add(it)
            else it.variantName = v.variantName
        }
        existingProduct.variants.removeAll(variantsToRemove)
        product.variants.each {
            if (it.id == null) {
                it.product = existingProduct
                existingProduct.variants.add(it)
            }
        }
        productRepository.save existingProduct
    }

    @Override
    Product deleteProduct(Long productId){
        productRepository.deleteById productId
    }
}
