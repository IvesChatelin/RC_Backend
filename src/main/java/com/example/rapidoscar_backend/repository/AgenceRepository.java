package com.example.rapidoscar_backend.repository;

import com.example.rapidoscar_backend.entity.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Integer> {

}
