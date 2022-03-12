package com.djamware.groovyrest.entity

import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table


@Entity
@Table(name = "variant")
class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    String variantName
    String variantColor
    Double variantPrice

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JsonIgnore
    Product product
}
