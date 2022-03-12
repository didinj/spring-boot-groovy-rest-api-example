package com.djamware.groovyrest.repository

import com.djamware.groovyrest.entity.Variant
import org.springframework.data.repository.CrudRepository

interface IVariantRepository extends CrudRepository<Variant, Long> {}