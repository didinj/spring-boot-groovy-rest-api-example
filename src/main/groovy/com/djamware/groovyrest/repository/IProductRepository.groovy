package com.djamware.groovyrest.repository

import com.djamware.groovyrest.entity.Product
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface IProductRepository extends PagingAndSortingRepository<Product, Long> {}