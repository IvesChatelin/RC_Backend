package com.example.rapidoscar_backend.repository;

import com.example.rapidoscar_backend.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categories, Integer> {
}
