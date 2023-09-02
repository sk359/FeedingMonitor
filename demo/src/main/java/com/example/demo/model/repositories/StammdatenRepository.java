package com.example.demo.model.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.orm.Base;
import com.example.demo.model.orm.StammBrand;


@Repository
public interface StammdatenRepository extends JpaRepository<Base, Integer> {
	
	@Query("SELECT b FROM StammBrand b")
	Collection<StammBrand> getAllBrands();

}
