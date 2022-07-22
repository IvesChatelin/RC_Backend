package com.example.rapidoscar_backend.repository;

import com.example.rapidoscar_backend.entity.Offrelocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffreRepository extends JpaRepository<Offrelocation, Integer> {
}
