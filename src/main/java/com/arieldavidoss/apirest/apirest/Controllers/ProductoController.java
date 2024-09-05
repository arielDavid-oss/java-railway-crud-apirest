package com.arieldavidoss.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arieldavidoss.apirest.apirest.Repositories.ProductoRepository;
import com.arieldavidoss.apirest.apirest.Entities.Producto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/productos")
public class ProductoController {


    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return productoRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No se encontro el producto con id: " + id));
    }

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

            @PostMapping
            public Producto createProducto(@RequestBody Producto producto) {
                return productoRepository.save(producto);
            }



    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id,@RequestBody Producto productodetalle) {
        Producto producto = productoRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No se encontro el producto con id: " + id));

        producto.setNombre(productodetalle.getNombre());
        producto.setPrecio(productodetalle.getPrecio());
        return productoRepository.save(producto);
    }
    
    @DeleteMapping("/{id}")
    public String borrarproducto(@PathVariable Long id) {
        Producto producto = productoRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No se encontro el producto con id: " + id));

        productoRepository.delete(producto);    
        return "Producto " + id + " eliminado correctamente";    
    }
}
