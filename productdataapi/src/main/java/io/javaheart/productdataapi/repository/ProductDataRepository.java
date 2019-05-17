package io.javaheart.productdataapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.javaheart.productdataapi.model.ProductData;

@Repository
public interface ProductDataRepository extends JpaRepository<ProductData,Integer>{

}
