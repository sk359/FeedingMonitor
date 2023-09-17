package com.example.demo.model.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.orm.Base;
import com.example.demo.model.orm.StammBrand;
import com.example.demo.model.orm.StammProduct;
import com.example.demo.model.orm.StammProductTaste;


@Repository
public interface StammdatenRepository extends JpaRepository<Base, Integer> {
	
	@Query("SELECT b FROM StammBrand b")
	Collection<StammBrand> getAllBrands();
	
	@Query("SELECT b FROM StammBrand b WHERE b.id = :id ")
	StammBrand getBrandById(long id);
	
	@Query("SELECT b FROM StammProduct b")
	Collection<StammProduct> getAllProducts();
	
	@Query("SELECT b FROM StammProduct b WHERE b.id = :id ")
	StammProduct getProductById(long id);
	
	@Query("SELECT b FROM StammProductTaste b")
	Collection<StammProductTaste> getAllTastes();

}
