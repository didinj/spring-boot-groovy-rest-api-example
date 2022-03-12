package com.djamware.groovyrest.entity

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = 'product')
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    String prodName
    String prodDesc
    Double prodPrice
    String prodImageUrl

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = 'product'
    )
    List<Variant> variants
}
