package com.arieldavidoss.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arieldavidoss.apirest.apirest.Entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    

}
