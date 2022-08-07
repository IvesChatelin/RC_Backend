package com.example.rapidoscar_backend.repository;


import com.example.rapidoscar_backend.entity.Role;
import com.example.rapidoscar_backend.payload.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByNom(RoleName nom);
}
