package com.example.demo.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.orm.Feeding;

@Repository
public interface FeedingRepository extends JpaRepository<Feeding, Integer> {

}
