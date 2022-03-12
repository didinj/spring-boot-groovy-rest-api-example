package com.djamware.groovyrest.service.impl

import com.djamware.groovyrest.entity.Variant
import com.djamware.groovyrest.repository.IVariantRepository
import com.djamware.groovyrest.service.IVariantService
import org.springframework.beans.factory.annotation.Autowired

class VariantServiceImpl implements IVariantService {
    @Autowired
    IVariantRepository variantRepository

    @Override
    List<Variant> findAll() {
        variantRepository.findAll()
    }

    @Override
    Variant findById(Long variantId) {
        variantRepository.findById variantId get()
    }

    @Override
    Variant saveVariant(Variant variant){
        variantRepository.save variant
    }

    @Override
    Variant updateVariant(Long variantId, Variant variant){
        def existingVariant = findById(variantId)
        existingVariant.with {ep ->
            variantName = variant.variantName
            variantColor = variant.variantColor
            variantPrice = variant.variantPrice
        }
        variantRepository.save existingVariant
    }

    @Override
    Variant deleteVariant(Long variantId){
        variantRepository.deleteById variantId
    }
}
