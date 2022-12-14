package com.example.shop.repository;

import com.example.shop.model.Footwear;
import com.example.shop.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FootwearRepository extends JpaRepository<Footwear, Integer> {
    List<Footwear> findByType(Type type);

}
