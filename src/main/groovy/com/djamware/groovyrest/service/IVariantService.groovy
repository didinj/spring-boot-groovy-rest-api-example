package com.djamware.groovyrest.service


import com.djamware.groovyrest.entity.Variant

interface IVariantService {
    List<Variant> findAll()

    Variant findById(Long variantId)

    Variant saveVariant(Variant variant)

    Variant updateVariant(Long variantId, Variant variant)

    Variant deleteVariant(Long variantId)
}