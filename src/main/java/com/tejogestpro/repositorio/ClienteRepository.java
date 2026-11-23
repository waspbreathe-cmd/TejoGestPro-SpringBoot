package com.tejogestpro.repositorio;

import com.tejogestpro.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio Spring Data JPA para operaciones CRUD sobre la entidad Cliente.
 * Hereda automaticamente save(), findAll(), findById(), deleteById(), entre otros.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}