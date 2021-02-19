package com.project.things.dao;

import com.project.things.entities.RelatedProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatedProductsRepository extends JpaRepository<RelatedProducts, Integer> {
}
