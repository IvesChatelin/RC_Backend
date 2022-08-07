package com.example.rapidoscar_backend.repository;

import com.example.rapidoscar_backend.entity.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarqueRepository extends JpaRepository<Marque, Integer> {
}
